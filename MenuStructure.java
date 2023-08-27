import java.util.Scanner;

public class MenuStructure {
    Scanner scanner = new Scanner(System.in);
    public void mainManu() {
        Local.mainLogo();
        System.out.println("1. Start\n2. Options\n3. Exit");
        while (true) {
            try {
                System.out.print("• Choose an option: ");
                int chooseOption = scanner.nextInt();
                if (chooseOption < 1 || chooseOption > 3) Local.notify(1);
                else break;
            } catch (java.util.InputMismatchException e) {
                Local.notify(1);
                scanner.nextLine();
            }
        }
    }
}