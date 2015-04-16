import java.util.ArrayList;

public class LogEntry {
    private ArrayList<String> lines;
    private String username = "";
    private String password = "";
    private int num_lines = 0;
    
    public LogEntry() {
        lines = new ArrayList<String>();
    }
    
    public void addLine(String line) {
        lines.add(line);
        num_lines++;
    }
    
    public void putUsername(String username) {
        this.username = username;
    }
    
    public void putPassword(String password) {
        this.password = password;
    }
    
    public String getUserPassword(int index) {
        return username + " " + password;
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
