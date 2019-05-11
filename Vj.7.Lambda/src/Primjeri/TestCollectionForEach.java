package Primjeri;

import java.util.Arrays;
import java.util.List;

import Primjeri.Person.Payable;

public class TestCollectionForEach {

	public static void main(String[] args) {
		
		Person worker[]=new Person[5];
		
		System.out.println(System.getProperty("user.dir"));
		
		worker[0]=new Person("Jakov", 'E');
		worker[1]=new Person("Mujo", 'C');
		worker[2]=new Person("Miro", 'E');
		worker[3]=new Person("Alaj",'F');
		worker[4]=new Person("Apu",'F');
		
		
		
		List<Person> workerList= Arrays.asList(worker);
		
		//Imperativna petlja
		
		System.out.println("****1. Running imperativ loop****");
		
		for(Person person:workerList) {
			
			if ('E'==person.getwStat()) {
				System.out.println(person.getName()+" is employee.");
			}else if('C'==person.getwStat()){
				System.out.println(person.getName()+" is contractor.");
			}else {
				System.out.println(person.getName()+" is foreigner.");
			}
		};
		
		//Funkcionalna petlja
		
		System.out.println("****2. Running functional loop****");
		
		workerList.forEach(person -> {
			if ('E'==person.getwStat()) {
				System.out.println(person.getName()+" is employee.");
			}else if('C'==person.getwStat()){
				System.out.println(person.getName()+" is contractor.");
			}else {
				System.out.println(person.getName()+" is foreigner.");
			}
		});
		
		System.out.println("*************************");
		System.out.println("****Provjera poveæanja plaæe****");
		//Lambda izraz za poveæanje plaæe stalno zaposlenih
		
		Payable increaseRulesEmployee = (int percent)->{
			return true;
		};
		
		//Lambda izraz za poveæanje plaæe vanjskim suradnicima 
		
		Payable increaseRulesContractor=(int percent)->{
			if(percent >Payable.increase_cap) {
				System.out.println("Sorry, can't increase hourly rate ba more than "+Payable.increase_cap+"%.");
				return false;
			}else {
				
				return true;
			}
		};
		
		Payable increaseRulesForeigner=(int percent)->{
			System.out.println("Sorry, foreigners can't get payment increase.");
			return false;
		};
		
		workerList.forEach(person->{
			if ('E'==person.getwStat()) {
				//provjera poveæanja od 30% za sve zaposlene
				person.validatePayIncrease(increaseRulesEmployee, 30);
			}else if('C'==person.getwStat()) {
				person.validatePayIncrease(increaseRulesContractor, 30);
			}else {
				person.validatePayIncrease(increaseRulesForeigner, 30);
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
