import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;


public class Journal {

    public static Scanner input = new Scanner(System.in);
    public static final ZoneId timezone = ZoneId.of("Asia/Kuala_Lumpur");
    public static final ZonedDateTime now = ZonedDateTime.now(timezone);
    public static final LocalDate today = now.toLocalDate();

    private String date = "";
    private int lineNumber;
    private int countJournal = 1;
    private boolean isTodayNoJournal = false;

    int datePage(String email) {
        try {
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(email + "_journal.txt",true));
            Scanner inputStream = new Scanner(new FileInputStream(email + "_journal.txt"));
            System.out.println("=== Journal Dates ===");
            lineNumber = 0;
            while (inputStream.hasNextLine()) {
                lineNumber++;
                countJournal = lineNumber / 4 + 1;
                String currentLine = inputStream.nextLine();
                if (lineNumber % 4 == 1) {
                    System.out.print(countJournal + ". "+ currentLine);
                    date = currentLine;
                    if (date.equals(today.toString())) {
                        System.out.println(" (Today)");
                    } else System.out.println("");
                }
            }
            if (!date.equals(today.toString())) {
                System.out.println(countJournal + ". (No journal for today, create one!)");
                isTodayNoJournal = true;
            } else countJournal--;
            outputStream.close();
            inputStream.close();
        } 
        catch (IOException e) {
            System.out.println("Problem with file output"); 
        }
        return countJournal;
    }

    void journalPreviewPage(int journalDateNum, String email) {
        int dateLine = journalDateNum * 4 - 3;
        try {
            Scanner inputStream = new Scanner(new FileInputStream(email + "_journal.txt"));
            int lineNumber = 0;
            String content, date = "";
            while (inputStream.hasNextLine()) {
                lineNumber++;
                String currentLine = inputStream.nextLine();
                if (lineNumber == dateLine) {
                    date = currentLine;
                    break;
                }
            }
            if (isTodayNoJournal && journalDateNum == countJournal) {
                PrintWriter outputStream = new PrintWriter(new FileOutputStream(email + "_journal.txt",true));
                System.out.println("Enter your journal entry for " + today + ": ");
                outputStream.println(today);
                
            } else {
                System.out.println("=== Journal Entry for " + date + " ===");
            }


            
            inputStream.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("File was not found"); 
        } 
    }

}
