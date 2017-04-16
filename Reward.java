import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reward here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reward extends Item {
    public Reward() {
        super();  
    }
        
    public void act() {
 
    }        
    
    // Animation de la prise de Reward
    public void taken(){        
        this.turn(360);
    }
}
