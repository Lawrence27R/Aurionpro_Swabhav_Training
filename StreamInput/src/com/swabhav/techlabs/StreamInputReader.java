package com.swabhav.techlabs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamInputReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fileinputstream = new FileInputStream("D:\\Aurionpro\\StreamInput\\src\\com\\swabhav\\techlabs\\test");
		FileOutputStream fileoutputstream = new FileOutputStream("D:\\Aurionpro\\StreamInput\\src\\com\\swabhav\\techlabs\\test1");
		int ch;
		while( (ch = fileinputstream.read()) != -1) {
			fileoutputstream.write(ch);
		}
			System.out.println("File copied sucessfully");
		
		fileinputstream.close();
	}

}
