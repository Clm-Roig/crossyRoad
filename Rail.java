import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Rail has Train on it.
 * 
 * @author Jade HENNEBERT & Clément ROIG
 * @version 1,0
 */
public class Rail extends Background
{
    private String direction;
      
    public Rail(String direction) {
        super();
        this.direction = direction;        
    }
    
    public String getDirection() {return this.direction;}   
}
