package com.example.springboot;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@RestController
@RequestMapping("/api")
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "main";
	}

	@RequestMapping("/customers")
	public List<Map<String, Object>> index2() throws Exception {
		List<Map<String, Object>> array = new ArrayList<Map<String, Object>>();

		Map<String, Object> map;

		//Item 1
		map = new HashMap<String, Object>();
		map.put("station_name", "Station 1");
		map.put("buy_price", 25.25);
		map.put("sale_price", 36.35);

		array.add(map);

		//Item 2
		map = new HashMap<String, Object>();
		map.put("station_name", "Station 2");
		map.put("buy_price", 35.29);
		map.put("sale_price", 49.21);

		array.add(map);


		return array;

		/*JSONArray array = new JSONArray();

		JSONObject jsonObjectStation = new JSONObject();

		//item 1
		jsonObjectStation.put("StationName", "Station 1");
		jsonObjectStation.put("BuyPrice", 25.25 );
		jsonObjectStation.put("SellPrice", 29.60 );

		array.put(jsonObjectStation);

		//item 2

		jsonObjectStation.put( "StationName", "Station 2" );
		jsonObjectStation.put( "BuyPrice", 69.69 );
		jsonObjectStation.put( "SellPrice", 72.58);

		array.put(jsonObjectStation);
		return array;
		*/
		//return jsonObjectStation;

		//return "Greetings from hello method!";
		//String s = "[{ name:'ali', desc:'desc 1'}, {name:'asif', desc:'desc 2']";

		//return s;
	}
}
