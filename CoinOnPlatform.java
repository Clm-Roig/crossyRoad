import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Jade HENNEBERT & Clément ROIG
 * @version 1,0
 */
public class CoinOnPlatform extends Coin
{
    Platform plat;
    
    public CoinOnPlatform(Platform plat) {
        super();
        this.plat = plat; 
    }
   
    public void act() {
        setLocation(this.plat.getX(),this.plat.getY());
    }    
}
