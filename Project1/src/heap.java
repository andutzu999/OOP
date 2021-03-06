import java.io.*;
import java.util.*;
public class heap { 
	
	
    private pasager[] Heap; 
    private int size; 
    private int maxsize; 
	 private int index = 1; 
	 public PrintWriter printWriter;
  
	 
    // Constructor to initialize an 
    // empty max heap with given maximum 
    // capacity. 
    public heap (int maxsize, PrintWriter printWriter ) 
    { 
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new pasager[this.maxsize + 1]; 
        this.printWriter = printWriter;
       
        
    } 
  
    // Returns position of parent 
    private int parent(int pos) 
    { 
        return pos / 2; 
    } 
  
    // Below two functions return left and 
    // right children. 
    private int leftChild(int pos) 
    { 
        return (2 * pos); 
    } 
    private int rightChild(int pos) 
    { 
        return (2 * pos) + 1; 
    } 
  
    // Returns true of given node is leaf 
    private boolean isLeaf(int pos) 
    { 
         if (pos > (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
  
   private void swap(int fpos, int spos) 
    { 
       pasager tmp; 
        tmp = Heap[fpos]; 
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = tmp; 
    } 
   
   
  

  
    // A recursive function to max heapify the given 
    // subtree. This function assumes that the left and 
    // right subtrees are already heapified, we only need 
    // to fix the root. 
    private void maxHeapify(int pos) 
    { 
        if (isLeaf(pos)) 
            return; 
  
        if (Heap[pos].priority < Heap[leftChild(pos)].priority ||  
            Heap[pos].priority < Heap[rightChild(pos)].priority) { 
  
            if (Heap[leftChild(pos)].priority >= Heap[rightChild(pos)].priority ) { 
                swap(pos, leftChild(pos)); 
                maxHeapify(leftChild(pos)); 
            } 
            else 
            { 
                swap(pos, rightChild(pos)); 
                maxHeapify(rightChild(pos)); 
            } 
        } 
    } 
  
    // Inserts a new element to max heap 
    public void insert(pasager p, int priority) 
    { 
    	
        Heap[++size] = p;
        
        // Traverse up and fix violated property 
        int current = size; 
   
        				while( current != 1 && Heap[current].priority != Heap[parent(current)].priority && Heap[current].priority > Heap[parent(current)].priority ) { 
        					 
        					pasager q = Heap[current]; 
        					Heap[current] = Heap[parent(current)]; 
        					Heap[parent(current)] = q;
        					current = parent(current); 
        				}
        	
    }
    public void print() 
    { 
    	System.out.print( size +  " ");
        for (int i = 1; i <= size; i++) {
            System.out.print( Heap[i].word +  " " + Heap[i].priority);
            
        }
    } 
  
    // Remove an element from max heap 
    public void embark() 
    	{ 
    		pasager popped = Heap[1]; 
    		Heap[1] = Heap[size--]; 
    		maxHeapify(1);
    		
    		
    		
        
    	} 
    
    
    
    public void list()  {
        
    	
        		Stack<Integer> stack = new Stack<Integer>();
        		stack.push(1);
        	while(!stack.empty()) {
        			
        			int i = stack.pop();
        			if(i == 1)
        				printWriter.write(Heap[i].word );
        			else
        				printWriter.write(" " + Heap[i].word );
        			

        			if(2 * i + 1 <= size) 
        				stack.push(2 * i + 1);
        
        			if(2 * i<= size) 
        				stack.push(2 * i);
        			
        			
        		}	
        
        	}   
    
   
    	public void close() {
    		printWriter.close();
    	}
    	
}
  
	    




