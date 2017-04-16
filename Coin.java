import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reward here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Item {
    public Coin() {
        super();  
    }
        
    public void act() {
 
    }        
    
    // Animation de la prise de Reward
    public void taken(){        
        this.turn(360);
        GreenfootSound sound = new GreenfootSound("coin.wav");
        sound.play();
        getWorld().removeObject(this);
    }
}
