import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Water here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Water extends Background
{
    private String direction;  
    /**
     * Constructor for objects of class Water.
     * 
     */
    public Water(){
        super();
        /*super.setSpeed(s);
        this.direction = direction;*/ 
    }
    
    // GET / SET
    /*public String getDirection() {return this.direction;};*/
    
    public void addRock(int cell_size) {
        getWorld().addObject(new Rock(),getX(),getY());
    }     
    
    /*public void addReward() {
        super();
    }*/
}
