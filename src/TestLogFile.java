import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class TestLogFile {
    public static void main(String[] args) {
    
        File file;
        FileReader fd;
        BufferedReader rd=null;
        String file_path;
        String line;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Print out the file path.");
        file_path = input.nextLine();
        
        file = new File(file_path);
        try {
            fd = new FileReader(file);
            rd = new BufferedReader(fd);
        } catch (FileNotFoundException e) {
            throw new Error(e);
        }
        
        Session curSession = new Session();
        
        try {
			while ((line = rd.readLine()) != null) {
				String[] split = line.split(" ");

                if (split[2].equals("LOGIN:")) {
                    LogEntry entry = new LogEntry();
                    entry.putUsername(split[3]);
                    entry.putUsername(split[4]);
                    entry.addLine(line);
                    
                    curSession.addEntry(entry);
                }
			}

			for (int i = 0; i<curSession.getNumEntries(); i++) {
				System.out.println(curSession.getEntry(i).toString());
			}
			
			System.out.println("Number of entries: " + curSession.getNumEntries());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
