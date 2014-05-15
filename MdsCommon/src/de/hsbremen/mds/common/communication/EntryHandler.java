package de.hsbremen.mds.common.communication;

import java.util.List;
import java.util.Vector;

import org.json.JSONException;
import org.json.JSONObject;

import de.hsbremen.mds.common.exception.UnknownWhiteboardTypeException;
import de.hsbremen.mds.common.whiteboard.InvalidWhiteboardEntryException;
import de.hsbremen.mds.common.whiteboard.WhiteboardEntry;
import de.hsbremen.mds.common.whiteboard.WhiterboardUpdateObject;

public class EntryHandler {

	private EntryHandler() {

	}

	public static WhiterboardUpdateObject toObject(String message) {
		List<String> keys = new Vector<String>();
		WhiteboardEntry entry = null;
		try {
			JSONObject json = new JSONObject(message);

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

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return new WhiterboardUpdateObject(keys, entry);
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
			else
				throw new UnknownWhiteboardTypeException(entry.value.getClass()
						.getName());

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return json.toString();
	}
}
