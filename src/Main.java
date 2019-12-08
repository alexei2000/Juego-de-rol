import models.character.*;

public class Main{
    public static void main(String[] args){

        Wizard A = new Wizard("Harry", "human",17,20,80);
        Cleric C = new Cleric();

        C.printCharacterData();

        A.printCharacterData();
    }
}