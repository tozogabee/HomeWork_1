package fileOperations;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReading {

	BufferedReader inputFile;
	
	public FileReading()
	{
		try {
			this.inputFile=new BufferedReader(new FileReader("poet.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		}
	}
	
	public void readLineByLine()
	{
		String str=null;
		try {
			while((str =  this.inputFile.readLine())!=null)
			{
				String body=str.replaceAll("==","\n");
				String pattern="(.*)-(.*)$";
				Pattern p=Pattern.compile(pattern);
				Matcher m=p.matcher(str);
				if(m.find())
				{		
					System.out.println(m.group(0));		
				}
				else
				{
					System.out.println(body);
				}	
				
			}
		} catch (IOException e) {
			System.err.println("There was an error in case of reading I/O error");
		}
	}
	
}
