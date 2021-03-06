import java.util.ArrayList;
import java.util.List;


public class singur extends pasager{

	
	public String word;
	 public List<singur> s;
	 public int priority;
	
	public singur(String id, String name, int age, String ticket, boolean imb_p, boolean needs) {
    	
		super(id, name, age, ticket, imb_p, needs);
		/* this.id = id; */
    }
	
	public singur() {
	}
	
	public singur(String word, int priority, List<singur> s) {
		super(word, priority);
		this.s = s;
		
	}
	
	public int s_priority(List<singur> s, String word) {
		
		int priority = 0;
		for (singur a: s)
			
			if(a.id.equals(word)) {
				
				if(a.age < 2)
					priority = priority + 20;
				if(a.age >= 2 && a.age <= 5)
					priority = priority + 10;
				if(a.age > 5 && a.age <= 10)
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
	
	public List<singur> single(List<singur> s, List<singur> s_aux,  String word) {
		
		
		for (singur a: s)
			if(a.id.equals(word)) {
				s_aux.add(a);
			}
		return s_aux;
	}
	
	
}
