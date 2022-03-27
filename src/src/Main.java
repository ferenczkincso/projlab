package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Virologist v = new Virologist();
        Virologist v2 = new Virologist();
        Field f = new Field();
        Field f1 = new Field();
        Nukleotid_storage ns = new Nukleotid_storage();
        Aminoacid_storage as = new Aminoacid_storage();
        Lab l = new Lab();
        Immunity i = new Immunity();
        GC_Forgetting gc_forgetting = new GC_Forgetting();
        GC_Immunity gc_immunity = new GC_Immunity();
        GC_Paralyze gc_paralyze = new GC_Paralyze();
        GC_Uncontrollable gc_uncontrollable = new GC_Uncontrollable();
        Game game = new Game();

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
        System.out.println("12: Init");
        System.out.println("13: Steal Nukleotid");
        System.out.println("14: Quit");

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
                    v.CollectMaterial(ns);
                    break;
                case "5":
                    System.out.println("5: Collect Aminoacid");
                    v.CollectMaterial(as);
                    break;
                case "6":
                    System.out.println("6: Steal Protection");
                    v2.StealItem();
                    break;
                case "7":
                    System.out.println("7: Tick");
                    v.Tick();
                    break;
                case "8":
                    System.out.println("8: Steal Aminoacid");
                    v2.StealAminoacid();
                    break;
                case "9":
                    System.out.println("9: Learn Genetic Code");
                    l.Learn_code(v);
                    break;
                case "10":
                    System.out.println("10: Self Use Agent");
                    i.Effect(v);
                    break;
                case "11":
                    System.out.println("11: Create Agent");
                    v.UseGeneticCode(gc_immunity);
                    v.UseGeneticCode(gc_paralyze);
                    v.UseGeneticCode(gc_forgetting);
                    v.UseGeneticCode(gc_uncontrollable);
                    break;
                case "12":
                    System.out.println("13: Init");
                    game.NewGame();
                    break;
                case "13":
                    System.out.println("14: Steal Nukleotid");
                    v2.StealNukleotid();
                    break;
            }
        } while (!choice.equals("14"));

    }
}