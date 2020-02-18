package com.spring.demo.employeedetails.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_EMPLOYEES")
public class EmployeeEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column()
	private String firstName;

	@Column()
	private String lastName;

	@Column(name = "email", nullable = false, length = 200)
	private String email;

//	public EmployeeEntity() {
//
//	}
//	public EmployeeEntity(String firstName, String lastName, String email) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}
}
