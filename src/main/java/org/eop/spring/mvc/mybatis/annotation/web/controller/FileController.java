package org.eop.spring.mvc.mybatis.annotation.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Part;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(path = "/file")
@RestController
public class FileController {

	//因该方法参数类型为Part，是Servlet 3.0的标准，必须使用StandardServletMultipartResolver来解析
	//@RequestPart使用HttpMessageConverter来进行参数类型转化
	@PostMapping(path = "/post0")
	public Map<String, Object> uploadFile0(@RequestPart("name") String name, @RequestPart("file") Part file) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("oname", file.getSubmittedFileName());
		map.put("size", file.getSize());
		map.put("contentType", file.getContentType());
		return map;
	}
	
	//因该方法参数类型为MultipartFile，是Spring自定义的，必须使用CommonsMultipartResolver来解析
	//@RequestParam使用Converter或PropertyEditor来进行参数类型转换
	@PostMapping(path = "/post")
	public Map<String, Object> uploadFile(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("oname", file.getOriginalFilename());
		map.put("size", file.getSize());
		map.put("contentType", file.getContentType());
		return map;
	}
}
