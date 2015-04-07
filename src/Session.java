import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class Session {

	private BufferedReader rd;
	private ArrayList<String> login_user;
	private ArrayList<String> login_password;

	public Session() {
		try {
			rd = new BufferedReader(new FileReader(
					"/Users/Everest/Desktop/FileTest"));
			login_user = new ArrayList<String>();
			login_password = new ArrayList<String>();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session s = new Session();

		String line;
		try {
			while ((line = s.rd.readLine()) != null) {
				line = line.substring(20);
				String[] split = line.split(" ");

				if (split[1].equals("LOGIN:") {
					s.login_user.add(split[2]);
					s.login_password.add(split[3]);
				}
			}

			for (int i = 0; i < s.login_user.size(); i++) {
				System.out.println(s.login_user.get(i) + " "
						+ s.login_password.get(i));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
