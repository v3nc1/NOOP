package Streams;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class InputStream {
	
	
	public InputStream(){
	}
	
	
	public static void read() {
		
		System.out.println("*****BufferInputStream*****");
	
		try(FileInputStream myFile=new FileInputStream("abc.dat");
				BufferedInputStream buff=new BufferedInputStream(myFile,2000)){

			boolean eof=false;

			while(!eof) {

				int byteValue=buff.read();

				
				System.out.print(byteValue+" ");
				

				if (byteValue==-1) {

					eof=true;
				}

			}

		}catch (IOException e) {

			System.out.println("Couldn't read file :"+e.toString());
			e.printStackTrace();
		}
	
		System.out.println("");
	}
}
