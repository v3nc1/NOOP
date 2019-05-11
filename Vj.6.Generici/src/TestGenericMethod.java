import java.util.ArrayList;
import java.util.List;

public class TestGenericMethod {

	public static void main(String[] args) {
		
		Employee emp1=new Employee("Mujo", 40);
		Employee emp2=new Employee("Pale", 46);
		Employee emp3=new Employee("Jakov", 20);
		
		RetiredEmployee remp1=new RetiredEmployee("Toni", 72);
		RetiredEmployee remp2=new RetiredEmployee("Tonka", 40);
		

		List<Employee> employes=new ArrayList<>();
		List<RetiredEmployee> retEmps=new ArrayList<>();
		
		employes.add(emp1);
		employes.add(emp2);
		employes.add(emp3);
		
		retEmps.add(remp1);
		retEmps.add(remp2);
		
		System.out.println("Zaposleni-----------");
		for(Employee e:employes) {
			
			System.out.println(e.getName()+" "+e.getAge());
			
		}
		
		System.out.println("Umirovljeni------------");
		
		for(RetiredEmployee r:retEmps) {
			
			System.out.println(r.getName()+" "+r.getAge());
			
			employes.add(r);
		}
		
		System.out.println("Svi-----------");
		for(Employee e:employes) {
			
			System.out.println(e.getName()+" "+e.getAge()+" "+e.getClass());
		}
		
		
		

	}

}
