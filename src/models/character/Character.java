package models.character;

import javax.swing.JOptionPane;


abstract public class Character {
    protected String name;
    protected String type;
    protected int damage;
    protected int intelligence;
    protected int healthPointsMax;
    protected int healthPoints;


    //constructors
    public Character(){
        setType();
        setName();
        setDamage();
        setIntelligence();
        setHealthPointsMax();
    }

    public Character(String name, String type, int damage, int intelligence, int hpm){
        setType(type);
        setName(name);
        setDamage(damage);
        setIntelligence(intelligence);
        setHealthPointsMax(hpm);
        setHealthPoints();
    }

    //setter methods
    abstract public void setDamage();
    abstract public void setDamage(int dm);

    abstract public void setIntelligence();
    abstract public void setIntelligence(int itg);

    public void setType(){
        int typeRand;
        typeRand = (int) Math.floor(1+Math.random()*4);

        switch(typeRand){
            case 1: this.type = "Human"; break;
            case 2: this.type = "Ogre"; break;
            case 3: this.type = "Elf"; break;
            case 4: this.type = "Dwarf"; break;
        }
    }

    public void setType(String tp){
        //format
        tp = tp.toUpperCase().charAt(0) + tp.substring(1,tp.length()).toLowerCase();

        if(tp.equals("Human") || tp.equals("Ogre") || tp.equals("Elf") || tp.equals("Dwarf")){
            this.type = tp;
        }
        else{
            this.setType();
            System.out.println("no se ha seleccionado una raza valida, se ha seleccionado " + this.getType() + " por defecto");
        }
    }

    public void setName(){
        this.name = this.type+System.currentTimeMillis();
    }

    public void setName(String nm){
        this.name = nm;
    }

    public void setHealthPointsMax(){
        int hpmax = (int)Math.floor(Math.random()*101);
        this.healthPointsMax = hpmax;
        setHealthPoints(hpmax);
    }

    public void setHealthPointsMax(int hpmax){
        if(hpmax>=0 && hpmax<=100){
            this.healthPointsMax=hpmax;
            setHealthPoints(hpmax);
        }
        else{
            if(hpmax<0){
                this.healthPointsMax=0;
            }
            else if(hpmax>100){
                this.healthPointsMax=100;
            }
        }
    }

    public void setHealthPoints(){
        this.healthPoints = this.healthPointsMax;
    }

    public void setHealthPoints(int hp){
        if(hp>=0 && hp<=this.healthPointsMax){
            this.healthPoints = hp;
        }
        else{
            setHealthPoints();
        }
    }

    //getter methods

    public String getName(){
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    public int getDamage(){
        return this.damage;
    }

    public int getIntelligence(){
        return this.intelligence;
    }

    public int getHealthPointsMax(){
        return this.healthPointsMax;
    }

    public int getHealthPoints(){
        return this.healthPoints;
    }

    //other methods
    abstract public void printCharacterData();

}