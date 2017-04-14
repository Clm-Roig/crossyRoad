import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mover extends Actor {
    public final int DISTANCE_ADJ = 8;
    /**
     * Act - do whatever the Mover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
    }    
    
    // 180° pour aller vers la gauche
    public void moveLeft(int speed) {
        setRotation(180);
        Actor obst = getOneObjectAtOffset(-DISTANCE_ADJ,0,Obstacle.class);
        if(obst == null) {
            move(speed);
        }
    }
    
    // 0° pour aller vers la droite
    public void moveRight(int speed) {
        setRotation(0);
        Actor obst = getOneObjectAtOffset(DISTANCE_ADJ,0,Obstacle.class);
        if(obst == null) {
            move(speed);   
        }        
    }
    
    // 270° pour aller vers le haut
    public void moveUp(int speed) {
        setRotation(270);
        Actor obst = getOneObjectAtOffset(0,-DISTANCE_ADJ,Obstacle.class);
        if(obst == null) {
            move(speed);
        }
    }
    
    // 90° pour aller vers le haut
    public void moveDown(int speed) {
        setRotation(90);
        Actor obst = getOneObjectAtOffset(0,DISTANCE_ADJ,Obstacle.class);
        if(obst == null) {
            move(speed);
        }
   }
}
