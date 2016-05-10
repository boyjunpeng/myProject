package com.dream.test.vo;

public class Person {
    private String name = "boyjunpeng";
    private String age = "26";
    private String sex = "ÄÐ";
    private String email = "boyjunpeng@163.com";
    private String mobile = "13673617792";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + ", email=" + email + ", mobile=" + mobile
				+ "]";
	}
}
