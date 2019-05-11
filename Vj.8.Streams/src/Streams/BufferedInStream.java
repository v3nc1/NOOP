package Streams;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedInStream {
	
	static int br;
	
	public BufferedInStream(){
		
	}
	
	public static void read() {
		
		br++;
		StringBuffer buffer = new StringBuffer();
		
		System.out.println("*****BufferReader***** call: "+br);
		
		try(FileInputStream myFile=new FileInputStream("xyz.dat");
				InputStreamReader inStream=new InputStreamReader(myFile,"UTF8");
					Reader reader= new BufferedReader(inStream)){
			
			int ch;
			
			while((ch=reader.read())>-1) {
				buffer.append((char)ch);
				
			}
			System.out.println(buffer.toString());
			
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
