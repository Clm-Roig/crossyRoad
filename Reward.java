import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reward here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reward extends Item
{
     public Reward() {
        super();   
    }
    
    /**
     * Act - do whatever the Reward wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public void act() 
    {

    }    
    
    //animation de la prise du bonus
    public void taken(){
        
        this.turn(360);
    }
}
