import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (Jade HENNEBERT & Clément ROIG) 
 * @version (1,0)
 */
public class Car extends Vehicle {  
    private int speed;
    
    public Car(String direction, int s) {
        super(direction);
        this.speed = s;
    }
    
    public int getSpeed() {return this.speed;}
    public void setSpeed(int s) {this.speed = s;}
    
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(getDirection() == "toLeft") {
            moveLeft(this.speed);
            
            if(isAtEdge()) {
                setLocation(this.getWorld().getWidth()+1,getY());
            }
        }
        
        if(getDirection() == "toRight") {
            moveRight(this.speed);
            
            if(isAtEdge()) {
                setLocation(-1,getY());
            }
        }
    }
}
