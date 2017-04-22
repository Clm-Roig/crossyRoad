import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Water can have Platform on it.
 * 
 * @author Jade HENNEBERT & Clément ROIG
 * @version 1,0
 */
public class Water extends Background {
    private String direction;  
    private int speed;
    
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
