import java.util.ArrayList;

public class LogEntry {
    private ArrayList<String> lines;
    private int num_lines = 0;
    
    public LogEntry() {
        lines = new ArrayList<String>();
    }
    
    public void addLine(String line) {
        lines.add(line);
        num_lines++;
    }
    
    public String getLine(int index) {
        return lines.get(i);
    }
    
    public String toString() {
        String str = "";
        
        for (int i = 0; i < num_lines; i++) {
            str += num_lines.get(i) + "\n";
        }
        
        return str;
    }
}
