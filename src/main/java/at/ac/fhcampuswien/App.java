package at.ac.fhcampuswien;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordValidator pv = new PasswordValidator();
        String input = "";
        while (!input.equals("exit")) {
            input = scanner.nextLine();
            boolean result = pv.checkPassword(input);
            System.out.println(result);
        }
    }
}
