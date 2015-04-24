import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.Character;
import java.nio.channels.SeekableByteChannel;

/** TODO, Notes
 * We seem to have some log entries with a timestamp and PID before the timestamp and PID, such as
 * 101.logEx:28 "2015:04:09:00:01:07 633 2015:04:09:04:01:07 634 Received disconnect from 43.255.190.141: 11:  [preauth]"
 * 
 * These all appear to be due to a preauth disconnect, with a magnitude 1 difference between the 2 pids, so this is
 * probably a logic bug in the ssh-logging code, not a race condition. As we do not care about preauth disconnects, I am okay
 * with ignoring this.
 */
public class TestLogFile {

    final static String TEST_FILE_PATH = "/home/brandon/workspace/Honeypot Logs/101.logEx";
    static final SimpleDateFormat dateParser = new SimpleDateFormat(
            "yyyy:MM:dd:HH:mm:ss");

    public static void main(String[] args) throws ParseException {
        File file;
        FileReader fd;
        BufferedReader rd = null;
        String line;

        
        file = new File(TEST_FILE_PATH);
        try {
            fd = new FileReader(file);
            rd = new BufferedReader(fd);
        } catch (FileNotFoundException e) {
            throw new Error(e);
        }

        HashMap<Integer, Session> sessions = new HashMap<>();

        try {
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
                
                // All entries should have a timestamp, PID, and main entry
                String[] split = line.split(" ", 3);
                if (split.length < 3) {
                    continue;
                }

                String sTimestamp = split[0];
                String sPID = split[1];
                String suffix = split[2];

                Date timestamp;
                int PID;

                try {
                    timestamp = dateParser.parse(sTimestamp);
                } catch (ParseException e) {
                    System.err.println("Cannot parse timestamp: " + sTimestamp);
                    System.err.println(e);
                    continue;
                }
                try {
                    PID = Integer.parseInt(sPID);
                } catch (NumberFormatException e) {
                    System.err.println("Cannot parse PID: " + sPID);
                    System.err.println(e);
                    continue;
                }

                // All suffixes we care about should begin with a tag of the
                // form "TAG:" to indicate what type of entry they are
                split = suffix.split(":", 2);
                if (split.length < 2) {
                    continue;
                }
                String type = split[0];
                String data = split[1];

                LogEntry entry;
                if(type.equals("DATA")){
                    entry = new LogEntryData(timestamp,PID, data);
                }else if(type.equals("LOGIN")){
                    split=data.trim().split(" ");
                    if(split.length!=2){
                        System.err.println("Error parsing login information: "+data);
                        continue;
                    }
                    String username=split[0];
                    String password=split[1];
                    entry= new LogEntryLogin(timestamp, PID, username, password);
                }else{
                    System.err.println("Unrecognized tag: "+type);
                    continue;
                }
                Session s = sessions.get(PID);
                if(s==null){
                    s = new Session();
                    sessions.put(PID, s);
                }
                s.addEntry(entry);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
