import java.io.*;
import java.util.Scanner;

public class FileEncryptDrecrypt {

    public static String enc(String txt, int shift) {
        StringBuilder s = new StringBuilder();
        for (char c : txt.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shift) % 26 + base);
            }
            s.append(c);
        }
        return s.toString();
    }

    public static String dec(String txt, int shift) {
        return enc(txt, 26 - shift);
    }

    public static String read(String fName) throws IOException {
        StringBuilder s = new StringBuilder();
        Scanner sc = new Scanner(new File(fName));
        while (sc.hasNextLine()) s.append(sc.nextLine()).append("\n");
        sc.close();
        return s.toString();
    }

    public static void write(String fName, String txt) throws IOException {
        FileWriter w = new FileWriter(fName);
        w.write(txt);
        w.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Encrypt or Decrypt? (E/D): ");
        String opt = sc.nextLine().toUpperCase();

        System.out.print("File name: ");
        String fName = sc.nextLine();

        System.out.print("Shift value (1-25): ");
        int shift = sc.nextInt();
        sc.nextLine();

        try {
            String content = read(fName);
            String s = opt.equals("E") ? enc(content, shift) : dec(content, shift);
            String outFile = (opt.equals("E") ? "enc_" : "dec_") + fName;
            write(outFile, s);
            System.out.println("Done! Saved to " + outFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
