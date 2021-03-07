import java.util.List;
import java.util.List;
import java.util.ArrayList;
public class grup extends pasager{
	
	String word;
	 List<grup> g;
	 int priority;
	 
	public grup(String id, String name, int age, String ticket, boolean imb_p, boolean needs) {
    	
		super(id, name, age, ticket, imb_p, needs);
	/* this.id = id; */
    }
	public grup() {
		
	}
	

	public grup(String word, int priority,  List<grup> g) {
		super(word, priority);
		this.g = g;
		
	}
	
public int g_priority(List<grup> g, String word) {
		
		int priority = 5;
		for (grup a: g)
			
			if(a.id.equals(word)) {
				
				if(a.age < 2)
					priority = priority + 20;
				if(a.age >= 2 && a.age < 5)
					priority = priority + 10;
				if(a.age >= 5 && a.age <= 10)
					priority = priority + 5;
				if(a.age > 10 && a.age <= 60)
					priority = priority + 0;
				if(a.age > 60)
					priority = priority + 15;
				
				if(a.ticket.equals("b"))
					priority = priority + 35;
				if(a.ticket.equals("p"))
					priority = priority + 20;
				
				if(a.imb_p == true)
					priority = priority + 30;
				if(a.needs == true)
					priority = priority + 100;
			}
		return priority;
	}

public List<grup> group(List<grup> g, List<grup> g_aux,  String word) {
	
	
	for (grup a: g)
		if(a.id.equals(word)) {
			g_aux.add(a);
		}
	return g_aux;
}



}
