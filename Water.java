import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Water here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Water extends Background
{

    /**
     * Constructor for objects of class Water.
     * 
     */
    public Water(int cell_size){
        super(cell_size);
    }
    
    public void addRock(int cell_size) {
        getWorld().addObject(new Rock(cell_size),getX(),getY());
    }     
    
}
