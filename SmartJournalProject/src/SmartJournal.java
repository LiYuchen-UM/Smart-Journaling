import java.time.*;
import java.util.Scanner;

public class SmartJournal {

    private static final ZoneId timezone = ZoneId.of("Asia/Kuala_Lumpur");
    private static final ZonedDateTime now = ZonedDateTime.now(timezone);
    private static final Scanner input = new Scanner(System.in);
    private static final LocalDate today = now.toLocalDate();

    // 用户帐户和登录/注册页面
    public static void loginPage() {
        
    }

    // 登录成功后显示的欢迎页
    public static void welcomePage() {
        // 按时间显示不同的问候语
        ZonedDateTime fivePM = ZonedDateTime.of(LocalDate.now(timezone), LocalTime.of(17, 0), timezone);
        ZonedDateTime twelveAM = ZonedDateTime.of(LocalDate.now(timezone), LocalTime.of(12, 0), timezone);
        //System.out.println(now);
        if (now.isAfter(fivePM)) {
            System.out.println("\nGood Evening!");
        } else if (now.isAfter(twelveAM)) {
            System.out.println("\nGood Afternoon!");
        } else {
            System.out.println("\nGood Morning!");
        }
        // 主要功能菜单
        System.out.println("=== Main Menu ===");
        System.out.println("1. Create Journals");
        System.out.println("2. View Weekly Mood Summary");
        System.out.println("3. Log Out");
        System.out.print("\n> ");

        int choice = input.nextInt();
        switch (choice) {
            case 1:
                journalDatePage();
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
                welcomePage();
                break;
        }
    }

    // 选择日记时间页面
    public static void journalDatePage() {


        System.out.println("=== Journal Dates ===");
        int countJournal = 5; // 这里应该获取当前用户的日记篇数
        for (int i = 1; i <= countJournal; i++) { 
            System.out.println(i + ": " + today); // 应当为对应储存的日记日期
        }
        System.out.println("\nSelect a date to view journal, or create a new journal for today:");
        System.out.print("> ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                break;
            default:
                break;
        }
    }
    
    public static void journalEntryPage(String[] args) {
        
    }


    public static void main(String[] args) {
        welcomePage();
    }
}
