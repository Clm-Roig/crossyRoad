import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reward here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reward extends Item
{
    /**
     * Act - do whatever the Reward wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int IMAGE_SIZE = 30;
     public Reward() {
        this.getImage().scale(IMAGE_SIZE,IMAGE_SIZE);   
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void taken(){
        // Add your action code here.
    }
}
