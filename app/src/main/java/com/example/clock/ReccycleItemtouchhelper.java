package com.example.clock;

import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clock.adapter.alarmadapter;

public class ReccycleItemtouchhelper  extends ItemTouchHelper.SimpleCallback {

    private alarmadapter adapter;

    public ReccycleItemtouchhelper(alarmadapter adapter)
    {
        super(0, ItemTouchHelper.LEFT| ItemTouchHelper.RIGHT);
        this.adapter=adapter;
    }

    public boolean onMove(RecyclerView recyclerView , RecyclerView.ViewHolder viewHolder , RecyclerView.ViewHolder target)
    {
        return false;
    }

    @Override
    public void onSwiped(final  RecyclerView.ViewHolder viewHolder , int direction)
    {
        final int position=viewHolder.getAdapterPosition();

        if(direction== ItemTouchHelper.LEFT) {
            adapter.Deletealarm(position);
        }
        else
        {
            adapter.edititem(position);
        }
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        Drawable icon;
        ColorDrawable background;

        View itemview=viewHolder.itemView;
        int backgroundcorneroffset=20;
        if(dX>0)
        {
            icon= ContextCompat.getDrawable(adapter.getContext(),R.drawable.ic_baseline_edit_24);
         background=new ColorDrawable(ContextCompat.getColor(adapter.getContext(),R.color.darkgray));
        }
        else
        {
            icon= ContextCompat.getDrawable(adapter.getContext(),R.drawable.ic_baseline_delete_outline_24);
            background=new ColorDrawable(ContextCompat.getColor(adapter.getContext(),R.color.darkgray));
        }
        int iconmargin=((itemview.getHeight()-icon.getIntrinsicHeight())/2 );
        int icontop=itemview.getTop()+(itemview.getHeight()-icon.getIntrinsicHeight())/2;
        int iconbottom=icontop+icon.getIntrinsicHeight();


        if(dX>0)
        {
            int iconleft=itemview.getLeft()+iconmargin;
            int iconright=itemview.getLeft()+iconmargin+icon.getIntrinsicWidth();
            icon.setBounds(iconleft,icontop,iconright,iconbottom);
            background.setBounds(itemview.getLeft(),itemview.getTop(),((int)dX)+backgroundcorneroffset,itemview.getBottom());
        }
        else if (dX<0)
        {
            int iconleft=itemview.getRight()-iconmargin-icon.getIntrinsicWidth();
            int iconright=itemview.getRight()-iconmargin;
            icon.setBounds(iconleft,icontop,iconright,iconbottom);
            background.setBounds(((int)dX)-backgroundcorneroffset,itemview.getTop(),itemview.getRight(),itemview.getBottom());
        }
        else
        {
            background.setBounds(0,0,0,0);
        }
        background.draw(c);
        icon.draw(c);
    }
}
