import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player can't go on an Obstacle.
 * 
 * @author (Jade HENNEBERT & Clément ROIG) 
 * @version (1,0)
 */
public class Obstacle extends Actor {
    private final int IMAGE_SIZE = 50;
    
    public Obstacle(){
        this.getImage().scale(IMAGE_SIZE,IMAGE_SIZE);
    }
}
