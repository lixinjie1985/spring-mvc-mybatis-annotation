package org.eop.spring.mvc.mybatis.annotation.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.eop.spring.mvc.mybatis.annotation.bean.User;
import org.eop.spring.mvc.mybatis.annotation.mapper.UserMapper;
import org.eop.spring.mvc.mybatis.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lixinjie
 * @since 2017-08-20
 */
@Service("userService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Transactional
	@Override
	public Long saveUser(User user) {
		userMapper.insertUser(user);
		return user.getId();
	}

	@Transactional
	@Override
	public Long updateUser(User user) {
		userMapper.updateUser(user);
		return user.getId();
	}

	@Transactional
	@Override
	public Long updateUserStatus(Long id, Integer status) {
		userMapper.updateUserStatus(id, status);
		return id;
	}

	@Transactional
	@Override
	public Long removeUser(Long id) {
		userMapper.deleteUser(id);
		return id;
	}

	@Override
	public User getUser(Long id) {
		return userMapper.selectUser(id);
	}

	@Override
	public User getUserByLogin(String userName, String password) {
		return userMapper.selectUserByLogin(userName, password);
	}

	@Override
	public List<User> listAllUsers() {
		return userMapper.selectUsers();
	}

	@Override
	public List<User> listAllUsers(int pageNum, int pageSize) {
		return userMapper.selectUsers(pageNum, pageSize);
	}
	
	@Override
	public List<User> listUsersByStatus(Integer status) {
		return userMapper.selectUsersByStatus(status);
	}
	
	@Override
	public List<User> listUsersByStatus(Integer status, int pageNum, int pageSize) {
		return userMapper.selectUsersByStatus(status, pageNum, pageSize);
	}
	
	@Override
	public List<User> listUsersByStatus(Integer status, RowBounds rowBounds) {
		return userMapper.selectUsersByStatus(status, rowBounds);
	}
}
