import java.io.*;
import java.util.*;

public class Team implements TeamPart, Observer, Comparable<Team>{

	protected String teamName;
	protected String gender;
	protected int numberOfPlayers;
	protected List<Players> players;
    protected int pct_ech;
    protected int poz_ech;
    private static Team obj5;
    protected String teamType;
    
	public Team() {
	}

public Team(String teamName, String gender, int numberOfPlayers, List<Players> players) {
		
		this.teamName = teamName;
		this.gender = gender;
		this.numberOfPlayers = numberOfPlayers;
		this.players = players;
	}

//---------------------------------------------------------task1-------------------------------------------------------------------------------

public Team(String teamType, int pct_ech, int poz_ech, String teamName, String gender, int numberOfPlayers, List<Players> players) {
	
	this.teamName = teamName;
	this.gender = gender;
	this.numberOfPlayers = numberOfPlayers;
	this.players = players;
	this.pct_ech = pct_ech;
	this.poz_ech = poz_ech;
	this.teamType = teamType;
	
}

	public void adaugare(List<Team> tm, Team t, String field0, String field1, String gender, String arr0 ) {
		
		if(field0.equals(arr0) &&  field1.equals(gender)) 
	    	
				tm.add(t);
	}
	
		
	public double accept(TeamPartVisitor visitor) {
	return visitor.visit(this);
}

	public void update(Team t1, Team t2, double scor1, double scor2) {
		
		if(scor1 > scor2)
			t1.pct_ech = t1.pct_ech + 3;
		if(scor1 == scor2) {
			t1.pct_ech = t1.pct_ech + 1;
			t2.pct_ech = t2.pct_ech + 1;
		}
		if(scor1 < scor2)
			t2.pct_ech = t2.pct_ech + 3;
		
	}
	
	public int compareTo(Team t) {
		if( this.pct_ech < t.pct_ech)
			return 1;
		if( this.pct_ech == t.pct_ech)
			return 0;
		if( this.pct_ech > t.pct_ech)
			return -1;
		return 2;
		
	}
	
	public void sort(List<Team> tm) {
		Collections.sort(tm);
	}
	
	
}
