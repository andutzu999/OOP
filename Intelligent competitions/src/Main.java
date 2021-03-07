import java.io.*;
import java.util.*;

public abstract class Main {

	public static void main(String[] args)  throws IOException {
        try {
        	
        	if(args[0].equals("inscriere")) {
        		
        	File file = new File(args[1]);
        	Scanner input = new Scanner(file);
        	PrintWriter printWriter = new PrintWriter(args[3]);
        	int i;
        	int j = 0;
        	
        	
        	 String teamName;
        	 String gender;
        	 int numberOfPlayers;
        	 String number;
        	 List<Team> TM = new ArrayList<>();
        	 Listing LST = Listing.getInstance4(printWriter); //singleton
        	 List<Players> player;
        	 
        	
        	
        	while (input.hasNext()) {
        		
        		 String line = input.nextLine();
        		 String[] arrOfStr = line.split("," , 4);
        		 teamName = arrOfStr[1].substring(1);  
        		 gender = arrOfStr[2].substring(1);
        		 number = arrOfStr[3].substring(1);
        		 numberOfPlayers = Integer.parseInt(number);
        		 List<Players> players =  new ArrayList<Players>();
        		 
        		 for(i = 1; i <= numberOfPlayers; i++) {
        			 
        			 String linie = input.nextLine();
        			 String[] arr = linie.split(", ", 2);
        			 Players p1 = Players.getInstance3();
        			 double score = Double.parseDouble(arr[1]);
        			 Players p = new Players(arr[0], score);
        			 players.add(p);
        			 
        			
        			 
        		 }
        		 
        			 Team t = TeamFactory.getTeam2(arrOfStr[0] , teamName, gender, numberOfPlayers, players);
        			 
        		 TM.add(t);
        		 j++;
        		 
        	}
       	
        	LST.List(TM,  j);
        	LST.close();
        	input.close();
}       	
// ---------------------------------------------------------task1-------------------------------------------------------------------------------
        
   else {
	   
	   		File file1 = new File("echipe1.in");
	   		Scanner input1 = new Scanner(file1);
	   		File file2 = new File("competitie6.in");
	   		Scanner input2 = new Scanner(file2);
	   		
	   		//PrintWriter printWriter = new PrintWriter(args[3]);
	   		
	   		String teamName;
	   		String gender;
	   		int numberOfPlayers;
	   		String number;
	   		List<Team> tm = new ArrayList<>();
	   		List<Players> player;
	   		int pct_ech = 0;
	   		int poz_ech = 0;
	   		
	   		String Line = input2.nextLine();
	   		String[] campuri = Line.split(", ", 2);

	   		
	   		
	   		while (input1.hasNext()) {
        		
       		 String line = input1.nextLine();
       		 String[] arrOfStr = line.split(", " , 4);
       		 teamName = arrOfStr[1];  
       		 gender = arrOfStr[2];
       		 number = arrOfStr[3];
       		 numberOfPlayers = Integer.parseInt(number);
       		 List<Players> players =  new ArrayList<Players>();
       		 int i;
       		 int j = 0;
       		
       		 
       		 for(i = 1; i <= numberOfPlayers; i++) {
       			 
       			 String linie = input1.nextLine();
       			 String[] arr = linie.split(", ", 2);
       			 Players p1 = Players.getInstance3();
       			 double score = Double.parseDouble(arr[1]);
    			 Players p = new Players(arr[0], score);
       			 players.add(p);
       			 
       			
       		 }
       		 
       		 
       			 
       		Team t = TeamFactory.GetTeam(arrOfStr[0] , pct_ech, poz_ech, teamName, gender, numberOfPlayers, players); //factory pentru Team
       			
       		 
       		 
   		Team object = new Team();
   		
       		 object.adaugare(tm, t, campuri[0], campuri[1], gender, arrOfStr[0]); // adaug t in obiect
   		
	   		}	
	   		int i;
	   		int j;
	   		TeamPartVisitor visitor = new TeamPartVisitorImpl();
	   		for(i = 0; i < tm.size() - 1 ; i++) {
	   			for(j = i+1; j < tm.size(); j++) {
	   				
	   			double scor1 = tm.get(i).accept(visitor);
	   			double scor2 = tm.get(j).accept(visitor);
	   			Apel p = new Apel();
	   			p.attach(tm.get(i));
	   			p.attach(tm.get(j));
	   			p.notifyUpdate(tm.get(i), tm.get(j), scor1, scor2);
	   			p.detach(tm.get(i));
	   			p.detach(tm.get(j));
	   			
	   			
	   			
	   			}	
	   		}
	   			
	   		Team t = new Team();
	   		t.sort(tm);
	   		int k = 1;
	   		
	   		for(Team t1 : tm) {
	   			t1.poz_ech = k;
	   			k++;
	   		}
       	
	   		PrintWriter printWriter = new PrintWriter("inscriere_echipe.out");
	   		Listing LST = Listing.getInstance4(printWriter);
	   		LST.List1(tm);
	   		
	   		while(input2.hasNext()) {
	   			
	   			String cuvant = input2.next();
	   			LST.List2(tm, cuvant);
	   			
	   		}
       				
       			LST.close();
       		 input1.close();
             input2.close();	
       				
       			
       				
       		
       		
	   		
       		
	   	
   }
      
        	
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
	}
}
