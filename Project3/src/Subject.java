
public interface Subject {

	  public void attach(Observer o);
	    public void detach(Observer o);
	    public void notifyUpdate(Team t1, Team t2, double scor1, double scor2);
}
