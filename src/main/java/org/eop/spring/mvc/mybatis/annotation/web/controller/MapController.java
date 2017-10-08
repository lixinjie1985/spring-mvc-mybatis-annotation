package org.eop.spring.mvc.mybatis.annotation.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lixinjie
 * @since 2017-08-28
 */
@RequestMapping(path = "/map", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
@RestController
public class MapController {

	@GetMapping(path = "/get")
	public Map<String, Object> getMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("int", 1010);
		map.put("string", "hello");
		map.put("bool", true);
		map.put("null", null);
		map.put("date", new Date());
		return map;
	}
	
	@PostMapping(path = "/post")
	public Map<String, Object> postMap(@RequestBody Map<String, Object> map) {
		map.put("int", 1010);
		map.put("string", "hello");
		map.put("bool", true);
		map.put("null", null);
		map.put("date", new Date());
		return map;
	}
	
	@PutMapping("/put")
	public Map<String, Object> putMap(@RequestBody Map<String, Object> map) {
		map.put("int", 1010);
		map.put("string", "hello");
		map.put("bool", true);
		map.put("null", null);
		map.put("date", new Date());
		return map;
	}
	
	@DeleteMapping("/delete")
	public Map<String, Object> deleteMap(@RequestBody Map<String, Object> map) {
		map.put("int", 1010);
		map.put("string", "hello");
		map.put("bool", true);
		map.put("null", null);
		map.put("date", new Date());
		return map;
	}
}
