package de.hsbremen.mds.common.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ObjectGsonConverter {
	
	public Object jsonStringToObject(String json) {

		Gson gson = new GsonBuilder().create();

		// TODO: für getClass() muss anscheinend die Klasse
		// in die das Objekt umgewandelt wird angegeben werden
		return gson.fromJson(json, getClass());
	}
	
	public String objectToJsonString(Object obj) {

		Gson gson = new GsonBuilder().create();

		System.out.println(gson.toJson(obj));

		return gson.toJson(obj);

	}
}
