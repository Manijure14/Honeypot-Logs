import java.util.ArrayList;

public class LogEntry {
    private ArrayList<String> lines;
    
    public LogEntry() {
        lines = new ArrayList<String>();
    }
    
    public void addLine(String line) {
        lines.add(line);
    }
    
    public String getLine(int index) {
        return lines.get(i);
    }
}
