package de.hsbremen.mds.common.interpreterParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import de.hsbremen.mds.common.valueobjects.statemachine.MdsEvent;
import de.hsbremen.mds.common.valueobjects.statemachine.MdsItem;
import de.hsbremen.mds.common.whiteboard.Whiteboard;
import de.hsbremen.mds.common.whiteboard.WhiteboardEntry;

public class EventParser {
	
	public static boolean checkEvent(MdsEvent event, Whiteboard wb, double longitude, double latitude) {
		
		// alle mit Typ gameEvent
		if (event.getType().equals("gameEvent")) {
			if(event.getName().equals("nearby")) {
				int radius = Integer.parseInt(event.getParams().get("radius"));
				// alle Items durchgehen und gucken ob genug vorhanden sind
				int quanti = Integer.parseInt(event.getParams().get("quantifier"));
				if (checkLocationItems(wb, longitude, latitude, radius).size() >= quanti) {
					return true;
				}
			}
		// keine richtigen Events, "nur" Conditions
		} else if (event.getType().equals("condition")) {
			// get value and compValue
			double value = -1;
			double compValue = -2;
			try {  
			    value = Double.parseDouble(event.getParams().get("value"));  
			} catch(NumberFormatException nfe) {  
				// TODO: was wenn da dynamische Werte drin sind? 
			} 
			try {  
			    compValue = Double.parseDouble(event.getParams().get("compValue"));  
			} catch(NumberFormatException nfe) {  
				// TODO: was wenn da dynamische Werte drin sind? 
			} 
			
			// get checkType
			if (event.getParams().get("checkType").equals("==")) {
				if (value == compValue) {
					return true;
				}
			} else if (event.getParams().get("checkType").equals("<")) {
				if (value < compValue) {
					return true;
				}
			} else if (event.getParams().get("checkType").equals(">")) {
				if (value > compValue) {
					return true;
				}
			} else if (event.getParams().get("checkType").equals("<=")) {
				if (value <= compValue) {
					return true;
				}
			} else if (event.getParams().get("checkType").equals(">=")) {
				if (value >= compValue) {
					return true;
				}
			}
		}
		// wenn kein Event gestimmt hat
		return false;	
	}
	
	/**
	 * Pr�ft wieviele Items innerhalb eines vordefinierten Radius von einer Position vorhanden sind
	 * @param items
	 * @param loc
	 * @param radius
	 * @return Liste mit Items innerhalb des Radius
	 */
	private static List<WhiteboardEntry> checkLocationItems(Whiteboard wb, double longitude, double latitude, int radius ) {
		
		List<WhiteboardEntry> result = new Vector<WhiteboardEntry>();
		
		// Alle Items durchgehen
		for (String key : ((Whiteboard) wb.getAttribute("items").value).keySet()) {
			double longi = Double.parseDouble(""+ wb.getAttribute("items", key, "longitude").value);
			double lati = Double.parseDouble(""+ wb.getAttribute("items", key, "latitude").value);
			if(distanceInMeter(longitude, latitude, longi, lati) <= radius) {
				result.add(wb.getAttribute("items", key));
			}
		}
		return result;
		
	}
	
	
	
	private static double distanceInMeter(double p1long, double p1lat, double p2long, double p2lat){
		//Code von https://stackoverflow.com/questions/3715521/how-can-i-calculate-the-distance-between-two-gps-points-in-java
		double d2r = Math.PI / 180;
		double distance = 0;
		double dlong = (p2long - p1long) * d2r;
		double dlat = (p2lat - p1lat) * d2r;
		double a =
				Math.pow(Math.sin(dlat / 2.0), 2)
	            + Math.cos(p1lat * d2r)
	            * Math.cos(p2lat * d2r)
	            * Math.pow(Math.sin(dlong / 2.0), 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double d = 6367 * c;

	    return d;
	}
	
}
