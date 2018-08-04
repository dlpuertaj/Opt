package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class TxtReader {
	
	public void readMultipleFiles() {
		File folder = new File("OMS/");
		File[] listOfFiles = folder.listFiles();
		
		try {
			PrintWriter writer = new PrintWriter(new File("OMSs.txt"));		

			for (File file : listOfFiles) {
				
			
				writer.println(file.getName().substring(0,4));
				
				Path path = Paths.get(file.getPath());
     
                Stream<String> lines;
                lines = Files.lines(path);
                
                lines.forEach(l -> {
                	writer.println(l);
                });
                writer.println();
                lines.close();
                
			}
			
			writer.close();
			
		} catch (IOException  | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TxtReader reader = new TxtReader();
		
		reader.readMultipleFiles();
		
	}

}
