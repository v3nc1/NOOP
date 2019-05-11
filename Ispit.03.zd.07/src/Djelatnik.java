import java.util.ArrayList;

public class Djelatnik {
	
	private int id;
	private String ime;
	private String prezime;
	private String odjel;
	private String ss;
	private String dodaci;
	
	
	public Djelatnik(int id, String ime, String prezime, String odjel, String ss,String dodaci) {
		
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.odjel = odjel;
		this.ss = ss;
		this.dodaci = dodaci;
	}


	public int getId() {
		return id;
	}


	public String getIme() {
		return ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public String getOdjel() {
		return odjel;
	}


	public String getSs() {
		return ss;
	}


	public String getDodaci() {
		return dodaci;
	}
	
	
	
	

}
