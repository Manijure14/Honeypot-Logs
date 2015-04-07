import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class Session {

	private ArrayList<LogEntry> log_entries;
	private int num_entries;
	

	public Session() {
		try {
			login_entries = new ArrayList<LogEntry>();
			num_entries = 0;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addEntry(LogEntry entry) {
		log_entries.add(entry);
		num_entries++;	
	}
	
	public LogEntry getEntry(int index) {
		return log_entries.get(index);
	}
	
	public int get_num_entries() {
		return num_entries;	
	}
}
