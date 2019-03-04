package model;

public class User {
	
	
	private String name;
	private String mail;
	private Employment employment;
	private Education education;
	private Region region;
	private int id;
	private static int cnt=0;
	
	
	public User(String name, String mail, Employment employment, Education education, Region region) {
		super();
		this.name = name;
		this.mail = mail;
		this.employment = employment;
		this.education = education;
		this.region = region;
		id=cnt++;
	}


	public String getName() {
		return name;
	}


	public String getMail() {
		return mail;
	}


	public Employment getEmployment() {
		return employment;
	}


	public Education getEducation() {
		return education;
	}


	public Region getRegion() {
		return region;
	}


	public int getId() {
		return id;
	}
	
	

}
