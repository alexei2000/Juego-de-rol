package models.character;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Cleric extends Character{

    private static final ImageIcon sprite = new ImageIcon("../textures/cleric.jpg");
    private String god;

    //constructors
    public Cleric(){
        super();
        this.god="odin";
    }
    public Cleric(String name, String type, int damage, int intelligence, int hpm, String god){
        super(name, type, damage, intelligence, hpm);
        this.god=god;
    }

    //setter methods 
    @Override
    public void setDamage(){
        int dmRandom = 18 + (int)Math.floor(Math.random()*3);
        this.damage = dmRandom;
    }

    @Override
    public void setDamage(int dm){
        if(dm>=18 && dm<=20){
            this.damage = dm;
        }
        else{
            setDamage();
        }
    }

    @Override
    public void setIntelligence(){
        int itgRandom = 12 + (int)Math.floor(Math.random()*5);
        this.intelligence = itgRandom;
    }

    @Override
    public void setIntelligence(int itg){
        if(itg>=12 && itg<=16){
            this.intelligence = itg;
        }
        else{
            setIntelligence();
        }
    }

    public void setGod(String god){
        this.god=god;
    }

    //getter methods
    public String getGod(){
        return this.god;
    }

    //other methods

    @Override
    public void printCharacterData(){

        String data = "Name: "+this.name+
                    "\nType: "+this.type+
                    "\nGod: "+this.god+
                    "\nDamage: "+this.damage+" pts"+
                    "\nIntelligence: "+this.intelligence+" pts"+
                    "\nHealth Max: "+this.healthPointsMax+" pts"+
                    "\nCurrent Health: "+this.healthPoints+" pts";

        JOptionPane.showMessageDialog(null,data,"Cleric",1,Cleric.sprite);
    }

    public void heal(Character ch){

        ch.setHealthPoints(ch.getHealthPoints()-10);

        if(ch.getHealthPoints()>ch.getHealthPointsMax()){
            ch.setHealthPoints(ch.getHealthPoints());
        }

    }
}