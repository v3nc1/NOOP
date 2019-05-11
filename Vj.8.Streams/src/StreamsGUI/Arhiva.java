package StreamsGUI;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class Arhiva {
	
	public static Map<Integer,Tax> lista=new HashMap<>();
	
	
	public Arhiva() {
		
	}
	
	public static void puni(Integer cnt,Tax tax) {
		
		Arhiva.lista.put(cnt,tax);
		
		
	}
	
	public void ispis() {
		
		for(int ob:Arhiva.lista.keySet()) {
			
			
			System.out.println("*****************");
			System.out.println("No. Customer: "+ob);
			System.out.println("Grossincom: "+Arhiva.lista.get(ob).getGrossIncom());
			System.out.println("Dependents: "+Arhiva.lista.get(ob).getDependents());
			System.out.println("State: "+Arhiva.lista.get(ob).getState());
			System.out.println("Tax: "+Arhiva.lista.get(ob).calcTax()+"$");
			Tax.convertToEuros(Arhiva.lista.get(ob).calcTax());
		
		}
	}
	
	public void spremi() {
		
		try (FileOutputStream file=new FileOutputStream("tax.users.txt");
				Writer out=new BufferedWriter(new OutputStreamWriter(file))){
			
			for(int ob:Arhiva.lista.keySet()) {
				
				
				out.write("*****************");
				out.write("No. Customer: "+ob);
				out.write("Grossincom: "+Arhiva.lista.get(ob).getGrossIncom());
				out.write("Dependents: "+Arhiva.lista.get(ob).getDependents());
				out.write("State: "+Arhiva.lista.get(ob).getState());
				out.write("Tax: "+Arhiva.lista.get(ob).calcTax()+"$");
				out.write(Tax.convertToEuros(Arhiva.lista.get(ob).calcTax()));
			}
		
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public Map<Integer,Tax> getLista() {
		return lista;
	}

	public void setLista(Map<Integer,Tax> lista) {
		this.lista=lista;
	}
	
	

}
