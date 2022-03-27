import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Virologist v = new Virologist();
        Field f = new Field();
        Field f1 = new Field();

        System.out.println("1: Move");
        System.out.println("2: Use Agent");
        System.out.println("3: Pick up protection");
        System.out.println("4: Collect Nukleotid");
        System.out.println("5: Collect Aminoacid");
        System.out.println("6: Steal Protection");
        System.out.println("7: Tick");
        System.out.println("8: Steal Aminoacid");
        System.out.println("9: Learn Genetic Code");
        System.out.println("10: Self Use Agent");
        System.out.println("11: Create Agent");
        System.out.println("12: Glove");
        System.out.println("13: Init");
        System.out.println("14: Steal Nukleotid");
        System.out.println("15: Quit");

        Scanner scan = new Scanner(System.in);
        String choice;

        do {
            choice = scan.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("1: Move");
                    v.Move(f);
                    break;
                case "2":
                    System.out.println("2: Use Agent");
                    v.LookAround();
                    break;
                case "3":
                    System.out.println("3: Pick up protection");
                    v.GetItem();
                    break;
                case "4":
                    System.out.println("4: Collect Nukleotid");
                    v.CollectMaterial();
                    break;
                case "5":
                    System.out.println("5: Collect Aminoacid");
                    v.CollectMaterial();
                    break;
                case "6":
                    System.out.println("6: Steal Protection");

                    break;
                case "7":
                    System.out.println("7: Tick");
                    break;
                case "8":
                    System.out.println("8: Steal Aminoacid");
                    break;
                case "9":
                    System.out.println("9: Learn Genetic Code");
                    break;
                case "10":
                    System.out.println("10: Self Use Agent");
                    break;
                case "11":
                    System.out.println("11: Create Agent");
                    break;
                case "12":
                    System.out.println("12: Glove");
                    break;
                case "13":
                    System.out.println("13: Init");
                    break;
                case "14":
                    System.out.println("14: Steal Nukleotid");
                    break;
            }
        } while (!choice.equals("15"));

    }
}