import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Jade HENNEBERT & Clément ROIG
 * @version 1,0
 */
public class Coin extends Item {
    public Coin() {
        super();  
    }      
    
    // Animation de la prise de Reward
    public void taken(){        
        this.turn(360);
        GreenfootSound sound = new GreenfootSound("coin.wav");
        sound.play();
        getWorld().removeObject(this);
    }
}
