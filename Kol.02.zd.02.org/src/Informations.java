import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Informations {
	
	public static void start() {
		String hostname = "Unknown";

		try
		{
		    
			InetAddress addr;
		    addr = InetAddress.getLocalHost();
		    hostname = addr.getHostName();
		    // System.out.println("Host name: " + hostname);
		    String timeStamp = new SimpleDateFormat("dd-MM-yyyy --> HH:mm:ss").format(Calendar.getInstance().getTime());
		    // System.out.println("Date: " + timeStamp);
		    
		    writeInfoFile(hostname, timeStamp);
		}
		catch (UnknownHostException ex)
		{
		    System.out.println("Hostname can not be resolved");
		}
	}
	
	
	public static void writeInfoFile(String hName, String dt1) {
		
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("infoFile.txt")))){
			
			bw.write("Host: " + hName + "\n");
			bw.write("Date: " + dt1 + "\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void stop() {
		
		String dt2 = new SimpleDateFormat("dd-MM-yyyy --> HH:mm:ss").format(Calendar.getInstance().getTime());
		
		try{
			 dt2 = "Finished at: " + dt2 + "\n";
			 Files.write(Paths.get("infoFile.txt"), dt2.getBytes(), StandardOpenOption.APPEND);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}