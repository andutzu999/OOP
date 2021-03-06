import java.io.*;
import java.util.*;
public class Apel {

	private List<Observer> observers = new ArrayList<>();
	 
    
    public void attach(Observer o) {
        observers.add(o);
    }
 
   
    public void detach(Observer o) {
        observers.remove(o);
    }
 
   
    public void notifyUpdate(Team t1, Team t2, double scor1, double scor2) {
        for(Observer o: observers) {
            o.update(t1, t2, scor1, scor2);
        }
    }
}

