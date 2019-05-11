package Vjezba;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;

public class ZipRead{
	
	
	public ZipRead() {
		
		
	
	}
	
	public void Read() {
		
		try(FileInputStream in=new FileInputStream("Streams.zip");
				ZipInputStream zip=new ZipInputStream(in)){
			
			int br=0;
			
			
			while(zip.available()!=0) {
				
				String[] str=new String[br+1];
				
				str[br]=zip.getNextEntry().getName();
				
				System.out.println(str[br]);
				br++;
				
			}
		}catch(NullPointerException e) {
			
			System.out.println("*****EOF!");
		}catch(IOException e) {
			
			e.printStackTrace();
		}
	}

}
