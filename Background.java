import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Jade HENNEBERT & Clément ROIG
 * @version 1.0
 */
public abstract class Background extends Actor
{
    private final int IMAGE_SIZE = 50;

    public Background(){
        this.getImage().scale(IMAGE_SIZE,IMAGE_SIZE);
    }
   
    public void addCoin() {
        this.getWorld().addObject(new Coin(),getX(),getY());
    }
    
    public void addCoinOnPlatform(Platform plat) {
        this.getWorld().addObject(new CoinOnPlatform(plat),getX(),getY());
    }
}
