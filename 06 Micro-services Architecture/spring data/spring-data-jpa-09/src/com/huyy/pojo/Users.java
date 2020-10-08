package com.huyy.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "t_users")
public class Users implements Serializable {
	@Id
					// strategy=GenerationType.IDENTITY自增长
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "userid")
	private Integer userid;

	@Column(name = "username")
	private String username;

	@Column(name = "userage")
	private Integer userage;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="roles_id")// @JoinColumn：就是维护一个外键
	private Roles roles;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getUserage() {
		return userage;
	}

	public void setUserage(Integer userage) {
		this.userage = userage;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username + ", userage=" + userage + ", roles=" + roles + "]";
	}

	

	
}
