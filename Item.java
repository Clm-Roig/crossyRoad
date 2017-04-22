import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Item are object on the Ground. 
 * 
 * @author Jade HENNEBERT & Clément ROIG
 * @version 1,0
 */
public class Item extends Actor
{   private final int IMAGE_SIZE = 30;
    
    public Item(){
        this.getImage().scale(IMAGE_SIZE,IMAGE_SIZE);
    }   
}
