import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (Jade HENNEBERT & Clément ROIG) 
 * @version (1,0))
 */
public class Player extends Mover
{
    private int vitesse = 2000;
    
    public Player() {
        this.getImage().scale(50,50);
        turn(-90);
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        String key = Greenfoot.getKey();
        
        if(key != null) {
            switch (key) {
                case "up":      moveUp();
                                break;                        
                case "right":   moveRight();
                                break;
                case "left":    moveLeft();
                                break;     
                default: break;
            }
        }
    }    
}
