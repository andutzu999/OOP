import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public abstract class Main {

	public static void main(String[] args) throws IOException {
        try {
        	
        	File file = new File("therm.in");
            Scanner input = new Scanner(file);
            PrintWriter printWriter = new PrintWriter("therm.out");
            
            List<Room> cam = new ArrayList<>();
            List<Observe> v_obs = new ArrayList<>();
            List<Temperature> v_temp = new ArrayList<>();
            List<Umiditate> v_umd = new ArrayList<>();
            Observe O = new Observe();
            Temperature T = new Temperature();
            Umiditate U = new Umiditate();
            Trigger_Heat TR = new Trigger_Heat(printWriter);
            Listing LST = new Listing(printWriter);
            int nr_interval;
            int trg = 0;
            
            String line = input.nextLine();
            String[] arrOfStr = line.split(" ", 4);
            
            int nr_camere = Integer.parseInt(arrOfStr[0]);
            double temp_globala = Double.parseDouble(arrOfStr[1]);
            long tmp_ref;
            double umiditate_globala = 0;
            
            if(arrOfStr.length == 4) {
            	
            	umiditate_globala = Double.parseDouble(arrOfStr[2]);
            	tmp_ref = Long.parseLong(arrOfStr[3]);
            }
            else
            
            	 tmp_ref = Long.parseLong(arrOfStr[2]);
            
            //System.out.println(line);
        /*    
            
          */  
            for(int i = 1; i <= nr_camere; i++) {
            	
            	String room = input.next();
            	String device_id = input.next();
            	double suprafata = Double.parseDouble(input.next());
            	
            	Room r = new Room(new ArrayList<Observe>(), room, device_id, suprafata);
            	cam.add(r); // adauga obiect in array-ul cu rooms
            	     	
            }
            
            T.inserare_ore(cam , v_obs);
            
            while (input.hasNext()) {
            	
            	String word = input.next();
            	
            	if(word.equals("OBSERVE")) {
            		
            		String dev_id_obs = input.next();
            		//System.out.println(dev_id_obs);
            		long timestamp = Long.parseLong(input.next());
            		double temperatura = Double.parseDouble(input.next());
            		int which_interval = (int)(tmp_ref - timestamp)/3600;
            		//System.out.println(which_interval);
            		T.inserare_temp(cam, v_obs, v_temp, dev_id_obs, temperatura, which_interval, tmp_ref, timestamp);
            		//System.out.println(o.temperatura);
            		//System.out.println(o.timestamp);
            		
            		
            	}
            	
            	if(word.equals("OBSERVEH")) {
            		
            		String dev_id_obs = input.next();
            		//System.out.println(dev_id_obs);
            		long timestamp = Long.parseLong(input.next());
            		double umiditate = Double.parseDouble(input.next());
            		int which_interval = (int)(tmp_ref - timestamp)/3600;
            		U.inserare_umiditate(cam, v_obs, v_umd, dev_id_obs, umiditate, which_interval, tmp_ref, timestamp);
            		trg++;
            	}
            	
            	if(word.equals("TEMPERATURE")) {
            		
            		double word_temp = Double.parseDouble(input.next());
            		//System.out.println(temp_globala);
            		temp_globala = T.Temp_change(temp_globala, word_temp);
            		//System.out.println(temp_globala);
            	}
            	
            	if(word.equals("TRIGGER")){
            		
            		if(trg == 0) {
            		String word3 = input.next();
            		TR.Trigger(cam, v_obs, v_temp, temp_globala);
            		}
            		else
            		{
            			String word3 = input.next();
            			TR.Trigger_umd(cam, v_obs, v_umd, umiditate_globala);
            		}
            		
            	}
            	
            	if(word.equals("LIST")) {
            		String camera = input.next();
            		long start_interval = Long.parseLong(input.next());
            		long stop_interval = Long.parseLong(input.next());
            		int x = (int)(tmp_ref - stop_interval)/3600;
            		int y = (int)(stop_interval - start_interval)/3600;
            		LST.Listare(cam, v_obs, v_temp, x, y, camera);
            		
            	}
            	
            }
            
            //T.print(cam, v_obs, v_temp);
            
            
            
            
            input.close();
            TR.close();
            LST.close();
            
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        } 
        }
}
