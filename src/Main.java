import models.character.*;
import java.util.Scanner;

import javax.swing.JOptionPane; 

public class Main{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        //mago A

        Wizard A = new Wizard();

        System.out.println("Ingrese el nombre del Mago A: ");
        A.setName(scan.nextLine());

        System.out.println("Ingrese la raza del Mago A: ");
        A.setType(scan.nextLine());

        System.out.println("Ingrese el daño del Mago A: ");
        A.setDamage(scan.nextInt());

        System.out.println("Ingrese la inteligencia del Mago A: ");
        A.setIntelligence(scan.nextInt());

        System.out.println("Ingrese la vida maxima del Mago A: ");
        A.setHealthPointsMax(scan.nextInt());

        //mago B

        Wizard B = new Wizard();

        scan.nextLine();

        System.out.println("Ingrese el nombre del Mago B: ");
        B.setName(scan.nextLine());

        System.out.println("Ingrese la raza del Mago B: ");
        B.setType(scan.nextLine());

        System.out.println("Ingrese el daño del Mago B: ");
        B.setDamage(scan.nextInt());

        System.out.println("Ingrese la inteligencia del Mago B: ");
        B.setIntelligence(scan.nextInt());

        System.out.println("Ingrese la vida maxima del Mago B: ");
        B.setHealthPointsMax(scan.nextInt());

        //clerigo C

        Cleric C = new Cleric();

        scan.nextLine();

        System.out.println("Ingrese el nombre del Clerigo C: ");
        C.setName(scan.nextLine());

        System.out.println("Ingrese la raza del Clerigo C: ");
        C.setType(scan.nextLine());

        System.out.println("Ingrese el daño del Clerigo C: ");
        C.setDamage(scan.nextInt());

        System.out.println("Ingrese la inteligencia del Clerigo C: ");
        C.setIntelligence(scan.nextInt());

        System.out.println("Ingrese la vida maxima del Clerigo C: ");
        C.setHealthPointsMax(scan.nextInt());

        scan.nextLine();

        System.out.println("Ingrese el nombre del dios del Clerigo C: ");
        C.setGod(scan.nextLine());


        A.printCharacterData();
        B.printCharacterData();
        C.printCharacterData();

        A.learnSpell(JOptionPane.showInputDialog(null,"Ingrese el nuevo hechizo que el Mago A va aprender"));
        A.learnSpell(JOptionPane.showInputDialog(null,"Ingrese el segundo hechizo que el Mago A va aprender"));

        B.learnSpell(JOptionPane.showInputDialog(null,"Ingrese el nuevo hechizo que el Mago B va aprender"));

        A.printCharacterData();
        B.printCharacterData();

        A.spellSplash(B);
        B.spellSplash(A);
        C.heal(B);
        A.spellSplash(B);

        A.printCharacterData();
        B.printCharacterData();
        C.printCharacterData();

    }
}