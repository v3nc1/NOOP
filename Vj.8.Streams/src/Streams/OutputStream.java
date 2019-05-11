package Streams;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream {
		
	static int data[]= {84, 104, 105, 115, 32, 105, 115, 32, 97, 32, 116, 101, 115, 116, 32, 102, 105, 108, 101,33};
	
	public OutputStream(){
	
	}
	
	 public static void write(){
		
		try(FileOutputStream myFile=new FileOutputStream("xyz.dat")){
			
			for(int i:data) {
				
				myFile.write(i);
				
			}
			
			
			
		}catch(IOException e) {
			
			System.out.println("Couldn't write to file :"+e.toString());
		}
	}
	
	
}
