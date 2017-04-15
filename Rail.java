import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rail extends Background
{
    private final int DELAY_TRAIN = 400;
    
    private int positionTrain;
    private String direction;
    private boolean haveTrain;
    private int delayTrainCounter;
    
    /**
     * Constructor for objects of class Road.
     */
    public Rail(String direction, boolean train) {
        super();
        this.direction = direction;
        this.haveTrain = train;
        this.delayTrainCounter = Greenfoot.getRandomNumber(150) + 250;
        
        if(haveTrain) {
            // Si le train va à droite, on le place à -1000 du premier rail de la ligne (à -1000 du bord gauche de la map donc)
            if(direction == "toRight") {
                positionTrain = -1000;
            }
            // Sinon, on le met à 1000 du dernier rail de la ligne
            else {
                positionTrain = 1000 + ((Map)getWorld()).SIZE_MAP;
            }
        }
    }
    
    public void act() {
        if(haveTrain) {
            delayTrainCounter++;
            if(delayTrainCounter >= DELAY_TRAIN) {
                addTrain();
                delayTrainCounter = Greenfoot.getRandomNumber(100);
            }
        }
    }
    
    public void addTrain() {
        Train train = new Train(this.direction);
        getWorld().addObject(train,positionTrain,getY());        
    }  
    

}
