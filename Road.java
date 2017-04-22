import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Road can have Car on it.
 * 
 * @author Clément ROIG & Jade HENNEBERT
 * @version 1.0
 */
public class Road extends Background
{
    private String direction;
    
    public Road(String direction) {
        super();
        this.direction = direction;
    }
    
    public void addRedCar() {
        getWorld().addObject(new RedCar(this.direction),getX(),getY());
    }  
    
    public void addGreenCar() {
        getWorld().addObject(new GreenCar(this.direction),getX(),getY());
    } 
    
    public void addBlueCar() {
        getWorld().addObject(new BlueCar(this.direction),getX(),getY());
    }
}
