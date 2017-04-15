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
    public Water(){
        super();
    }
    
    public void addRock(int cell_size) {
        getWorld().addObject(new Rock(),getX(),getY());
    }     
    
    public void addReward() {
        getWorld().addObject(new Reward(),getX(),getY());
    }
}
