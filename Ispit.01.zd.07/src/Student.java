import java.util.HashSet;
import java.util.Set;

public class Student {
	
	private String firstN;
	private String lastN;
	private int id;
	private String citizen;
	private String department;
	private static Set<Integer> idCollection=new HashSet<>();
	
	public Student(String firstN, String lastN, int id, String citizen, String department) {
		super();
		this.firstN = firstN;
		this.lastN = lastN;
		this.id = id;
		this.citizen = citizen;
		this.department = department;
	}

	public String getFirstN() {
		return firstN;
	}

	public String getLastN() {
		return lastN;
	}

	public int getId() {
		return id;
	}

	public String getCitizen() {
		return citizen;
	}

	public String getDepartment() {
		return department;
	}
	
	
	
	

	

}
