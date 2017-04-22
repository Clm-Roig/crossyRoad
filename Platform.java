import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Jade HENNEBERT & Clément ROIG
 * @version 1,0
 */
public abstract class Platform extends Mover {
    private String direction; 
    
    public Platform(int speed, String direction) {
        super(speed);
        this.direction = direction;
    }
    
    // GET / SET 
    public String getDirection() {return this.direction;}
    public void setDirection(String dir) {this.direction = dir;}
}
