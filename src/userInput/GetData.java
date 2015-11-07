package userInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetData {
	// Variables.
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);

	/*-------------------------- METHODS AREA -------------------------------*/
	// GetString() Method.
	public static String GetString() {
		String str = null;
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	// GetInt() Method.
	public static int GetInt() {
		int num = -1;
		try {
			num = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
		} catch (IOException e) {
		}
		return num;
	}
}
