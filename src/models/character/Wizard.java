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
        else{
            JOptionPane.showMessageDialog(null,this.name+" ha aprendido "+spell,"Ataque de "+"Hechizo aprendido",1);
        }


    }

    public void spellSplash(Character ch){

        boolean band = false;
        String spell="";

        if(this.spells[0]==" "){
            JOptionPane.showMessageDialog(null,this.name+" no conoce ningun hechizo","Alert",0);
        }
        else{
            ch.setHealthPoints(ch.getHealthPoints()-10);

            for(int i=1; i<this.spells.length && !band; i++){
                if(this.spells[i]==" "){
                    spell = this.spells[i-1];
                    this.spells[i-1] = " ";
                    band = true;
                }
            }

            if(!band){
                spell = this.spells[3];
                this.spells[3] = " ";
            }

            String message = this.name + " ha lanzado su hechizo " + spell + " contra " + ch.getName();
            JOptionPane.showMessageDialog(null, message,"Ataque de "+this.name,1);

        }
    }


}