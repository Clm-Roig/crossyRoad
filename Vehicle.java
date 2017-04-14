import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vehicle here.
 * 
 * @author (Jade HENNEBERT & Clément ROIG) 
 * @version (1,0)
 */
public abstract class Vehicle extends Mover
{
    private int speed;
    private int size;
    private String direction;
    
    public Vehicle(int cell_size, String direction) { 
        this.getImage().scale(cell_size,cell_size);    
        this.direction = direction;
    } 
    
    // GET / SET
    public String getDirection() {return this.direction;}
 
    /**
     * Act - do whatever the Vehicle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        
    }    
}
