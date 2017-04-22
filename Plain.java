import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Plains can have Tree on it.
 * 
 * @author Jade HENNEBERT & Clément ROIG
 * @version 1,0
 */
public class Plain extends Background {
    public Plain() {
        super();
    }
    
    public void addTree() {
        getWorld().addObject(new Tree(),getX(),getY());        
    }
}
