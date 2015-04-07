import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class TestLogFile {
    public static void main(String[] args) {
    
        File file;
        FileReader fd;
        BufferedReader rd;
        String file_path;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Print out the file path.");
        file_path = input.nextLine();
        
        file = new File(file_path);
        fd = new FileReader(file);
        rd = new BufferedReader(new FileReader());
    }
}
