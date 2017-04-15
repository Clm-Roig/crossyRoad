import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Jade HENNEBERT & Clément ROIG
 * @version 1.0
 */
public class RailWithSignal extends Rail {
    private final int DELAY_TRAIN = 400;
    private final int SIGNAL_SIZE = 25;
    private final int DISTANCE_SIGNAL = 13;
    
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
        this.getImage().drawOval(DISTANCE_SIGNAL,DISTANCE_SIGNAL,SIGNAL_SIZE,SIGNAL_SIZE);  
        greenSignal();
    }
    
    public void act() {  
        greenSignal();
        delayTrainCounter++;
        
        // Controle pour ajout train
        if(delayTrainCounter >= DELAY_TRAIN) {
            addTrain();
            delayTrainCounter = Greenfoot.getRandomNumber(100);
            
            // Couleur signal  
            orangeSignal();
            redSignal();
        }               
    }   
    
    private void addTrain() {
        Train train = new Train(super.getDirection());
        getWorld().addObject(train,positionTrain,getY());        
    }  
        
    private void greenSignal() {
        this.getImage().setColor(new Color(50,200,50));
        this.getImage().fillOval(DISTANCE_SIGNAL,DISTANCE_SIGNAL,SIGNAL_SIZE,SIGNAL_SIZE);    
    }
    
    private void orangeSignal() {
        this.getImage().setColor(new Color(200,100,20));
        this.getImage().fillOval(DISTANCE_SIGNAL,DISTANCE_SIGNAL,SIGNAL_SIZE,SIGNAL_SIZE);    
    }
    
    private void redSignal() {
        this.getImage().setColor(new Color(200,50,50));
        this.getImage().fillOval(DISTANCE_SIGNAL,DISTANCE_SIGNAL,SIGNAL_SIZE,SIGNAL_SIZE);    
    }
    
    
}
