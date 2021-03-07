import java.util.List;
import java.io.*;

public class FootballTeam extends Team  {

	
	public String teamName;
	public String gender;
	public int numberOfPlayers;
	public List<Players> players;
	public int pct_ech;
	public int poz_ech;

	
	public FootballTeam(String teamName, String gender, int numberOfPlayers, List<Players> players) {
		super(teamName, gender, numberOfPlayers, players);
	}
	
// ---------------------------------------------------------task1-------------------------------------------------------------------------------	
	
public FootballTeam(String teamType, int pct_ech, int poz_ech, String teamName, String gender, int numberOfPlayers, List<Players> players) {
		
	super(teamType, pct_ech, poz_ech, teamName, gender, numberOfPlayers, players);
}


//public double accept(TeamPartVisitor visitor) {
//	return visitor.visit(this);
//}

}
