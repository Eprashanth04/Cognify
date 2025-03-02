import java.util.Scanner;

public class PasswordStrengthChecker {
    public static String checkPasswordStrength(String password) { 
        int len = password.length();
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digit = false;
        boolean specialChar = false;

        for (int i = 0; i < len; i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) upperCase = true;
            if (Character.isLowerCase(ch)) lowerCase = true;
            if (Character.isDigit(ch)) digit = true;
            if ("!@#$%^&*()_+".indexOf(ch) != -1) specialChar = true;
        }

        if (len >= 8 && upperCase && lowerCase && digit && specialChar) 
            return "Strong";
        else if (len > 6 && ((upperCase && lowerCase) || (lowerCase && digit) || (upperCase && digit)))
            return "Medium";
        else
            return "Weak";
    }

    public static void main(String[] args) { 
        Scanner s = new Scanner(System.in);
        System.out.print("Enter your Password: ");
        String password = s.nextLine();

        String strength = checkPasswordStrength(password); 
        System.out.println("Your password strength: " + strength);

        s.close();
    }
}
