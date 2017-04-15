import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Jade HENNEBERT & Clément ROIG
 * @version 1.0
 */
public abstract class Background extends Actor
{
    private final int IMAGE_SIZE = 50;
    /**
     * Constructor for objects of class Ground.
     * 
     */
    public Background(){
        this.getImage().scale(IMAGE_SIZE,IMAGE_SIZE);
    }
   
}
