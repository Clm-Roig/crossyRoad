import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rail extends Background
{
    private String direction;
      
    /**
     * Constructor for objects of class Road.
     */
    public Rail(String direction) {
        super();
        this.direction = direction;        
    }
    
    public String getDirection() {return this.direction;}
    
    public void act() {            
        
    }
    
}
