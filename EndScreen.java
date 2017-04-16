import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class endScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends Actor {
    public EndScreen() {
        int sizeMap = ((Map)getWorld()).SIZE_MAP;
        GreenfootImage grayImage = new GreenfootImage(sizeMap,sizeMap);                                                        
        grayImage.setColor(new Color(125,125,125));
        grayImage.fill();     
        grayImage.setTransparency(100);
        
        setImage(grayImage);
    }
}
