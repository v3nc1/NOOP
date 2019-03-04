package zd02;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class QuotesToFile {

	public void write(String quote) {

		try (BufferedWriter buff = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("quotes.txt", true), "UTF-8"))) {

			buff.append(quote);
			buff.newLine();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
