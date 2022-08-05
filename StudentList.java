import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println(Constants.ERROR_MESSAGE_WRONG_ARGUMENTS);
		} else {
			if (args[0].equals(Constants.CHAR_A)) {
				System.out.println(Constants.DATA_LOADING);
				try {
					String studentsNameInSingleString = readFromFile(Constants.FILE_NAME);
					String students[] = studentsNameInSingleString.split(Constants.COMMA_SIGN);
					for (String student : students) {
						System.out.println(student.trim());
					}
				} catch (Exception e) {

				}
				System.out.println(Constants.DATA_LOADED);
			} else if (args[0].equals(Constants.CHAR_R)) {
				System.out.println(Constants.DATA_LOADING);
				try {
					String studentsNameInSingleString = readFromFile(Constants.FILE_NAME);
					String students[] = studentsNameInSingleString.split(Constants.COMMA_SIGN);
					Random random = new Random();
					int randomIndexForStudentSelection = random.nextInt(students.length);
					System.out.println(students[randomIndexForStudentSelection].trim());
				} catch (Exception e) {

				}
				System.out.println(Constants.DATA_LOADED);
			} else if (args[0].contains(Constants.PLUS_SIGN)) {
				System.out.println(Constants.DATA_LOADING);
				try {
					String newStudent = args[0].substring(1);
					DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_MODEL);
					String formattedDateForOutput = dateFormat.format(new Date());
					writeInFile(", " + newStudent + Constants.LAST_UPDATE + formattedDateForOutput,
							Constants.FILE_NAME);
				} catch (Exception e) {

				}

				System.out.println(Constants.DATA_LOADED);
			} else if (args[0].contains(Constants.QUESTION_MARK)) {
				System.out.println(Constants.DATA_LOADING);
				try {
					String studentsNameInSingleString = readFromFile(Constants.FILE_NAME);
					String students[] = studentsNameInSingleString.split(Constants.COMMA_SIGN);
					boolean done = false;
					String searchedStudentName = args[0].substring(1);
					for (int index = 0; index < students.length && !done; index++) {
						if (students[index].equals(searchedStudentName)) {
							System.out.println(Constants.FOUND);
							break;
						}
					}
				} catch (Exception e) {

				}
				System.out.println(Constants.DATA_LOADED);
			} else if (args[0].contains(Constants.CHAR_C)) {
				System.out.println(Constants.DATA_LOADING);
				try {
					String studentsNameInSingleString = readFromFile(Constants.FILE_NAME);
					String students[] = studentsNameInSingleString.split(Constants.COMMA_AND_SPACE_SIGN);
					System.out.println(students.length + Constants.WORDS_FOUND);
				} catch (Exception e) {

				}
				System.out.println(Constants.DATA_LOADED);
			} else {
				System.out.println(Constants.ERROR_MESSAGE_WRONG_ARGUMENTS);
			}
		}
	}

	public static String readFromFile(String fileName) {
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileName)));
			String readLine = bufferedReader.readLine();
			bufferedReader.close();
			return readLine;
		} catch (Exception e) {
			System.out.println(Constants.ERROR_MESSAGE_READING);
		}
		return "";
	}

	public static void writeInFile(String writingText, String fileName) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter(fileName, true));
			bufferedWriter.write(writingText);
			bufferedWriter.close();
		} catch (Exception e) {
			System.out.println(Constants.ERROR_MESSAGE_WRITING);
		}
	}
}
