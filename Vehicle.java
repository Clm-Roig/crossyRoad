import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vehicle here.
 * 
 * @author (Jade HENNEBERT & Clément ROIG) 
 * @version (1,0)
 */
public abstract class Vehicle extends Mover
{
    private int speed;
    private int size;
    private boolean direction; // true = left to right, false = right to left
    
    public Vehicle(int rawNb) {        
        if(Greenfoot.getRandomNumber(2)==0) {
            this.direction = false;
        }
        else {
            this.direction = true;
        }       
        
    }
    
    /* Getters / setters */
    public int getSpeed() {return this.speed;}
    public int getSize() {return this.size;}
    
    public void setSpeed(int s) {this.speed = s;}
    public void setSize(int s) {this.size = s;}
 
 
    /**
     * Act - do whatever the Vehicle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(this.getSpeed());
    }    
}
