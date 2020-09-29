package life.pifrans.models;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public abstract class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String lastName;
	private String gender;
	private Integer age;
	private String email;
	private String password;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date currentAccess;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date lastAccess;
	private boolean isActive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCurrentAccess() {
		return currentAccess;
	}

	public void setCurrentAccess(Date currentAccess) {
		this.currentAccess = currentAccess;
	}

	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
