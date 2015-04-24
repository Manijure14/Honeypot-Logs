import java.util.Date;


public class LogEntryData extends LogEntry {
	String data;
	public LogEntryData(Date timestamp, int pid, String data) {
		super(timestamp, pid);
		this.data=data;
	}

	   @Override
	    public String toString(){
	        StringBuilder ans= new StringBuilder();
	        ans.append(this.timestamp.toString());
	        ans.append(' ');
	        ans.append(this.pid);
	        ans.append(" DATA: ");
	        ans.append(data);
	        return ans.toString();
	    }
}
