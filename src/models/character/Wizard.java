package models.character;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Wizard extends Character{

    private static final ImageIcon sprite = new ImageIcon("../textures/wizard.jpg");
    private String[] spells;

    public Wizard(){
        super();
        this.spells = new String[4];
        for(int i=0;i<this.spells.length;i++){
            this.spells[i]=" ";
        }
    }

    public Wizard(String name, String type, int damage, int intelligence, int hpm){
        super(name, type, damage, intelligence, hpm);
        this.spells = new String[4];
        for(int i=0;i<this.spells.length;i++){
            this.spells[i]=" ";
        }
    }

    //setter methods abstract
    @Override
    public void setDamage(){
        int dmRandom = (int)Math.floor(Math.random()*16);
        this.damage = dmRandom;
    }

    @Override
    public void setDamage(int dm){
        if(dm>=0 && dm<=15){
            this.damage = dm;
        }
        else{
            this.damage = 15;
        }
    }

    @Override
    public void setIntelligence(){
        int itgRandom = 17 + (int)Math.floor(Math.random()*4);
        this.intelligence = itgRandom;
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
                    "\nHealt Max: "+this.healthPointsMax+" pts"+
                    "\nCurrent Healt: "+this.healthPoints+" pts";

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

        if(this.spells.length<4){
            for(int i=0;i<4;i++){
                if(this.spells[i]==" "){
                    this.spells[i]=spell;
                    break;
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"No puede aprender mas hechizos","Alert",0);
        }


    }

    public void splashSpell(Character ch){

        boolean band=false;
        ch.setHealthPoints(ch.getHealthPoints()-10);
        for(int i=0; i<4 && !band; i++){
            if(this.spells[i]==" "){
                this.spells[i-1]=" ";
                band=true;
            }
        }
        if(!band){
            this.spells[3]=" ";
        }
    }


}