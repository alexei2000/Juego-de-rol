import models.character.*;

public class Main{
    public static void main(String[] args){

        Wizard A = new Wizard("Harry", "human",17,20,80);
        Wizard B = new Wizard();
        Cleric C = new Cleric();

        A.printCharacterData();
        B.printCharacterData();
        C.printCharacterData();

        A.learnSpell("el charingan");
        A.learnSpell("coñazo en la frente");
        A.printCharacterData();

        A.spellSplash(B);

        A.printCharacterData();
        B.printCharacterData();

    }
}