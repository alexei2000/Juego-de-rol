package models.character;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Wizard extends Character{

    private static final ImageIcon sprite = new ImageIcon("../textures/wizard.jpg");
    private String[] spells;

    public Wizard(){

        super();
        this.spells = new String[4];

        for(int i=0 ; i<this.spells.length ; i++){
            this.spells[i]=" ";
        }
    }

    public Wizard(String name, String type, int damage, int intelligence, int hpm){

        super(name, type, damage, intelligence, hpm);
        this.spells = new String[4];

        for(int i=0;i<this.spells.length;i++){
            this.spells[i] = " ";
        }
    }

    //setter methods abstract
    @Override
    public void setDamage(){

        int dmRandom = (int) Math.floor(Math.random() * 16);

        this.damage = dmRandom;
        System.out.println("Se ha selcionado como Daño: " + this.damage + " pts");
    }

    @Override
    public void setDamage(int dm){

        if(dm>=0 && dm<=15){
            this.damage = dm;
        }
        else if(dm>15){
            this.damage = 15;
        }
        else if(dm<0){
            this.damage = 0;
        }
    }

    @Override
    public void setIntelligence(){

        int itgRandom = 17 + (int) Math.floor(Math.random() * 4);

        this.intelligence = itgRandom;
        System.out.println("Se ha selecionado como Inteligencia: " + this.intelligence + " pts");
    }

    @Override
    public void setIntelligence(int itg){

        if(itg>=17 && itg<=20){
            this.intelligence = itg;
        }
        else{
            if(itg<17){
                this.intelligence = 17;
            }
            else if(itg>20){
                this.intelligence = 20;
            }
        }
    }

    //other methods
    @Override
    public void printCharacterData(){

        String data = "Name: "+this.name+
                    "\nType: "+this.type+
                    "\nDamage: "+this.damage+" pts"+
                    "\nIntelligence: "+this.intelligence+" pts"+
                    "\nHealth Max: "+this.healthPointsMax+" pts"+
                    "\nCurrent Health: "+this.healthPoints+" pts";

        String dataSpells="\nSpells: ";

        for(String spell: this.spells){
            if(spell!=" "){
                dataSpells = dataSpells+spell+", ";
            }
            else{
                break;
            }
        }

        JOptionPane.showMessageDialog(null,data+dataSpells,"Wizard",1,Wizard.sprite);
    }

    public void learnSpell(String spell){

        boolean band = false;

        for(int i=0 ; i<this.spells.length && !band ; i++){
            if(this.spells[i]==" "){
                this.spells[i] = spell;
                band = true;
            }
        }

        if(!band){
            JOptionPane.showMessageDialog(null,"No puede aprender mas hechizos","Alert",0);
        }


    }

    public void spellSplash(Character ch){

        boolean band = false;
        ch.setHealthPoints(ch.getHealthPoints()-10);

        for(int i=0; i<this.spells.length && !band; i++){
            if(this.spells[i]==" "){
                this.spells[i-1] = " ";
                band = true;
            }
        }

        if(!band){
            this.spells[3] = " ";
        }
    }


}