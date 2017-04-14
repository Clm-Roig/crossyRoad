import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mover extends Actor {
    /**
     * Act - do whatever the Mover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
    }    
    
    // 180° pour aller vers la gauche
    public void moveLeft() {
        setRotation(180);
        move(1);
    }
    
    // 0° pour aller vers la droite
    public void moveRight() {
        setRotation(0);
        move(1);     
    }
    
    // 270° pour aller vers le haut
    public void moveUp() {
        setRotation(270);
        move(1);
    }
}
