package zadatak2;

public class Member {
	
	private String name;
	private Membership mbShip;
	
	public Member(String name) {
		
		this.name=name;
		mbShip=new BronzeMember();
		
	}
	
	public void showMembership() {
		
		System.out.println("Member "+name+"\nStatus: "+mbShip.memberStatus());
		System.out.println("--------------------");
	}
	
	public void setMembership(Membership mbs) {
		
		mbShip=mbs;
	}

}
