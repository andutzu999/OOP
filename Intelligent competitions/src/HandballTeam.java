import java.util.List;
import java.io.*;

public class HandballTeam extends Team   {

	public String teamName;
	public String gender;
	public int numberOfPlayers;
	public List<Players> players;
	public int pct_ech;
	public int poz_ech;
	
	
	public HandballTeam(String teamName, String gender, int numberOfPlayers, List<Players> players) {
		
	super(teamName, gender, numberOfPlayers, players);
	}

// ---------------------------------------------------------task1-------------------------------------------------------------------------------
	
	public HandballTeam(String teamType, int pct_ech, int poz_ech, String teamName, String gender, int numberOfPlayers, List<Players> players) {
		
		super(teamType, pct_ech, poz_ech, teamName, gender, numberOfPlayers, players);
	}
	
//	public double accept(TeamPartVisitor visitor) {
//		return visitor.visit(this);
//	}

	
}
