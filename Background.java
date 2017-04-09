import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends Actor
{

    /**
     * Constructor for objects of class Ground.
     * 
     */
    public Background(int cell_size){
        this.getImage().scale(cell_size,cell_size);
    }
}
