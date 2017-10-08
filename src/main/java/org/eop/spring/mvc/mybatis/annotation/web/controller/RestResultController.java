package org.eop.spring.mvc.mybatis.annotation.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eop.spring.mvc.mybatis.annotation.web.result.RestResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lixinjie
 * @since 2017-09-13
 */
@RequestMapping(path = "/result", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@RestController
public class RestResultController {

	@GetMapping("/map")
	public RestResult<Map<String, Object>> mapResult() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "李新杰");
		map.put("age", 32);
		map.put("married", true);
		map.put("phones", Arrays.asList("136", "138"));
		
		Map<String, Object> scores = new HashMap<>();
		scores.put("chinese", 135);
		scores.put("math", 140);
		map.put("scores", scores);
		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("2016", "1000");
		map1.put("2017", "1000");
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("2016", "1000");
		map2.put("2017", "1000");
		
		Map<String, Object> map3 = new HashMap<>();
		map3.put("2016", "1000");
		map3.put("2017", "1000");
		
		map.put("years", Arrays.asList(map1, map2, map3));
		
		return new RestResult<Map<String, Object>>(0, "success", map);
	}
	
	@GetMapping("/list")
	public RestResult<List<Map<String, Object>>> listResult() {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("2016", "1000");
		map1.put("2017", "1000");
		list.add(map1);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("2016", "1000");
		map2.put("2017", "1000");
		list.add(map2);
		Map<String, Object> map3 = new HashMap<>();
		map3.put("2016", "1000");
		map3.put("2017", "1000");
		list.add(map3);
		return new RestResult<List<Map<String, Object>>>(0, "success", list);
	}
	
	@PostMapping("/map")
	public RestResult<Map<String, Object>> mapParam(@RequestBody RestResult<Map<String, Object>> restResult) {
		return restResult;
	}
	
	@PostMapping("/list")
	public RestResult<List<Map<String, Object>>> listParam(@RequestBody RestResult<List<Map<String, Object>>> restResult) {
		return restResult;
	}
}
