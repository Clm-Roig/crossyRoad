import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
