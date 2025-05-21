package com.cafe.POJO;

import java.io.Serializable;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

import javax.persistence.*;

//@NamedQuery(name = "User.findByEmailId", query = "select u from User u where u.email=email")
//@NamedQuery(name = "User.findByEmailId", query = "select u from User u where u.email=email")
@NamedQuery(name = "User.findByEmailId", query = "select u from User u where u.email like: email")
@NamedQuery(name = "User.getAllUsers", query = "select new com.cafe.wrapper.UserWrapper(u.id,u.name,u.email,u.contactNumber,u.status) from User u where u.role='user'")
@NamedQuery(name = "User.updateStatus", query = "update User u set u.status=:status where u.id=:id")
@NamedQuery(name = "User.getAllAdmin", query = "select u.email from User u where u.role='admin'")
//@NamedQuery(name = "User.updateStatus", query = "update User u set u.status like: status where u.id like: id")

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user")
public class User implements Serializable{
	
	//"select u from User u where u.email=email
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="contactNumber")
	private String contactNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="status")
	private String status;
	
	@Column(name="role")
	private String role;
	
	

}
