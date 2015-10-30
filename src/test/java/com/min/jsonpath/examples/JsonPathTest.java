package com.min.jsonpath.examples;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {
	
	private String jsonContent;

	@Before
	public void setUp() {
		jsonContent = "{\n    \"coord\": {\n        \"lon\": 139,\n        \"lat\": 35\n    },\n    \"sys\": {\n        \"country\": \"JP\",\n        \"sunrise\": 1369769524,\n        \"sunset\": 1369821049\n    },\n    \"weather\": [\n        {\n            \"id\": 804,\n            \"main\": \"clouds\",\n            \"description\": \"overcast clouds\",\n            \"icon\": \"04n\"\n        }\n    ],\n    \"main\": {\n        \"temp\": 289.5,\n        \"humidity\": 89,\n        \"pressure\": 1013,\n        \"temp_min\": 287.04,\n        \"temp_max\": 292.04\n    },\n    \"wind\": {\n        \"speed\": 7.31,\n        \"deg\": 187.002\n    },\n    \"rain\": {\n        \"3h\": 0\n    },\n    \"clouds\": {\n        \"all\": 92\n    },\n    \"dt\": 1369824698,\n    \"id\": 1851632,\n    \"name\": \"Shuzenji\",\n    \"cod\": 200\n}";
	}
	
	/**
	 * Test reading value with JsonPath.
	 */
	@Test
	public void testReader() {
		int weatherId = JsonPath.read(jsonContent, "$.weather[0].id");
		assertEquals(804, weatherId);
	}
	
	/**
	 * Test setting value with JsonPath.
	 */
	@Test
	public void testSetter() {
		String jsonUpdated = JsonPath.parse(jsonContent).set("$.weather[0].id", 203).jsonString();
		int weatherId = JsonPath.read(jsonUpdated, "$.weather[0].id");
		assertEquals(203, weatherId);
	}


}
