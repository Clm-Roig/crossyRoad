import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Mover extends Actor {
    public int speed;
    
    public Mover(int s) {
        this.speed = s;
    }
    
    public void setSpeed(int s) {this.speed = s;}
    public int getSpeed() {return this.speed;}
    
    /**
     * Act - do whatever the Mover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
    }    
    
    // 180° pour aller vers la gauche
    public boolean moveLeft() {
        boolean itMoved = false;
        setRotation(180);
        Obstacle obst = (Obstacle) getOneObjectAtOffset(-this.speed,0,Obstacle.class);
        if(obst == null) {
            move(this.speed);
            itMoved = true;
        }
        return itMoved;
    }
    
    // 0° pour aller vers la droite
    public boolean moveRight() {
        boolean itMoved = false;
        setRotation(0);
        Obstacle obst = (Obstacle) getOneObjectAtOffset(this.speed,0,Obstacle.class);
        if(obst == null) {
            move(this.speed);   
            itMoved = true;
        }      
        return itMoved;
    }
    
    // 270° pour aller vers le haut
    public boolean moveUp() {
        boolean itMoved = false;
        setRotation(270);
        Obstacle obst = (Obstacle) getOneObjectAtOffset(0,-this.speed,Obstacle.class);
        if(obst == null) {
            move(this.speed);
            itMoved = true;
        }
        return itMoved;
    }
    
    // 90° pour aller vers le haut
    public boolean moveDown() {
        boolean itMoved = false;
        setRotation(90);
        Obstacle obst = (Obstacle) getOneObjectAtOffset(0,this.speed,Obstacle.class);
        if(obst == null) {
            move(this.speed);
            itMoved = true;
        }
        return itMoved;
   }
}
