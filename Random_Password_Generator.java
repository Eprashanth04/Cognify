import java.util.Random;
import java.util.Scanner;

public class Random_Password_Generator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialChars = scanner.nextLine().equalsIgnoreCase("y");

        String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecialChars);
        System.out.println("Generated Password: " + password);

        scanner.close();
    }

    public static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecialChars) {
        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()_+-=[]{}|;:'\",.<>?/";
        
        StringBuilder charset = new StringBuilder();
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        if (includeNumbers) charset.append(numbers);
        if (includeLowercase) charset.append(lowercase);
        if (includeUppercase) charset.append(uppercase);
        if (includeSpecialChars) charset.append(specialChars);

        if (charset.length() == 0) {
            return "Error: No character type selected!";
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charset.length());
            password.append(charset.charAt(randomIndex));
        }

        return password.toString();
    }
}
