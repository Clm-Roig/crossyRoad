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
    public Road(int cell_size, String direction) {
        super(cell_size);
        this.direction = direction;
    }
    
    public void addCar(int cell_size) {
        getWorld().addObject(new Car(cell_size,this.direction),getX(),getY());
    }   
}
