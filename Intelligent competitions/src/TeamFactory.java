import java.util.List;

public class TeamFactory {

	
	
	public static Team getTeam2(String teamType, String teamName, String gender, int numberOfPlayers,  List<Players> players ) {
		
	
		
		if(teamType.equals("football")) {
			return new FootballTeam(teamName, gender, numberOfPlayers, players);
		
		} else if(teamType.equals("basketball")) {
			return new BasketballTeam(teamName, gender, numberOfPlayers, players);
		
	} else if(teamType.equals("handball")) {
			return new HandballTeam(teamName, gender, numberOfPlayers, players);
	
	}
			return null;
		
	}
	
	private static TeamFactory obj1;
	public static TeamFactory getInstance1() {
		
		if(obj1 == null)
			obj1 = new TeamFactory();
		return obj1;
		
	}
	
// ---------------------------------------------------------task1-------------------------------------------------------------------------------	
	
	
public static Team GetTeam(String teamType, int pct_ech, int poz_ech, String teamName, String gender, int numberOfPlayers,  List<Players> players ) {
		
	
		
		if(teamType.equals("football")) {
			return new FootballTeam(teamType, pct_ech, poz_ech, teamName, gender, numberOfPlayers, players);
		
		} else if(teamType.equals("basketball")) {
			return new BasketballTeam(teamType, pct_ech, poz_ech, teamName, gender, numberOfPlayers, players);
		
	} else if(teamType.equals("handball")) {
			return new HandballTeam(teamType, pct_ech, poz_ech, teamName, gender, numberOfPlayers, players);
	
	}
			return null;
		
	}



}
