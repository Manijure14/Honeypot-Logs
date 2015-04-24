import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class LogEntry {
	Date timestamp;
	int pid;
	public LogEntry(Date timestamp, int pid){
		this.timestamp=timestamp;
		this.pid=pid;
	}
}
