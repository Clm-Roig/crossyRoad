import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Screen at the end of a game (just a gray image on the map)
 * 
 * @author Jade HENNEBERT & Clément ROIG
 * @version 1,0
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
