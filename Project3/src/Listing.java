import java.util.List;
import java.io.*;

public class Listing {


	//import java.util.List;


		
	public PrintWriter printWriter;
		
		public Listing(PrintWriter printWriter) {
			
			this.printWriter = printWriter;
		}
		
		private static Listing obj4;
		public static Listing getInstance4(PrintWriter printWriter) {
			
			if(obj4 == null)
				obj4 = new Listing(printWriter);
			return obj4;
			
		}
		
		public void List(List<Team> TM,  int j) {
			
				int k;
				
				for(Team t : TM) {
					
				printWriter.print("{" + "teamName: " + t.teamName + ", ");
				printWriter.print("gender: " + t.gender + ", ");
				printWriter.print("numberOfPlayers: " + t.numberOfPlayers + ", ");
				printWriter.print("players: [");
				
				for(k = 0; k < t.players.size() ; k++) {
					
					if(k == 0) {
						
						printWriter.print("{name: " + t.players.get(k).name + ", " + "score: " + t.players.get(k).score + "}");
					}
					else
						
						printWriter.print(", {name: " + t.players.get(k).name + ", " + "score: " + t.players.get(k).score + "}");
				}
				
				printWriter.print("]}\n");
				
			}	
	}

				
		
		public void close() {
			printWriter.close();
		}
		
// ---------------------------------------------------------task1-------------------------------------------------------------------------------
	
		
		public void List1(List<Team> tm) {
			
			for(Team t : tm) {
				
				if(t.poz_ech <= 3) {
					
					printWriter.println(t.teamName);
				}
			}
		}
		
		public void List2(List<Team> tm, String cuvant) {
			
			for(Team t : tm) {
				
				if(cuvant.equals(t.teamName)) {
					printWriter.println("Echipa " + cuvant + " a ocupat locul " + t.poz_ech);
					break;
				}
		}
	}
}
