import java.time.*;
import java.util.Scanner;

public class SmartJournal {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        
        // 根据时间显示问候
        ZoneId timezone = ZoneId.of("Asia/Kuala_Lumpur");
        ZonedDateTime now = ZonedDateTime.now(timezone);
        ZonedDateTime fivePM = ZonedDateTime.of(LocalDate.now(timezone), LocalTime.of(17, 0), timezone);
        ZonedDateTime twelveAM = ZonedDateTime.of(LocalDate.now(timezone), LocalTime.of(12, 0), timezone);
        // System.out.println(now);
        if (now.isAfter(fivePM)) {
            System.out.println("Good Evening!");
        } else if (now.isAfter(twelveAM)) {
            System.out.println("Good Afternoon!");
        } else {
            System.out.println("Good Morning!");
        }
        // 主要功能菜单
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Create Journals");
        System.out.println("2. View Weekly Mood Summary");
        System.out.println("3. Log Out");
        System.out.print("> ");

        int choice = input.nextInt();
        switch (choice) {
            case 1:
                // 日记功能
                break;
            case 2:
                // 心情总结功能
                break;
            case 3:
                System.out.println("Goodbye!");
                // 登出功能
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
