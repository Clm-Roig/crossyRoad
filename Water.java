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
    private int speed;
    /**
     * Constructor for objects of class Water.
     */
    public Water(String direction, int speed){
        super();
        this.direction = direction;
        this.speed = speed;
    }
    
    // GET / SET
    public String getDirection() {return this.direction;}
    public int getSpeed() {return this.speed;}
    
    public Log addLog(int cell_size) {
        Log log = new Log(this.direction, this.speed);
        getWorld().addObject(log,getX(),getY());
        return log;
    }     
    
}
