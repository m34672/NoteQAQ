package test;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class TestGson {

	public static void main(String[] args) {

		Gson _gson = new Gson();
		
		Map map = new HashMap();
		map.put("name","安妮亞");
		map.put("age",18);
	
		System.out.println(_gson.toJson(map));
	}

}
