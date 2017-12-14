package org.eop.spring.mvc.mybatis.annotation.bean;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author lixinjie
 * @since 2017-08-19
 */
public class User {

	private Long id;
	@NotEmpty
	private String userName;
	@NotEmpty
	@Size(min = 6, max = 16)
	private String password;
	@Pattern(regexp = "")
	private String email;
	private Integer status;
	private Date registerTime;
	
	public User() {
		
	}
	
	public User(Long id, String userName, String password, Date registerTime) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.registerTime = registerTime;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
}
