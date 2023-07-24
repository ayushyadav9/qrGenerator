package com.qr.generator.entities;



public class User {

	private int id;

	private String first_name;
	private String last_name;

	private String email;
	private String phone;

	private String company;
	private String job;

	private String street;
	private String city;
	private Integer zip;
	private String state;
	private String country;

	private String linkedinURL;

	public User(int id, String first_name, String last_name, String email, String phone, String company, String job,
			String street, String city, Integer zip, String state, String country, String linkedinURL) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.company = company;
		this.job = job;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.country = country;
		this.linkedinURL = linkedinURL;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", phone=" + phone + ", company=" + company + ", job=" + job + ", street=" + street + ", city=" + city
				+ ", zip=" + zip + ", state=" + state + ", country=" + country + ", linkedinURL=" + linkedinURL + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLinkedinURL() {
		return linkedinURL;
	}

	public void setLinkedinURL(String linkedinURL) {
		this.linkedinURL = linkedinURL;
	}
	
	
	

}