import java.util.Date;


public class LogEntryLogin extends LogEntry {
	String username,password;
	public LogEntryLogin(Date timestamp, int pid, String username, String password) {
		super(timestamp, pid);
		this.username=username;
		this.password=password;
	}

	@Override
	public String toString(){
	    StringBuilder ans= new StringBuilder();
	    ans.append(this.timestamp.toString());
	    ans.append(' ');
	    ans.append(this.pid);
	    ans.append(" LOGIN: ");
	    ans.append(username);
	    ans.append(' ');
	    ans.append(password);
	    return ans.toString();
	}
}
