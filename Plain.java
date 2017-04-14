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
    public Plain(int cell_size) {
        super(cell_size);
    }
    
    public void addTree(int cell_size) {
        getWorld().addObject(new Tree(cell_size),getX(),getY());        
    }
    
    public void loadVehicle(){}
}
