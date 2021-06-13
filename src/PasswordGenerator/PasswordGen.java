package PasswordGenerator;

import java.util.Random;
import java.util.Scanner;


/** Strong password Characteristics
 * the more characters, the better
 * A mixture of both uppercase and lowercase letters
 * A mixture of letters and numbers
 * Inclusion of special characters, e.g., ! @ # ? ]
 *
 */

public class PasswordGen {
    public static void main(String[] args) {
        PasswordGen passwordGen = new PasswordGen();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        System.out.println("----Password Generator----\nHit Enter for a new Password or Type Exit to exit: ");
        while (true) {
            password.delete(0,password.length());
            String exit = scanner.nextLine();
            if(exit.equalsIgnoreCase("EXIT")) {
                //do nothing
                System.out.println("Exit");
                break;
            }
            else {
                //give a random password
                for(int i = 0; i < 16; i++) {
                    //get what char to add
                    int typeOfChar = random.nextInt(3);

                    //get pos of char to add
                    int posOfChar = random.nextInt();

                    //make sure generated number is positive
                    while (posOfChar < 0) {
                        posOfChar = random.nextInt();
                    }

                    switch (typeOfChar) {
                        case 0 -> password.append(passwordGen.getUpper(posOfChar));
                        case 1 -> password.append(passwordGen.getLower(posOfChar));
                        case 2 -> password.append(passwordGen.getSpecial(posOfChar));
                    }
                }
                System.out.println(password);
            }
        }
    }

    public char getUpper(int i) {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length = upperCase.length() - 1;
        int position = i % length;
        return upperCase.charAt(position);
    }

    public char getLower(int i) {
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        int length = lowerCase.length() - 1;
        int position = i % length;
        return lowerCase.charAt(position);
    }

    public char getSpecial(int i) {
        String specialChar = "!@#$%^&*?+={}[]()-_.`~";
        int length = specialChar.length() - 1;
        int position = i % length;

        return specialChar.charAt(position);
    }
}