import java.util.List;

public class TeamPartVisitorImpl implements TeamPartVisitor {

	
//	public double visit(FootballTeam f) {
//		double SCOR = 0;
//		int nr = 0;
//		double max = -1;
//		double min = 0;
//		for(Players p : f.players) {
//			
//			if(max < p.score)
//				max = p.score;
//			
//			if(min > p.score)
//				min = p.score;
//			
//			SCOR = SCOR + p.score;
//		}
//		
//		if(f.gender.contentEquals("feminin")) {
//			SCOR = SCOR + 2 * min;
//		}
//		else {
//			SCOR = SCOR + 2 * max;
//		
//		}
//	
//		 return SCOR;
//		
//	}
//	
//	public double visit(BasketballTeam b) {
//		
//		double SCOR = 0;
//		double sum = 0;
//		int nr = 0;
//		for(Players p : b.players) {
//			
//		
//			sum = sum + p.score;
//			nr++;
//		}
//		
//		SCOR = sum/nr;
//		return SCOR;
//		
//	}
//	
//	public double visit(HandballTeam h) {
//		
//		double SCOR = 0;
//		for(Players p : h.players) {
//			
//			if(h.gender.equals("feminin"))
//				SCOR  = SCOR * p.score;
//		
//		else
//			SCOR = SCOR + p.score;
//		}
//		return SCOR;
//	}
	

	public double visit(Team t) {
		
		double SCOR = 0;
		
		if(t.teamType.equals("football")){
			
			int nr = 0;
			double max = -1;
			double min = 0;
			for(Players p : t.players) {
				
				if(max < p.score)
					max = p.score;
				
				if(min > p.score)
					min = p.score;
				
				SCOR = SCOR + p.score;
			}
			
			if(t.gender.equals("feminin")) {
				SCOR = SCOR + 2 * min;
			}
			else {
				SCOR = SCOR + 2 * max;
		
			}
		}
		
		if(t.teamType.equals("basketball")){
			
			double sum = 0;
			int nr = 0;
			for(Players p : t.players) {
				
			
				sum = sum + p.score;
				nr++;
			}
			
			SCOR = sum/nr;

		}
		
		
		if(t.teamType.equals("handball")){
			
			SCOR  = 1;
		for(Players p : t.players) {
		
			if(t.gender.equals("feminin"))
				SCOR  = SCOR * p.score;		
		else
			SCOR = SCOR + p.score;
		}
	}
		
		return SCOR;
	}
}
