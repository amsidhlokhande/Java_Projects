package com.amsidh.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLES")
public class UserRoles {

	@Id
	@GeneratedValue
	@Column(name = "ROLEID")
	private Integer roleId;
	@Column(name = "ROLE")
	private String role;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERNAME", nullable = false)
	private User user;
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}
