import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] mails = new String[]{"@gmail.com", "@mail.ru", "@yahoo.com", "@yandex.ru"};
        String alphabet = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        int minLength = 5;
        int maxLength = 15;
        StringBuilder account = new StringBuilder();
        System.out.println("How much accounts do you need?");
        Scanner scanner = new Scanner(System.in);
        int amountOfAccounts = scanner.nextInt();
        scanner.close();
        FileWriter writer = new FileWriter("accounts.txt", false);

        for(int k = 0; k < amountOfAccounts; ++k) {
            int i;
            for(i = 0; i < (int)((double)minLength + Math.random() * (double)maxLength); ++i) {
                account.append(alphabet.charAt((int)(Math.random() * (double)alphabet.length())));
            }

            account.append(mails[(int)(Math.random() * (double)mails.length)]).append(":");

            for(i = 0; i < (int)((double)minLength + Math.random() * (double)maxLength); ++i) {
                account.append(alphabet.charAt((int)(Math.random() * (double)alphabet.length())));
            }

            writer.append(String.valueOf(account)).append("\n");
            account.setLength(0);
        }

        writer.close();
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("notepad accounts.txt");
    }
}
