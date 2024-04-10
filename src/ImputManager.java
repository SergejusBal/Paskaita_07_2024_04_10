import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ImputManager {

    private Scanner scanner;
    String[] skaiciai;

    ImputManager(){
        skaiciai = new String[2];
        scanner = new Scanner(System.in);
    }

    private int insertDigits() {
        System.out.println("Iveskite skaiciu:");
        int x = 0;
        try {
          x =  scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return insertDigits();
        }
        return x;
    }

    public String[] askForInput(){
        skaiciai[0] = insertDigits() + "";
        skaiciai[1] = insertDigits() + "";
        return skaiciai;
    }

    public boolean atsakymas() {
        while(true) {
            String scVerte = scanner.nextLine();
            if(scVerte.toUpperCase().equals("T")) return true;
            else if (scVerte.toUpperCase().equals("N")) return false;
        }

    }


}
