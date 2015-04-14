import java.util.ArrayList;

public class LogEntry {
    private ArrayList<String> lines;
    private ArrayList<String> usernames;
    private ArrayList<String> passwords;
    private int num_lines = 0;
    
    public LogEntry() {
        lines = new ArrayList<String>();
    }
    
    public void addLine(String line) {
        lines.add(line);
        num_lines++;
    }
    
    public void addUsername(String username) {
        usernames.add(username);
    }
    
    public void addPassword(String password) {
        passwords.add(password);
    }
    
    public String getUserPassword(int index) {
        return usernames.get(index) + " " + passwords.get(index);
    }
    
    public String getLine(int index) {
        return lines.get(index);
    }
    
    public String toString() {
        String str = "";
        
        for (int i = 0; i < num_lines; i++) {
            str += lines.get(i) + "\n";
        }
        
        return str;
    }
}
