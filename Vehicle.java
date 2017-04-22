import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vehicle here.
 * 
 * @author (Jade HENNEBERT & Clément ROIG) 
 * @version (1,0)
 */
public abstract class Vehicle extends Mover
{
    private String direction;    
    
    public Vehicle(String direction, int speed) { 
        super(speed);                       
        this.direction = direction;        
    } 
    
    // GET / SET
    public String getDirection() {return this.direction;}
}
