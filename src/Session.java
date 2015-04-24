import java.util.ArrayList;

public class Session {

	private ArrayList<LogEntry> log_entries;
	private int num_entries;
	

	public Session() {
		log_entries = new ArrayList<LogEntry>();
		num_entries = 0;
	}
	
	public void addEntry(LogEntry entry) {
		log_entries.add(entry);
		num_entries++;	
	}
	
	public LogEntry getEntry(int index) {
		return log_entries.get(index);
	}
	
	public int getNumEntries() {
		return num_entries;	
	}
}
