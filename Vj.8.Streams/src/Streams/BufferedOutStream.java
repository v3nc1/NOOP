package Streams;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class BufferedOutStream {
	
	public BufferedOutStream() {
		
	}
	
	
	public static void write() {
		
		
		
		try(FileOutputStream myFile=new FileOutputStream("xyz.dat");
				Writer out= new BufferedWriter(new OutputStreamWriter(myFile, "UTF8"))){
			
				String adress="Oko Vrulja bb, 23000 Zadar, Hrvatska";
				
				out.write(adress);
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
