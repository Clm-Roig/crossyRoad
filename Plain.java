import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plain extends Background
{

    /**
     * Constructor for objects of class Plain.
     * 
     */
    public Plain() {
        super();
    }
    
    public void addTree() {
        getWorld().addObject(new Tree(),getX(),getY());        
    }
    
    public void loadVehicle(){}
    
    public void addReward(int cell_size) {
        getWorld().addObject(new Reward(),getX(),getY());
    }
}
