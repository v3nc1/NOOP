package controler;

import java.util.List;

import GUI.FormDataObject;
import model.DataBase;
import model.Education;
import model.Employment;
import model.Region;
import model.User;

public class Controler {

	private DataBase dataBase;

	public Controler() {

		dataBase = new DataBase();

	}

	public void addUser(FormDataObject fdo) {

		String name = fdo.getName();
		String mail = fdo.getMail();
		String employment = fdo.getEmployment();
		String education = fdo.getEducation();
		String region = fdo.getRegion();
		
		Education edu=getEducation(education);
		Employment emp=getEmployment(employment);
		Region reg=getRegion(region);

		User user = new User(name, mail, emp, edu, reg);

		dataBase.addUser(user);
	}
	
	public List<User> getDataBase(){
		
		return dataBase.getUsers();
	}

	private Education getEducation(String edu) {

		switch (edu) {

		case ("Elementary school"):
			return Education.elementary;
			
		case ("Higher education"):
			return Education.higher;
			
		case ("Bachelor's degree"):
			return Education.bachelor;
			
		case ("PhD"):
			return Education.phd;
			
		default:
			return null;
		}

	}

	private Region getRegion(String reg) {

		switch (reg) {

		case ("North region"):
			return Region.north;
			
		case ("South region"):
			return Region.south;
			
		case ("East region"):
			return Region.east;
			
		case ("West region"):
			return Region.west;
			
		default:
			return null;
		}

	}

	private Employment getEmployment(String emp) {

		switch (emp) {

		case ("Employed"):
			return Employment.employed;
			
		case ("Unemployed"):
			return Employment.unemployed;
			
		}
		return null;
	}
}
