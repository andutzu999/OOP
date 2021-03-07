import java.util.List;
import java.util.ArrayList;
public class familie extends pasager{

	
	String word;
	List<familie> f;
	int priority;
	
	public familie (String id, String name, int age, String ticket, boolean imb_p, boolean needs) {
    	
		super(id, name, age, ticket, imb_p, needs);
		
    }
	
	public familie() {
	}
	
	public familie(String word, int priority, List<familie> f) {
		
		super(word, priority);
		this.f = f;
	}
	
public int f_priority(List<familie> f, String word) {
		
		int priority = 10;
		for (familie a: f)
			
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

	public List<familie> family(List<familie> f, List<familie> f_aux,  String word) {
	
	
		for (familie a: f)
			if(a.id.equals(word)) {
				f_aux.add(a);
			}
		return f_aux;
	}


}
