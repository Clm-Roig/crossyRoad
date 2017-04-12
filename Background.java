import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Background extends Actor
{

    /**
     * Constructor for objects of class Ground.
     * 
     */
    public Background(int cell_size){
        this.getImage().scale(cell_size,cell_size);
    }
    
    /**
     * Les BG ont une chance de faire apparaitre un véhicule lors de leur création. 
     */
    public abstract void loadVehicle();
}
