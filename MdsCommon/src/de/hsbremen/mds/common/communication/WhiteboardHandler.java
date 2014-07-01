package de.hsbremen.mds.common.communication;

import java.util.List;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.hsbremen.mds.common.exception.UnknownWhiteboardTypeException;
import de.hsbremen.mds.common.whiteboard.InvalidWhiteboardEntryException;
import de.hsbremen.mds.common.whiteboard.Whiteboard;
import de.hsbremen.mds.common.whiteboard.WhiteboardEntry;
import de.hsbremen.mds.common.whiteboard.WhiteboardUpdateObject;

public class WhiteboardHandler {

	private WhiteboardHandler() {

	}

	public static List<WhiteboardUpdateObject> toObject(String message) {

		List<WhiteboardUpdateObject> wb = new Vector<WhiteboardUpdateObject>();

		try {
			JSONObject json = new JSONObject(message);

			if (json.get("mode").equals("single")) {
				wb.add(toWhiteboardObject(message));
			} else if(json.get("mode").equals("full")){
				JSONArray arr = (JSONArray) json.get("data");
				for(int i = 0; i < arr.length(); i++){
					wb.add(toWhiteboardObject(arr.get(i).toString()));
				}
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return wb;
	}

	private static WhiteboardUpdateObject toWhiteboardObject(String message){

		JSONObject json = new JSONObject(message);
		List<String> keys = new Vector<String>();
		WhiteboardEntry entry = null;
		
		String path = json.getString("path");
		String visibility = json.getString("visibility");

		String vType = json.getString("valuetype");

		try {
			if (vType.equals(Integer.class.getName()))
				entry = new WhiteboardEntry(json.getInt("value"),
						visibility);
			else if (vType.equals(Long.class.getName()))
				entry = new WhiteboardEntry(json.getLong("value"),
						visibility);
			else if (vType.equals(Double.class.getName()))
				entry = new WhiteboardEntry(json.getDouble("value"),
						visibility);
			else if (vType.equals(Boolean.class.getName()))
				entry = new WhiteboardEntry(json.getBoolean("value"),
						visibility);
			else if (vType.equals(String.class.getName()))
				entry = new WhiteboardEntry(json.getString("value"),
						visibility);
		} catch (InvalidWhiteboardEntryException e) {
			// Falsche Objekte Ÿbergeben
			e.printStackTrace();
		}
		String[] parts = path.split(",");
		for (int i = 0; i < parts.length; i++) {
			keys.add(parts[i]);
		}
		return new WhiteboardUpdateObject(keys, entry);
	} 
	
	public static String toJson(List<String> keys, WhiteboardEntry entry)
			throws UnknownWhiteboardTypeException {

		JSONObject json = new JSONObject();

		String result = "";

		for (int i = 0; i < keys.size(); i++) {

			result += keys.get(i);

			if (i != keys.size() - 1)
				result += ",";
		}

		try {
			json.put("mode", "single");
			json.put("path", result);
			json.put("visibility", entry.visibility);
			json.put("valuetype", entry.value.getClass().getName());

			if (entry.value instanceof String)
				json.put("value", (String) entry.value);
			else if (entry.value instanceof Double)
				json.put("value", (Double) entry.value);
			else if (entry.value instanceof Integer)
				json.put("value", (Integer) entry.value);
			else if (entry.value instanceof Boolean)
				json.put("value", (Boolean) entry.value);
			else if (entry.value instanceof Long)
				json.put("value", (Long) entry.value);
			else if (entry.value instanceof Whiteboard) {
				Whiteboard wbEntry = (Whiteboard)entry.value;
				for(String key : wbEntry.keySet()) {
					keys.add(key);
					toJson(keys, wbEntry.get(key));
				}
			}
			else
				throw new UnknownWhiteboardTypeException(entry.value.getClass()
						.getName());

		} catch (JSONException e) {
			e.printStackTrace();
		}

		//System.out.println(json.toString());
		return json.toString();
	}

	public static String toJson(List<WhiteboardUpdateObject> wb)
			throws UnknownWhiteboardTypeException {

		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray();
		
		try {
			json.put("mode", "full");

			for (WhiteboardUpdateObject wuObj : wb) {
				arr.put(new JSONObject(toJson(wuObj.getKeys(), wuObj.getValue())));
			}

			json.put("data", arr);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		//System.out.println(json.toString());
		return json.toString();
	}
}
