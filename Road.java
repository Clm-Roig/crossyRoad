import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Road here.
 * 
 * @author Clément ROIG & Jade HENNEBERT
 * @version 1.0
 */
public class Road extends Background
{
    private String direction;
    
    /**
     * Constructor for objects of class Road.
     * 
     */
    public Road(String direction) {
        super();
        this.direction = direction;
    }
    
    public void addCar() {
        getWorld().addObject(new Car(this.direction),getX(),getY());
    }   
}
