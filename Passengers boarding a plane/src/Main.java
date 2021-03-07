import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public abstract class Main {

	public static void main(String[] args) throws IOException {
        try { 
        /*	File inputFile = new File("farrago.txt");
            File outputFile = new File("outagain.txt"); */
            FileInputStream reader = new FileInputStream("input.in");  //citire din fisier
          /*  FileOutputStream wr = new FileOutputStream("output.in"); */
            
            FileReader fr = new FileReader("input.in");
            BufferedReader br = new  BufferedReader(fr);
            
                  
            File file = new File("input.in");
            Scanner input = new Scanner(file);
            int c;
            PrintWriter printWriter = new PrintWriter("output.out");
            
      /*  printWriter.write("ax"); */
            
            singur S = new singur();
            familie F = new familie();
            grup G = new grup();
            heap maxHeap = new heap(100, printWriter);
            
            List<familie> f_array = new ArrayList<>();
            List<grup> g_array = new ArrayList<>();
            List<singur> s_array = new ArrayList<>();
            List<singur> s_aux = new ArrayList<>();
            List<grup> g_aux = new ArrayList<>();
            List<familie> f_aux = new ArrayList<>();
          
        	  int j = 1;
            int lines = Integer.parseInt(input.next());
           /* System.out.println(lines); */
            
            for(int i = 0; i < lines; i++) {
            	
            	String word1 = input.next();
            	String word2 = input.next();
            	String word3 = input.next();
            	String word4 = input.next();
            	String word5 = input.next();
            	String word6 = input.next();
            	/* System.out.println(word1 + " " + word2 + " " + word3 + " " + word4 + " " + word5 + " " + word6); */
            	
            
            if(word1.charAt(0) == 'f') {
				familie f = new familie( word1 ,word2, Integer.parseInt(word3), word4, Boolean.parseBoolean(word5), Boolean.parseBoolean(word6) );
				f_array.add(f); // array cu obiecte de tip familie
			}
			if(word1.charAt(0) == 'g') {
				grup g = new grup(  word1 ,word2, Integer.parseInt(word3), word4, Boolean.parseBoolean(word5), Boolean.parseBoolean(word6)  );
				g_array.add(g); // array cu obiecte de tip grup
			}
			
			if(word1.charAt(0) == 's') {
				singur s = new singur(  word1 ,word2, Integer.parseInt(word3), word4, Boolean.parseBoolean(word5), Boolean.parseBoolean(word6)  );
				s_array.add(s); // array cu obiecte de tip singur
				}
			
            }
            while (input.hasNext()) {
            	
            
            String word7 = input.next();
			if(word7.equals("insert")) {
				String word8 = input.next();
				
				if(word8.charAt(0) == 's') {
					
					String word = word8; 
					int priority = 0; 
					priority = S.s_priority(s_array, word);
					s_aux = S.single(s_array, s_aux, word);
					pasager p = new singur(word, priority, s_aux);
					 maxHeap.insert(p ,priority); 
					 s_aux.clear();
				
					 
					
				}
				
				if(word8.charAt(0) == 'f') {
					String word = word8;
					int priority = 0;
					priority = F.f_priority(f_array, word);
					f_aux  = F.family(f_array, f_aux , word);
					pasager p = new familie(word,priority, f_aux);
					maxHeap.insert(p ,priority); 
					f_aux.clear();
					
				
				}
				
				if(word8.charAt(0) == 'g') {
					String word = word8;
					int priority = 0;
					priority = G.g_priority(g_array, word);
					g_aux = G.group(g_array, g_aux, word);
					pasager p = new grup(word, priority,  g_aux);
					 maxHeap.insert(p ,priority); 
					 g_aux.clear();
					 
					 
				
				}
				
			
          }  	
 
		/*	 maxHeap.print(); */
			if(word7.equals("embark"))		
				maxHeap.embark();
			if(word7.equals("list")) {
			
				if(j == 1)
				{
					maxHeap.list();	
					j++;
				}
				else
				{
					printWriter.println();
					maxHeap.list();	
				}
		
		/*	maxHeap.print(); */
			
			}
			
			
      /*      reader.close();*/
			
            fr.close();
            }
          
            maxHeap.close();
        
           
           /* maxHeap.print(); */
        /*    maxHeap.list();
           maxHeap.embark();
           maxHeap.list(); */
 /* maxHeap.display(); */ 
          /* maxHeap.print(); */
         /*  maxHeap.embark(); */
         /*  maxHeap.list(); */

       } catch (IOException e) {
            e.printStackTrace();
        } 
    }
 
}
