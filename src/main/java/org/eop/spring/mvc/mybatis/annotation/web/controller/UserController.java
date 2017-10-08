package org.eop.spring.mvc.mybatis.annotation.web.controller;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.eop.spring.mvc.mybatis.annotation.bean.User;
import org.eop.spring.mvc.mybatis.annotation.service.UserService;
import org.eop.spring.mvc.mybatis.annotation.web.result.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

/**
 * @author lixinjie
 * @since 2017-08-19
 */
@RequestMapping(path = "/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/get")
	public User getUser() {
		return new User(1010L, "李新杰-get", "000000", new Date());
	}
	
	@PostMapping("/post")
	public User postUser(@RequestBody User user) {
		user.setUserName(user.getUserName() + "-post");
		return user;
	}
	
	@PutMapping("/put")
	public User putUser(@RequestBody User user) {
		user.setUserName(user.getUserName() + "-put");
		return user;
	}
	
	@DeleteMapping("/delete")
	public User deleteUser(@RequestBody User user) {
		user.setUserName(user.getUserName() + "-delete");
		return user;
	}
	
	
	@PostMapping("/add")
	public RestResult<Object> addUser(@RequestBody User user, BindingResult bresult) {
		user.setStatus(1);
		Long userId = userService.saveUser(user);
		return new RestResult<Object>(10000, "success", userId);
	}
	
	@GetMapping("/list")
	public RestResult<Object> listUser() {
		List<User> users = userService.listAllUsers();
		return new RestResult<Object>(10000, "success", users);
	}
	
	@PutMapping("/edit")
	public RestResult<Object> editUser(@RequestBody User user, BindingResult bresult) {
		Long userId = userService.updateUser(user);
		return new RestResult<Object>(10000, "success", userId);
	}
	
	@DeleteMapping("/delete/{id:\\d+}")
	public RestResult<Object> deleteUser(@PathVariable("id")Long id) {
		Long userId = userService.removeUser(id);
		return new RestResult<Object>(10000, "success", userId);
	}
	
	@GetMapping("/page/{pageNum:\\d+}/{pageSize:\\d+}")
	public RestResult<Object> pageUser(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
		List<User> list = userService.listAllUsers(pageNum, pageSize);
		return new RestResult<Object>(10000, "success", list);
	}
	
	@GetMapping("/status/{status:\\d+}/page/{pageNum:\\d+}/{pageSize:\\d+}")
	public RestResult<Object> pageUser(@PathVariable("status") Integer status, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
		List<User> list1 = userService.listUsersByStatus(status, pageNum, pageSize);
		List<User> list3 = userService.listUsersByStatus(status, new RowBounds(pageNum, pageSize));
		new PageInfo<User>(list3);
		return new RestResult<Object>(10000, "success", new PageInfo<User>(list1));
	}
}
