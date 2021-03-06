import java.util.List;

public class   pasager {


	// Java program to implement Max Heap 
	  
	   
	    String id;
	    String name;
	    int age;
	    String ticket;
	    boolean imb_p;
	    boolean needs;
	    int priority;
	    String word;
	    pasager p;
	    List<pasager> t;
	  
	    // Constructor to initialize an 
	    // empty max heap with given maximum 
	    // capacity. 
	/*    public pasageri(int maxsize) 
	    { 
	        this.maxsize = maxsize; 
	        this.size = 0; 
	        Heap = new pasageri[this.maxsize + 1]; 
	         
	    } 
	    */
	    
	    public pasager(String word, int priority) {
			this.word = word;
			this.priority = priority;
		}
	    
	    public pasager(String id, String name, int age, String ticket, boolean imb_p, boolean needs) {
	    	this.id = id;
	    	this.name = name;
	    	this.age = age;
	    	this.ticket = ticket;
	    	this.imb_p = imb_p;
	    	this.needs = needs;
	    	
	    }

	    public pasager() {
	    }
	    
	  
	    
}
