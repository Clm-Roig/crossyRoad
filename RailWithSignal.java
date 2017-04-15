import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Jade HENNEBERT & Clément ROIG
 * @version 1.0
 */
public class RailWithSignal extends Rail {
    private final int DELAY_TRAIN = 400;
    private int positionTrain;    
    private int delayTrainCounter;

    public RailWithSignal(String direction) {
        super(direction);
        this.delayTrainCounter = Greenfoot.getRandomNumber(150) + 250;
        
        // Si le train va à droite, on le place à -1000 du premier rail de la ligne (à -1000 du bord gauche de la map donc)
        if(direction == "toRight") {
            positionTrain = -1000;
        }
        // Sinon, on le met à 1000 du dernier rail de la ligne
        else {
            positionTrain = 1000 + ((Map)getWorld()).SIZE_MAP;
        }
        
        this.getImage().setColor(new Color(200,200,200));
        this.getImage().drawOval(10,10,25,25);
        this.getImage().setColor(new Color(50,200,50));
        this.getImage().fillOval(10,10,25,25);       
    }
    
    public void act() {  
        delayTrainCounter++;
            if(delayTrainCounter >= DELAY_TRAIN) {
                this.getImage().setColor(new Color(200,50,50));
                this.getImage().fillOval(10,10,25,25);   
                addTrain();
                delayTrainCounter = Greenfoot.getRandomNumber(100);
            }
        
    }   
    
    public void addTrain() {
        Train train = new Train(super.getDirection());
        getWorld().addObject(train,positionTrain,getY());        
    }  
}
