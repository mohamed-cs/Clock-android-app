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
package com.example.clock.utils;

import com.example.clock.model.WorldClockTimeZone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

/**
 * Timezone to Country mapping
 * Generated from ICU4J http://site.icu-project.org/
 * 
 * NOTE - this is a subset of all {@link TimeZone#getAvailableIDs()}
 * Excluding random ones like SystemV
 * 
 * @author rahul
 *
 */
public class CountryTimeZone {

	private static Map<String, Country> tzCountryMap = new HashMap<String, Country>();
	
	static{		
		tzCountryMap.put("Europe/Andorra", Country.AD);
		tzCountryMap.put("Asia/Dubai", Country.AE);
		tzCountryMap.put("Asia/Kabul", Country.AF);
		tzCountryMap.put("America/Antigua", Country.AG);
		tzCountryMap.put("America/Anguilla", Country.AI);
		tzCountryMap.put("Europe/Tirane", Country.AL);
		tzCountryMap.put("Asia/Yerevan", Country.AM);
		tzCountryMap.put("NET", Country.AM);
		tzCountryMap.put("Africa/Luanda", Country.AO);
		tzCountryMap.put("Antarctica/Casey", Country.AQ);
		tzCountryMap.put("Antarctica/Davis", Country.AQ);
		tzCountryMap.put("Antarctica/DumontDUrville", Country.AQ);
		tzCountryMap.put("Antarctica/Macquarie", Country.AQ);
		tzCountryMap.put("Antarctica/Mawson", Country.AQ);
		tzCountryMap.put("Antarctica/McMurdo", Country.AQ);
		tzCountryMap.put("Antarctica/Palmer", Country.AQ);
		tzCountryMap.put("Antarctica/Rothera", Country.AQ);
		tzCountryMap.put("Antarctica/South_Pole", Country.AQ);
		tzCountryMap.put("Antarctica/Syowa", Country.AQ);
		tzCountryMap.put("Antarctica/Vostok", Country.AQ);
		tzCountryMap.put("AGT", Country.AR);
		tzCountryMap.put("America/Argentina/Buenos_Aires", Country.AR);
		tzCountryMap.put("America/Argentina/Catamarca", Country.AR);
		tzCountryMap.put("America/Argentina/ComodRivadavia", Country.AR);
		tzCountryMap.put("America/Argentina/Cordoba", Country.AR);
		tzCountryMap.put("America/Argentina/Jujuy", Country.AR);
		tzCountryMap.put("America/Argentina/La_Rioja", Country.AR);
		tzCountryMap.put("America/Argentina/Mendoza", Country.AR);
		tzCountryMap.put("America/Argentina/Rio_Gallegos", Country.AR);
		tzCountryMap.put("America/Argentina/Salta", Country.AR);
		tzCountryMap.put("America/Argentina/San_Juan", Country.AR);
		tzCountryMap.put("America/Argentina/San_Luis", Country.AR);
		tzCountryMap.put("America/Argentina/Tucuman", Country.AR);
		tzCountryMap.put("America/Argentina/Ushuaia", Country.AR);
		tzCountryMap.put("America/Buenos_Aires", Country.AR);
		tzCountryMap.put("America/Catamarca", Country.AR);
		tzCountryMap.put("America/Cordoba", Country.AR);
		tzCountryMap.put("America/Jujuy", Country.AR);
		tzCountryMap.put("America/Mendoza", Country.AR);
		tzCountryMap.put("America/Rosario", Country.AR);
		tzCountryMap.put("Pacific/Pago_Pago", Country.AS);
		tzCountryMap.put("Pacific/Samoa", Country.AS);
		tzCountryMap.put("US/Samoa", Country.AS);
		tzCountryMap.put("Europe/Vienna", Country.AT);
		tzCountryMap.put("ACT", Country.AU);
		tzCountryMap.put("AET", Country.AU);
		tzCountryMap.put("Australia/ACT", Country.AU);
		tzCountryMap.put("Australia/Adelaide", Country.AU);
		tzCountryMap.put("Australia/Brisbane", Country.AU);
		tzCountryMap.put("Australia/Broken_Hill", Country.AU);
		tzCountryMap.put("Australia/Canberra", Country.AU);
		tzCountryMap.put("Australia/Currie", Country.AU);
		tzCountryMap.put("Australia/Darwin", Country.AU);
		tzCountryMap.put("Australia/Eucla", Country.AU);
		tzCountryMap.put("Australia/Hobart", Country.AU);
		tzCountryMap.put("Australia/LHI", Country.AU);
		tzCountryMap.put("Australia/Lindeman", Country.AU);
		tzCountryMap.put("Australia/Lord_Howe", Country.AU);
		tzCountryMap.put("Australia/Melbourne", Country.AU);
		tzCountryMap.put("Australia/NSW", Country.AU);
		tzCountryMap.put("Australia/North", Country.AU);
		tzCountryMap.put("Australia/Perth", Country.AU);
		tzCountryMap.put("Australia/Queensland", Country.AU);
		tzCountryMap.put("Australia/South", Country.AU);
		tzCountryMap.put("Australia/Sydney", Country.AU);
		tzCountryMap.put("Australia/Tasmania", Country.AU);
		tzCountryMap.put("Australia/Victoria", Country.AU);
		tzCountryMap.put("Australia/West", Country.AU);
		tzCountryMap.put("Australia/Yancowinna", Country.AU);
		tzCountryMap.put("America/Aruba", Country.AW);
		tzCountryMap.put("Europe/Mariehamn", Country.AX);
		tzCountryMap.put("Asia/Baku", Country.AZ);
		tzCountryMap.put("Europe/Sarajevo", Country.BA);
		tzCountryMap.put("America/Barbados", Country.BB);
		tzCountryMap.put("Asia/Dacca", Country.BD);
		tzCountryMap.put("Asia/Dhaka", Country.BD);
		tzCountryMap.put("BST", Country.BD);
		tzCountryMap.put("Europe/Brussels", Country.BE);
		tzCountryMap.put("Africa/Ouagadougou", Country.BF);
		tzCountryMap.put("Europe/Sofia", Country.BG);
		tzCountryMap.put("Asia/Bahrain", Country.BH);
		tzCountryMap.put("Africa/Bujumbura", Country.BI);
		tzCountryMap.put("Africa/Porto-Novo", Country.BJ);
		tzCountryMap.put("America/St_Barthelemy", Country.BL);
		tzCountryMap.put("Atlantic/Bermuda", Country.BM);
		tzCountryMap.put("Asia/Brunei", Country.BN);
		tzCountryMap.put("America/La_Paz", Country.BO);
		tzCountryMap.put("America/Kralendijk", Country.BQ);
		tzCountryMap.put("America/Araguaina", Country.BR);
		tzCountryMap.put("America/Bahia", Country.BR);
		tzCountryMap.put("America/Belem", Country.BR);
		tzCountryMap.put("America/Boa_Vista", Country.BR);
		tzCountryMap.put("America/Campo_Grande", Country.BR);
		tzCountryMap.put("America/Cuiaba", Country.BR);
		tzCountryMap.put("America/Eirunepe", Country.BR);
		tzCountryMap.put("America/Fortaleza", Country.BR);
		tzCountryMap.put("America/Maceio", Country.BR);
		tzCountryMap.put("America/Manaus", Country.BR);
		tzCountryMap.put("America/Noronha", Country.BR);
		tzCountryMap.put("America/Porto_Acre", Country.BR);
		tzCountryMap.put("America/Porto_Velho", Country.BR);
		tzCountryMap.put("America/Recife", Country.BR);
		tzCountryMap.put("America/Rio_Branco", Country.BR);
		tzCountryMap.put("America/Santarem", Country.BR);
		tzCountryMap.put("America/Sao_Paulo", Country.BR);
		tzCountryMap.put("BET", Country.BR);
		tzCountryMap.put("Brazil/Acre", Country.BR);
		tzCountryMap.put("Brazil/DeNoronha", Country.BR);
		tzCountryMap.put("Brazil/East", Country.BR);
		tzCountryMap.put("Brazil/West", Country.BR);
		tzCountryMap.put("America/Nassau", Country.BS);
		tzCountryMap.put("Asia/Thimbu", Country.BT);
		tzCountryMap.put("Asia/Thimphu", Country.BT);
		tzCountryMap.put("Africa/Gaborone", Country.BW);
		tzCountryMap.put("Europe/Minsk", Country.BY);
		tzCountryMap.put("America/Belize", Country.BZ);
		tzCountryMap.put("America/Atikokan", Country.CA);
		tzCountryMap.put("America/Blanc-Sablon", Country.CA);
		tzCountryMap.put("America/Cambridge_Bay", Country.CA);
		tzCountryMap.put("America/Coral_Harbour", Country.CA);
		tzCountryMap.put("America/Creston", Country.CA);
		tzCountryMap.put("America/Dawson", Country.CA);
		tzCountryMap.put("America/Dawson_Creek", Country.CA);
		tzCountryMap.put("America/Edmonton", Country.CA);
		tzCountryMap.put("America/Glace_Bay", Country.CA);
		tzCountryMap.put("America/Goose_Bay", Country.CA);
		tzCountryMap.put("America/Halifax", Country.CA);
		tzCountryMap.put("America/Inuvik", Country.CA);
		tzCountryMap.put("America/Iqaluit", Country.CA);
		tzCountryMap.put("America/Moncton", Country.CA);
		tzCountryMap.put("America/Montreal", Country.CA);
		tzCountryMap.put("America/Nipigon", Country.CA);
		tzCountryMap.put("America/Pangnirtung", Country.CA);
		tzCountryMap.put("America/Rainy_River", Country.CA);
		tzCountryMap.put("America/Rankin_Inlet", Country.CA);
		tzCountryMap.put("America/Regina", Country.CA);
		tzCountryMap.put("America/Resolute", Country.CA);
		tzCountryMap.put("America/St_Johns", Country.CA);
		tzCountryMap.put("America/Swift_Current", Country.CA);
		tzCountryMap.put("America/Thunder_Bay", Country.CA);
		tzCountryMap.put("America/Toronto", Country.CA);
		tzCountryMap.put("America/Vancouver", Country.CA);
		tzCountryMap.put("America/Whitehorse", Country.CA);
		tzCountryMap.put("America/Winnipeg", Country.CA);
		tzCountryMap.put("America/Yellowknife", Country.CA);
		tzCountryMap.put("CNT", Country.CA);
		tzCountryMap.put("Canada/Atlantic", Country.CA);
		tzCountryMap.put("Canada/Central", Country.CA);
		tzCountryMap.put("Canada/East-Saskatchewan", Country.CA);
		tzCountryMap.put("Canada/Eastern", Country.CA);
		tzCountryMap.put("Canada/Mountain", Country.CA);
		tzCountryMap.put("Canada/Newfoundland", Country.CA);
		tzCountryMap.put("Canada/Pacific", Country.CA);
		tzCountryMap.put("Canada/Saskatchewan", Country.CA);
		tzCountryMap.put("Canada/Yukon", Country.CA);
		tzCountryMap.put("Indian/Cocos", Country.CC);
		tzCountryMap.put("Africa/Kinshasa", Country.CD);
		tzCountryMap.put("Africa/Lubumbashi", Country.CD);
		tzCountryMap.put("Africa/Bangui", Country.CF);
		tzCountryMap.put("Africa/Brazzaville", Country.CG);
		tzCountryMap.put("Europe/Zurich", Country.CH);
		tzCountryMap.put("Africa/Abidjan", Country.CI);
		tzCountryMap.put("Pacific/Rarotonga", Country.CK);
		tzCountryMap.put("America/Santiago", Country.CL);
		tzCountryMap.put("Chile/Continental", Country.CL);
		tzCountryMap.put("Chile/EasterIsland", Country.CL);
		tzCountryMap.put("Pacific/Easter", Country.CL);
		tzCountryMap.put("Africa/Douala", Country.CM);
		tzCountryMap.put("Asia/Chongqing", Country.CN);
		tzCountryMap.put("Asia/Chungking", Country.CN);
		tzCountryMap.put("Asia/Harbin", Country.CN);
		tzCountryMap.put("Asia/Kashgar", Country.CN);
		tzCountryMap.put("Asia/Shanghai", Country.CN);
		tzCountryMap.put("Asia/Urumqi", Country.CN);
		tzCountryMap.put("CTT", Country.CN);
		tzCountryMap.put("PRC", Country.CN);
		tzCountryMap.put("America/Bogota", Country.CO);
		tzCountryMap.put("America/Costa_Rica", Country.CR);
		tzCountryMap.put("America/Havana", Country.CU);
		tzCountryMap.put("Cuba", Country.CU);
		tzCountryMap.put("Atlantic/Cape_Verde", Country.CV);
		tzCountryMap.put("America/Curacao", Country.CW);
		tzCountryMap.put("Indian/Christmas", Country.CX);
		tzCountryMap.put("Asia/Nicosia", Country.CY);
		tzCountryMap.put("Europe/Nicosia", Country.CY);
		tzCountryMap.put("Europe/Prague", Country.CZ);
		tzCountryMap.put("Europe/Berlin", Country.DE);
		tzCountryMap.put("Africa/Djibouti", Country.DJ);
		tzCountryMap.put("Europe/Copenhagen", Country.DK);
		tzCountryMap.put("America/Dominica", Country.DM);
		tzCountryMap.put("America/Santo_Domingo", Country.DO);
		tzCountryMap.put("Africa/Algiers", Country.DZ);
		tzCountryMap.put("America/Guayaquil", Country.EC);
		tzCountryMap.put("Pacific/Galapagos", Country.EC);
		tzCountryMap.put("Europe/Tallinn", Country.EE);
		tzCountryMap.put("ART", Country.EG);
		tzCountryMap.put("Africa/Cairo", Country.EG);
		tzCountryMap.put("Egypt", Country.EG);
		tzCountryMap.put("Africa/El_Aaiun", Country.EH);
		tzCountryMap.put("Africa/Asmara", Country.ER);
		tzCountryMap.put("Africa/Asmera", Country.ER);
		tzCountryMap.put("Africa/Ceuta", Country.ES);
		tzCountryMap.put("Atlantic/Canary", Country.ES);
		tzCountryMap.put("Europe/Madrid", Country.ES);
		tzCountryMap.put("Africa/Addis_Ababa", Country.ET);
		tzCountryMap.put("EAT", Country.ET);
		tzCountryMap.put("Europe/Helsinki", Country.FI);
		tzCountryMap.put("Pacific/Fiji", Country.FJ);
		tzCountryMap.put("Atlantic/Stanley", Country.FK);
		tzCountryMap.put("Pacific/Chuuk", Country.FM);
		tzCountryMap.put("Pacific/Kosrae", Country.FM);
		tzCountryMap.put("Pacific/Pohnpei", Country.FM);
		tzCountryMap.put("Pacific/Ponape", Country.FM);
		tzCountryMap.put("Pacific/Truk", Country.FM);
		tzCountryMap.put("Pacific/Yap", Country.FM);
		tzCountryMap.put("Atlantic/Faeroe", Country.FO);
		tzCountryMap.put("Atlantic/Faroe", Country.FO);
		tzCountryMap.put("ECT", Country.FR);
		tzCountryMap.put("Europe/Paris", Country.FR);
		tzCountryMap.put("Africa/Libreville", Country.GA);
		tzCountryMap.put("Europe/Belfast", Country.GB);
		tzCountryMap.put("Europe/London", Country.GB);
		tzCountryMap.put("GB", Country.GB);
		tzCountryMap.put("GB-Eire", Country.GB);
		tzCountryMap.put("America/Grenada", Country.GD);
		tzCountryMap.put("Asia/Tbilisi", Country.GE);
		tzCountryMap.put("America/Cayenne", Country.GF);
		tzCountryMap.put("Europe/Guernsey", Country.GG);
		tzCountryMap.put("Africa/Accra", Country.GH);
		tzCountryMap.put("Europe/Gibraltar", Country.GI);
		tzCountryMap.put("America/Danmarkshavn", Country.GL);
		tzCountryMap.put("America/Godthab", Country.GL);
		tzCountryMap.put("America/Scoresbysund", Country.GL);
		tzCountryMap.put("America/Thule", Country.GL);
		tzCountryMap.put("Africa/Banjul", Country.GM);
		tzCountryMap.put("Africa/Conakry", Country.GN);
		tzCountryMap.put("America/Guadeloupe", Country.GP);
		tzCountryMap.put("Africa/Malabo", Country.GQ);
		tzCountryMap.put("Europe/Athens", Country.GR);
		tzCountryMap.put("Atlantic/South_Georgia", Country.GS);
		tzCountryMap.put("America/Guatemala", Country.GT);
		tzCountryMap.put("Pacific/Guam", Country.GU);
		tzCountryMap.put("Africa/Bissau", Country.GW);
		tzCountryMap.put("America/Guyana", Country.GY);
		tzCountryMap.put("Asia/Hong_Kong", Country.HK);
		tzCountryMap.put("Hongkong", Country.HK);
		tzCountryMap.put("America/Tegucigalpa", Country.HN);
		tzCountryMap.put("Europe/Zagreb", Country.HR);
		tzCountryMap.put("America/Port-au-Prince", Country.HT);
		tzCountryMap.put("Europe/Budapest", Country.HU);
		tzCountryMap.put("Asia/Jakarta", Country.ID);
		tzCountryMap.put("Asia/Jayapura", Country.ID);
		tzCountryMap.put("Asia/Makassar", Country.ID);
		tzCountryMap.put("Asia/Pontianak", Country.ID);
		tzCountryMap.put("Asia/Ujung_Pandang", Country.ID);
		tzCountryMap.put("Eire", Country.IE);
		tzCountryMap.put("Europe/Dublin", Country.IE);
		tzCountryMap.put("Asia/Jerusalem", Country.IL);
		tzCountryMap.put("Asia/Tel_Aviv", Country.IL);
		tzCountryMap.put("Israel", Country.IL);
		tzCountryMap.put("Europe/Isle_of_Man", Country.IM);
		tzCountryMap.put("Asia/Calcutta", Country.IN);
		tzCountryMap.put("Asia/Kolkata", Country.IN);
		tzCountryMap.put("IST", Country.IN);
		tzCountryMap.put("Indian/Chagos", Country.IO);
		tzCountryMap.put("Asia/Baghdad", Country.IQ);
		tzCountryMap.put("Asia/Tehran", Country.IR);
		tzCountryMap.put("Iran", Country.IR);
		tzCountryMap.put("Atlantic/Reykjavik", Country.IS);
		tzCountryMap.put("Iceland", Country.IS);
		tzCountryMap.put("Europe/Rome", Country.IT);
		tzCountryMap.put("Europe/Jersey", Country.JE);
		tzCountryMap.put("America/Jamaica", Country.JM);
		tzCountryMap.put("Jamaica", Country.JM);
		tzCountryMap.put("Asia/Amman", Country.JO);
		tzCountryMap.put("Asia/Tokyo", Country.JP);
		tzCountryMap.put("JST", Country.JP);
		tzCountryMap.put("Japan", Country.JP);
		tzCountryMap.put("Africa/Nairobi", Country.KE);
		tzCountryMap.put("Asia/Bishkek", Country.KG);
		tzCountryMap.put("Asia/Phnom_Penh", Country.KH);
		tzCountryMap.put("Pacific/Enderbury", Country.KI);
		tzCountryMap.put("Pacific/Kiritimati", Country.KI);
		tzCountryMap.put("Pacific/Tarawa", Country.KI);
		tzCountryMap.put("Indian/Comoro", Country.KM);
		tzCountryMap.put("America/St_Kitts", Country.KN);
		tzCountryMap.put("Asia/Pyongyang", Country.KP);
		tzCountryMap.put("Asia/Seoul", Country.KR);
		tzCountryMap.put("ROK", Country.KR);
		tzCountryMap.put("Asia/Kuwait", Country.KW);
		tzCountryMap.put("America/Cayman", Country.KY);
		tzCountryMap.put("Asia/Almaty", Country.KZ);
		tzCountryMap.put("Asia/Aqtau", Country.KZ);
		tzCountryMap.put("Asia/Aqtobe", Country.KZ);
		tzCountryMap.put("Asia/Oral", Country.KZ);
		tzCountryMap.put("Asia/Qyzylorda", Country.KZ);
		tzCountryMap.put("Asia/Vientiane", Country.LA);
		tzCountryMap.put("Asia/Beirut", Country.LB);
		tzCountryMap.put("America/St_Lucia", Country.LC);
		tzCountryMap.put("Europe/Vaduz", Country.LI);
		tzCountryMap.put("Asia/Colombo", Country.LK);
		tzCountryMap.put("Africa/Monrovia", Country.LR);
		tzCountryMap.put("Africa/Maseru", Country.LS);
		tzCountryMap.put("Europe/Vilnius", Country.LT);
		tzCountryMap.put("Europe/Luxembourg", Country.LU);
		tzCountryMap.put("Europe/Riga", Country.LV);
		tzCountryMap.put("Africa/Tripoli", Country.LY);
		tzCountryMap.put("Libya", Country.LY);
		tzCountryMap.put("Africa/Casablanca", Country.MA);
		tzCountryMap.put("Europe/Monaco", Country.MC);
		tzCountryMap.put("Europe/Chisinau", Country.MD);
		tzCountryMap.put("Europe/Tiraspol", Country.MD);
		tzCountryMap.put("Europe/Podgorica", Country.ME);
		tzCountryMap.put("America/Marigot", Country.MF);
		tzCountryMap.put("Indian/Antananarivo", Country.MG);
		tzCountryMap.put("Kwajalein", Country.MH);
		tzCountryMap.put("Pacific/Kwajalein", Country.MH);
		tzCountryMap.put("Pacific/Majuro", Country.MH);
		tzCountryMap.put("Europe/Skopje", Country.MK);
		tzCountryMap.put("Africa/Bamako", Country.ML);
		tzCountryMap.put("Africa/Timbuktu", Country.ML);
		tzCountryMap.put("Asia/Rangoon", Country.MM);
		tzCountryMap.put("Asia/Choibalsan", Country.MN);
		tzCountryMap.put("Asia/Hovd", Country.MN);
		tzCountryMap.put("Asia/Ulaanbaatar", Country.MN);
		tzCountryMap.put("Asia/Ulan_Bator", Country.MN);
		tzCountryMap.put("Asia/Macao", Country.MO);
		tzCountryMap.put("Asia/Macau", Country.MO);
		tzCountryMap.put("Pacific/Saipan", Country.MP);
		tzCountryMap.put("America/Martinique", Country.MQ);
		tzCountryMap.put("Africa/Nouakchott", Country.MR);
		tzCountryMap.put("America/Montserrat", Country.MS);
		tzCountryMap.put("Europe/Malta", Country.MT);
		tzCountryMap.put("Indian/Mauritius", Country.MU);
		tzCountryMap.put("Indian/Maldives", Country.MV);
		tzCountryMap.put("Africa/Blantyre", Country.MW);
		tzCountryMap.put("America/Bahia_Banderas", Country.MX);
		tzCountryMap.put("America/Cancun", Country.MX);
		tzCountryMap.put("America/Chihuahua", Country.MX);
		tzCountryMap.put("America/Ensenada", Country.MX);
		tzCountryMap.put("America/Hermosillo", Country.MX);
		tzCountryMap.put("America/Matamoros", Country.MX);
		tzCountryMap.put("America/Mazatlan", Country.MX);
		tzCountryMap.put("America/Merida", Country.MX);
		tzCountryMap.put("America/Mexico_City", Country.MX);
		tzCountryMap.put("America/Monterrey", Country.MX);
		tzCountryMap.put("America/Ojinaga", Country.MX);
		tzCountryMap.put("America/Santa_Isabel", Country.MX);
		tzCountryMap.put("America/Tijuana", Country.MX);
		tzCountryMap.put("Mexico/BajaNorte", Country.MX);
		tzCountryMap.put("Mexico/BajaSur", Country.MX);
		tzCountryMap.put("Mexico/General", Country.MX);
		tzCountryMap.put("Asia/Kuala_Lumpur", Country.MY);
		tzCountryMap.put("Asia/Kuching", Country.MY);
		tzCountryMap.put("Africa/Maputo", Country.MZ);
		tzCountryMap.put("Africa/Windhoek", Country.NA);
		tzCountryMap.put("Pacific/Noumea", Country.NC);
		tzCountryMap.put("Africa/Niamey", Country.NE);
		tzCountryMap.put("Pacific/Norfolk", Country.NF);
		tzCountryMap.put("Africa/Lagos", Country.NG);
		tzCountryMap.put("America/Managua", Country.NI);
		tzCountryMap.put("Europe/Amsterdam", Country.NL);
		tzCountryMap.put("Atlantic/Jan_Mayen", Country.NO);
		tzCountryMap.put("Europe/Oslo", Country.NO);
		tzCountryMap.put("Asia/Kathmandu", Country.NP);
		tzCountryMap.put("Asia/Katmandu", Country.NP);
		tzCountryMap.put("Pacific/Nauru", Country.NR);
		tzCountryMap.put("Pacific/Niue", Country.NU);
		tzCountryMap.put("NST", Country.NZ);
		tzCountryMap.put("NZ", Country.NZ);
		tzCountryMap.put("NZ-CHAT", Country.NZ);
		tzCountryMap.put("Pacific/Auckland", Country.NZ);
		tzCountryMap.put("Pacific/Chatham", Country.NZ);
		tzCountryMap.put("Asia/Muscat", Country.OM);
		tzCountryMap.put("America/Panama", Country.PA);
		tzCountryMap.put("America/Lima", Country.PE);
		tzCountryMap.put("Pacific/Gambier", Country.PF);
		tzCountryMap.put("Pacific/Marquesas", Country.PF);
		tzCountryMap.put("Pacific/Tahiti", Country.PF);
		tzCountryMap.put("Pacific/Port_Moresby", Country.PG);
		tzCountryMap.put("Asia/Manila", Country.PH);
		tzCountryMap.put("Asia/Karachi", Country.PK);
		tzCountryMap.put("PLT", Country.PK);
		tzCountryMap.put("Europe/Warsaw", Country.PL);
		tzCountryMap.put("Poland", Country.PL);
		tzCountryMap.put("America/Miquelon", Country.PM);
		tzCountryMap.put("Pacific/Pitcairn", Country.PN);
		tzCountryMap.put("America/Puerto_Rico", Country.PR);
		tzCountryMap.put("PRT", Country.PR);
		tzCountryMap.put("Asia/Gaza", Country.PS);
		tzCountryMap.put("Asia/Hebron", Country.PS);
		tzCountryMap.put("Atlantic/Azores", Country.PT);
		tzCountryMap.put("Atlantic/Madeira", Country.PT);
		tzCountryMap.put("Europe/Lisbon", Country.PT);
		tzCountryMap.put("Portugal", Country.PT);
		tzCountryMap.put("Pacific/Palau", Country.PW);
		tzCountryMap.put("America/Asuncion", Country.PY);
		tzCountryMap.put("Asia/Qatar", Country.QA);
		tzCountryMap.put("Indian/Reunion", Country.RE);
		tzCountryMap.put("Europe/Bucharest", Country.RO);
		tzCountryMap.put("Europe/Belgrade", Country.RS);
		tzCountryMap.put("Asia/Anadyr", Country.RU);
		tzCountryMap.put("Asia/Irkutsk", Country.RU);
		tzCountryMap.put("Asia/Kamchatka", Country.RU);
		tzCountryMap.put("Asia/Krasnoyarsk", Country.RU);
		tzCountryMap.put("Asia/Magadan", Country.RU);
		tzCountryMap.put("Asia/Novokuznetsk", Country.RU);
		tzCountryMap.put("Asia/Novosibirsk", Country.RU);
		tzCountryMap.put("Asia/Omsk", Country.RU);
		tzCountryMap.put("Asia/Sakhalin", Country.RU);
		tzCountryMap.put("Asia/Vladivostok", Country.RU);
		tzCountryMap.put("Asia/Yakutsk", Country.RU);
		tzCountryMap.put("Asia/Yekaterinburg", Country.RU);
		tzCountryMap.put("Europe/Kaliningrad", Country.RU);
		tzCountryMap.put("Europe/Moscow", Country.RU);
		tzCountryMap.put("Europe/Samara", Country.RU);
		tzCountryMap.put("Europe/Volgograd", Country.RU);
		tzCountryMap.put("W-SU", Country.RU);
		tzCountryMap.put("Africa/Kigali", Country.RW);
		tzCountryMap.put("Asia/Riyadh", Country.SA);
		tzCountryMap.put("Pacific/Guadalcanal", Country.SB);
		tzCountryMap.put("SST", Country.SB);
		tzCountryMap.put("Indian/Mahe", Country.SC);
		tzCountryMap.put("Africa/Khartoum", Country.SD);
		tzCountryMap.put("Europe/Stockholm", Country.SE);
		tzCountryMap.put("Asia/Singapore", Country.SG);
		tzCountryMap.put("Singapore", Country.SG);
		tzCountryMap.put("Atlantic/St_Helena", Country.SH);
		tzCountryMap.put("Europe/Ljubljana", Country.SI);
		tzCountryMap.put("Arctic/Longyearbyen", Country.SJ);
		tzCountryMap.put("Europe/Bratislava", Country.SK);
		tzCountryMap.put("Africa/Freetown", Country.SL);
		tzCountryMap.put("Europe/San_Marino", Country.SM);
		tzCountryMap.put("Africa/Dakar", Country.SN);
		tzCountryMap.put("Africa/Mogadishu", Country.SO);
		tzCountryMap.put("America/Paramaribo", Country.SR);
		tzCountryMap.put("Africa/Sao_Tome", Country.ST);
		tzCountryMap.put("America/El_Salvador", Country.SV);
		tzCountryMap.put("America/Lower_Princes", Country.SX);
		tzCountryMap.put("Asia/Damascus", Country.SY);
		tzCountryMap.put("Africa/Mbabane", Country.SZ);
		tzCountryMap.put("America/Grand_Turk", Country.TC);
		tzCountryMap.put("Africa/Ndjamena", Country.TD);
		tzCountryMap.put("Indian/Kerguelen", Country.TF);
		tzCountryMap.put("Africa/Lome", Country.TG);
		tzCountryMap.put("Asia/Bangkok", Country.TH);
		tzCountryMap.put("Asia/Dushanbe", Country.TJ);
		tzCountryMap.put("Pacific/Fakaofo", Country.TK);
		tzCountryMap.put("Asia/Dili", Country.TL);
		tzCountryMap.put("Asia/Ashgabat", Country.TM);
		tzCountryMap.put("Asia/Ashkhabad", Country.TM);
		tzCountryMap.put("Africa/Tunis", Country.TN);
		tzCountryMap.put("Pacific/Tongatapu", Country.TO);
		tzCountryMap.put("Asia/Istanbul", Country.TR);
		tzCountryMap.put("Europe/Istanbul", Country.TR);
		tzCountryMap.put("Turkey", Country.TR);
		tzCountryMap.put("America/Port_of_Spain", Country.TT);
		tzCountryMap.put("Pacific/Funafuti", Country.TV);
		tzCountryMap.put("Asia/Taipei", Country.TW);
		tzCountryMap.put("ROC", Country.TW);
		tzCountryMap.put("Africa/Dar_es_Salaam", Country.TZ);
		tzCountryMap.put("Europe/Kiev", Country.UA);
		tzCountryMap.put("Europe/Simferopol", Country.UA);
		tzCountryMap.put("Europe/Uzhgorod", Country.UA);
		tzCountryMap.put("Europe/Zaporozhye", Country.UA);
		tzCountryMap.put("Africa/Kampala", Country.UG);
		tzCountryMap.put("Pacific/Johnston", Country.UM);
		tzCountryMap.put("Pacific/Midway", Country.UM);
		tzCountryMap.put("Pacific/Wake", Country.UM);
		tzCountryMap.put("AST", Country.US);
		tzCountryMap.put("America/Adak", Country.US);
		tzCountryMap.put("America/Anchorage", Country.US);
		tzCountryMap.put("America/Atka", Country.US);
		tzCountryMap.put("America/Boise", Country.US);
		tzCountryMap.put("America/Chicago", Country.US);
		tzCountryMap.put("America/Denver", Country.US);
		tzCountryMap.put("America/Detroit", Country.US);
		tzCountryMap.put("America/Fort_Wayne", Country.US);
		tzCountryMap.put("America/Indiana/Indianapolis", Country.US);
		tzCountryMap.put("America/Indiana/Knox", Country.US);
		tzCountryMap.put("America/Indiana/Marengo", Country.US);
		tzCountryMap.put("America/Indiana/Petersburg", Country.US);
		tzCountryMap.put("America/Indiana/Tell_City", Country.US);
		tzCountryMap.put("America/Indiana/Vevay", Country.US);
		tzCountryMap.put("America/Indiana/Vincennes", Country.US);
		tzCountryMap.put("America/Indiana/Winamac", Country.US);
		tzCountryMap.put("America/Indianapolis", Country.US);
		tzCountryMap.put("America/Juneau", Country.US);
		tzCountryMap.put("America/Kentucky/Louisville", Country.US);
		tzCountryMap.put("America/Kentucky/Monticello", Country.US);
		tzCountryMap.put("America/Knox_IN", Country.US);
		tzCountryMap.put("America/Los_Angeles", Country.US);
		tzCountryMap.put("America/Louisville", Country.US);
		tzCountryMap.put("America/Menominee", Country.US);
		tzCountryMap.put("America/Metlakatla", Country.US);
		tzCountryMap.put("America/New_York", Country.US);
		tzCountryMap.put("America/Nome", Country.US);
		tzCountryMap.put("America/North_Dakota/Beulah", Country.US);
		tzCountryMap.put("America/North_Dakota/Center", Country.US);
		tzCountryMap.put("America/North_Dakota/New_Salem", Country.US);
		tzCountryMap.put("America/Phoenix", Country.US);
		tzCountryMap.put("America/Shiprock", Country.US);
		tzCountryMap.put("America/Sitka", Country.US);
		tzCountryMap.put("America/Yakutat", Country.US);
		tzCountryMap.put("CST", Country.US);
		tzCountryMap.put("IET", Country.US);
		tzCountryMap.put("Navajo", Country.US);
		tzCountryMap.put("PNT", Country.US);
		tzCountryMap.put("PST", Country.US);
		tzCountryMap.put("Pacific/Honolulu", Country.US);
		tzCountryMap.put("US/Alaska", Country.US);
		tzCountryMap.put("US/Aleutian", Country.US);
		tzCountryMap.put("US/Arizona", Country.US);
		tzCountryMap.put("US/Central", Country.US);
		tzCountryMap.put("US/East-Indiana", Country.US);
		tzCountryMap.put("US/Eastern", Country.US);
		tzCountryMap.put("US/Hawaii", Country.US);
		tzCountryMap.put("US/Indiana-Starke", Country.US);
		tzCountryMap.put("US/Michigan", Country.US);
		tzCountryMap.put("US/Mountain", Country.US);
		tzCountryMap.put("US/Pacific", Country.US);
		tzCountryMap.put("US/Pacific-New", Country.US);
		tzCountryMap.put("America/Montevideo", Country.UY);
		tzCountryMap.put("Asia/Samarkand", Country.UZ);
		tzCountryMap.put("Asia/Tashkent", Country.UZ);
		tzCountryMap.put("Europe/Vatican", Country.VA);
		tzCountryMap.put("America/St_Vincent", Country.VC);
		tzCountryMap.put("America/Caracas", Country.VE);
		tzCountryMap.put("America/Tortola", Country.VG);
		tzCountryMap.put("America/St_Thomas", Country.VI);
		tzCountryMap.put("America/Virgin", Country.VI);
		tzCountryMap.put("Asia/Ho_Chi_Minh", Country.VN);
		tzCountryMap.put("Asia/Saigon", Country.VN);
		tzCountryMap.put("VST", Country.VN);
		tzCountryMap.put("Pacific/Efate", Country.VU);
		tzCountryMap.put("Pacific/Wallis", Country.WF);
		tzCountryMap.put("MIT", Country.WS);
		tzCountryMap.put("Pacific/Apia", Country.WS);
		tzCountryMap.put("Asia/Aden", Country.YE);
		tzCountryMap.put("Indian/Mayotte", Country.YT);
		tzCountryMap.put("Africa/Johannesburg", Country.ZA);
		tzCountryMap.put("Africa/Lusaka", Country.ZM);
		tzCountryMap.put("Africa/Harare", Country.ZW);
		tzCountryMap.put("CAT", Country.ZW);		
		
		//non-country specific - assigning major country
		tzCountryMap.put("Etc/GMT+12", Country.XX);
		tzCountryMap.put("Etc/GMT+11", Country.XX);
		tzCountryMap.put("Etc/GMT+10", Country.XX);
		tzCountryMap.put("Etc/GMT+9", Country.XX);
		tzCountryMap.put("Etc/GMT+8", Country.XX);
		tzCountryMap.put("Etc/GMT+7", Country.XX);
		tzCountryMap.put("Etc/GMT+6", Country.XX);
		tzCountryMap.put("Etc/GMT+5", Country.XX);
		tzCountryMap.put("Etc/GMT+4", Country.XX);
		tzCountryMap.put("Etc/GMT+3", Country.XX);
		tzCountryMap.put("Etc/GMT+2", Country.XX);
		tzCountryMap.put("Etc/GMT+1", Country.XX);
		tzCountryMap.put("Etc/GMT", Country.XX);
		tzCountryMap.put("Etc/GMT+0", Country.XX);
		tzCountryMap.put("Etc/GMT-0", Country.XX);
		tzCountryMap.put("Etc/GMT-1", Country.XX);
		tzCountryMap.put("Etc/GMT-2", Country.XX);
		tzCountryMap.put("Etc/GMT-3", Country.XX);
		tzCountryMap.put("Etc/GMT-4", Country.XX);
		tzCountryMap.put("Etc/GMT-5", Country.XX);
		tzCountryMap.put("Etc/GMT-6", Country.XX);
		tzCountryMap.put("Etc/GMT-7", Country.XX);
		tzCountryMap.put("Etc/GMT-8", Country.XX);
		tzCountryMap.put("Etc/GMT-9", Country.XX);
		tzCountryMap.put("Etc/GMT-10", Country.XX);
		tzCountryMap.put("Etc/GMT-11", Country.XX);
		tzCountryMap.put("Etc/GMT-12", Country.XX);
		tzCountryMap.put("Etc/GMT-13", Country.XX);
		tzCountryMap.put("Etc/GMT-14", Country.XX);
	}
	
	public static Country getCountryForTimeZoneId(String timezoneId){
		if(tzCountryMap.containsKey(timezoneId)){
			return tzCountryMap.get(timezoneId);
		}
		//not found
		return Country.XX;
	}
	
	public static synchronized List<WorldClockTimeZone> getSupportedTimezones(){
		List<WorldClockTimeZone> allTimeZones = new ArrayList<WorldClockTimeZone>();
		Set<String> supportedZones = tzCountryMap.keySet();
		allTimeZones = new ArrayList<WorldClockTimeZone>(supportedZones.size());
		for (String tz : supportedZones) {
			allTimeZones.add(new WorldClockTimeZone(TimeZone.getTimeZone(tz)));
		}
		
		Collections.sort(allTimeZones, new Comparator<WorldClockTimeZone>() {
			public int compare(WorldClockTimeZone lhs, WorldClockTimeZone rhs) {
				return lhs.getId().compareTo(rhs.getId());
			}
		});
		
		return allTimeZones;
	}
}
