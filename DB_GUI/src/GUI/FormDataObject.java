package GUI;

import java.util.EventObject;

public class FormDataObject extends EventObject {
	
	private String name;
	private String mail;
	private String employment;
	private String education;
	private String region;
	
	
	public FormDataObject(Object object) {
		super(object);
		
	}


	public FormDataObject(Object arg0, String name, String mail, String employment, String education, String region) {
		super(arg0);
		this.name = name;
		this.mail = mail;
		this.employment = employment;
		this.education = education;
		this.region = region;
	}


	public String getName() {
		return name;
	}


	public String getMail() {
		return mail;
	}


	public String getEmployment() {
		return employment;
	}


	public String getEducation() {
		return education;
	}


	public String getRegion() {
		return region;
	}
	
	

}
