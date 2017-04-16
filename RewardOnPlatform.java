import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RewardOnPlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RewardOnPlatform extends Reward
{
    Platform plat;
    
    public RewardOnPlatform() {}
    
    public RewardOnPlatform(Platform plat) {
        super();
        this.plat = plat; 
    }
   
    public void act() {
        setLocation(this.plat.getX(),this.plat.getY());
    }    
}
