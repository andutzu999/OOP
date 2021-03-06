import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Locale;
import java.util.*;


public class Temperature implements Comparable<Temperature>{

	double temperatura;
	
	public Temperature(double temperatura) {
		
		this.temperatura = temperatura;
	}
	
	public Temperature() {
	}
	
	public int compareTo(Temperature t) {
		if( this.temperatura > t.temperatura)
			return 1;
		if( this.temperatura == t.temperatura)
			return 0;
		if( this.temperatura < t.temperatura)
			return -1;
		return 2;
		
	}
	
	public void inserare_ore(List<Room> cam, List<Observe> v_obs) {
		
		for(Room a : cam) {
			
			for(int i = 0; i < 24; i++) {
				
				Observe o = new Observe(new ArrayList<Umiditate>(), new ArrayList<Temperature>(), i);
				a.v_obs.add(o);
			}	
			
		}
	}
	
	public void inserare_temp(List<Room> cam, List<Observe> v_obs, List<Temperature> v_temp, String dev_id_obs, double temperatura, int which_interval, long tmp_ref, long timestamp) {
		
		for(Room a : cam) {
			
			if(a.device_id.equals(dev_id_obs)) {
				
				for(int i = 0; i< 24; i++) {
					
					if(a.v_obs.get(i).nr_interval == which_interval && timestamp < tmp_ref) {
						
						
						Temperature t = new Temperature(temperatura);
						a.v_obs.get(i).v_temp.add(t);
						Collections.sort(a.v_obs.get(i).v_temp);
						
							
					}
					
				}
				
			}
		}
	}
	
	public void print(List<Room> cam, List<Observe> v_obs, List<Temperature> v_temp) {
		
		for(Room a: cam) {
			
			for(int i = 0; i< 24; i++) {
				
				
					for(int j = 0; j< a.v_obs.get(i).v_temp.size(); j++) {
						
					//	System.out.println(a.v_obs.get(i).v_temp.get(j).temperatura);
					System.out.println(String.format(Locale.US , "%.2f", a.v_obs.get(i).v_temp.get(j).temperatura));
					
				
					}	
			}
		}
	}
	
	public double Temp_change(double temp_globala, double word_temp) {
		
		temp_globala = word_temp;
		return temp_globala;
	}
}	

