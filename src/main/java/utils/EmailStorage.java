package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EmailStorage {
	private static final String FILE_PATH = "testdata/user.txt";

    // Save generated email to file
    public static void saveEmail(String email) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(email);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read email back from file
    public static String getEmail() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
