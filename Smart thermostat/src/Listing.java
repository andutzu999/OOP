import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

public class Listing {

	public PrintWriter printWriter;
	public Listing(PrintWriter printWriter) {
		
		this.printWriter = printWriter;
	}
	

	
	public void Listare(List<Room> cam, List<Observe> v_obs, List<Temperature> v_temp, int x, int y, String camera) {
		
		for(Room a: cam) {
			
			if(a.room.contentEquals(camera)) {
				
				printWriter.print(camera);
				
				for(int i = 0; i <= 23; i++) {
					
					if(i>= x && i< x + y) {
						
						for(int j = 1; j< a.v_obs.get(i).v_temp.size(); j++) {
							
							if(a.v_obs.get(i).v_temp.get(j).temperatura != a.v_obs.get(i).v_temp.get(j-1).temperatura) {
							//	System.out.println(a.v_obs.get(i).v_temp.get(j).temperatura);
								printWriter.print(" ");
								printWriter.print(String.format(Locale.US , "%.2f", a.v_obs.get(i).v_temp.get(j-1).temperatura));
								
							}
						}
						printWriter.print(" ");
						printWriter.print(String.format(Locale.US , "%.2f", a.v_obs.get(i).v_temp.get(a.v_obs.get(i).v_temp.size()-1).temperatura));
						
					}
				}
				printWriter.println();
			}
		}
	}
	
	
	public void close() {
		printWriter.close();
	}
}
