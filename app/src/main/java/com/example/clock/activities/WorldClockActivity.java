/*
 * Copyright (C) 2012 Rahul Agarwal
 *
 * This file is part of the World Clock
 * World Clock is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * World Clock is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with World Clock.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.example.clock.activities;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.clock.R;
import com.example.clock.TimeZoneEdit;
import com.example.clock.WorldClockException;
import com.example.clock.adapter.TimeZoneListAdapter;
import com.example.clock.model.WorldClockTimeZone;
import com.example.clock.utils.WorldClockData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.TimeZone;

/**
 * Main world clock activity
 * 
 * @author rahul
 * 
 */
public class WorldClockActivity extends Fragment {
	private static final String TAG = WorldClockActivity.class.getName();
	//
	//Intent extras map keys
	//IN - sent to edit dialog
	//OUT - received in onActivityResult
	//
	public static final String INTENT_TZ_DISPLAYNAME_IN = "INTENT_TZ_DISPLAYNAME_IN";
	public static final String INTENT_TZ_ID_IN = "INTENT_TZ_ID_IN";
	public static final String INTENT_TZ_DISPLAYNAME_OUT = "INTENT_TZ_DISPLAYNAME_OUT";
	public static final String INTENT_TZ_ID_OUT = "INTENT_TZ_ID_OUT";
	
	//Request codes for intent 
	private static final int REQ_CODE_ADD_ZONE = 0;
	private static final int REQ_CODE_EDIT_ZONE = 1;
		
	private WorldClockData data;
	private TimeZoneListAdapter adapter;
	private View view;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		 view=inflater.inflate(R.layout.worldclock_main,container,false);
		//init data
		data = new WorldClockData(getActivity());
		int listSize = refreshListView();

		// register to get context event to edit/delete
		ListView mainListView = (ListView)view.findViewById(R.id.main_list_view);
		registerForContextMenu(mainListView);

		FloatingActionButton mainAddButton = view.findViewById(R.id.main_button_add);
		mainAddButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				invokeAddZoneActivity();
			}
		});

		return view;
	}

	/** Called when the activity is first created. */


	/**
	 * Context menu to allow edit/delete of timezone
	 */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater =getActivity().getMenuInflater();
		inflater.inflate(R.menu.menu_timezone_edit, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
				.getMenuInfo();
		
		ListView mainListView = (ListView)view.findViewById(R.id.main_list_view);
		WorldClockTimeZone selectedTimeZone = (WorldClockTimeZone) mainListView.getAdapter().getItem(info.position);

		switch (item.getItemId()) {
		case R.id.menu_edit:
			// edit
			Intent editIntent = new Intent(Intent.ACTION_EDIT);
			editIntent.putExtra(INTENT_TZ_ID_IN, selectedTimeZone.getId());
			editIntent.putExtra(INTENT_TZ_DISPLAYNAME_IN, selectedTimeZone.getDisplayName());
			editIntent.setComponent(new ComponentName(getActivity(), TimeZoneEdit.class));
			startActivityForResult(editIntent, REQ_CODE_EDIT_ZONE);
			return true;
		case R.id.menu_delete:
			// delete
			data.deleteZone(selectedTimeZone);
			refreshListView();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intentReceived) {
		Log.d(TAG, "activity requestcode="+requestCode+" resultCode="+resultCode+ "data="+intentReceived);
		//process response from add/edit activity
		if(resultCode==getActivity().RESULT_OK){
			switch(requestCode){
			case REQ_CODE_ADD_ZONE:
				Log.d(TAG, "Add zone id"+intentReceived.getStringExtra(INTENT_TZ_ID_OUT)+ " name="+intentReceived.getStringExtra(INTENT_TZ_DISPLAYNAME_OUT));
				data.addZone(new WorldClockTimeZone(TimeZone.getTimeZone(intentReceived.getStringExtra(INTENT_TZ_ID_OUT)),intentReceived.getStringExtra(INTENT_TZ_DISPLAYNAME_OUT)));
				break;
			case REQ_CODE_EDIT_ZONE:
				Log.d(TAG, "EDIT - Remove zone id"+intentReceived.getStringExtra(INTENT_TZ_ID_IN)+ " name="+intentReceived.getStringExtra(INTENT_TZ_DISPLAYNAME_IN));
				Log.d(TAG, "EDIT - Add zone id"+intentReceived.getStringExtra(INTENT_TZ_ID_OUT)+ " name="+intentReceived.getStringExtra(INTENT_TZ_DISPLAYNAME_OUT));
				data.deleteZone(new WorldClockTimeZone(TimeZone.getTimeZone(intentReceived.getStringExtra(INTENT_TZ_ID_IN))));
				data.addZone(new WorldClockTimeZone(TimeZone.getTimeZone(intentReceived.getStringExtra(INTENT_TZ_ID_OUT)),intentReceived.getStringExtra(INTENT_TZ_DISPLAYNAME_OUT)));
				break;
			default:
				throw new WorldClockException("Unsupported request code!");
			}
		}
		
		//refresh data 
		refreshListView();		
		super.onActivityResult(requestCode, resultCode, intentReceived);
	}

	/**
	 * Present options menu to add timezones
	 */
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		MenuInflater inflater = getMenuInflater();
//		inflater.inflate(R.menu.menu_main, menu);
//		return true;
//	}

	/**
	 * Handle menu item selects
	 */



	private void invokeAddZoneActivity() {
		Intent intent = new Intent(Intent.ACTION_INSERT);
		intent.setComponent(new ComponentName(getActivity(), TimeZoneEdit.class));
		startActivityForResult(intent, REQ_CODE_ADD_ZONE);
	}
	
	/**
	 * Refresh list of timezones
	 * @return number of items in list after refresh
	 */
	private int refreshListView() {
		WorldClockTimeZone[] values = data.getSavedTimeZones().toArray(
				new WorldClockTimeZone[] {});

		Log.d(TAG, "Loaded data size for refresh:" + values.length);

		adapter = new TimeZoneListAdapter(getActivity(), values);
		
		ListView mainListView = (ListView)view.findViewById(R.id.main_list_view);
		mainListView.setAdapter(adapter);
		adapter.notifyDataSetChanged();		
		return values.length;
	}
}