import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Locale;
import java.util.*;
public class Trigger_Heat {
	
	public PrintWriter printWriter;
	
	public Trigger_Heat(PrintWriter printWriter) {
	
		this.printWriter = printWriter;
	}
	
	public void Trigger(List<Room> cam, List<Observe> v_obs, List<Temperature> v_temp, double temp_globala) {
		double sum1 = 0;
		double sum2 = 0;
		
		for(Room a: cam) {
		
			
			for(int i = 0; i <= 23; i++) {
			
				if(a.v_obs.get(i).v_temp.isEmpty() == false) {
				
					sum1 = sum1 + a.suprafata * a.v_obs.get(i).v_temp.get(0).temperatura;
					break;
				}
			}
			sum2 = sum2 + a.suprafata;
		}
		double t = (double)sum1/sum2;
		//System.out.println(t);
		if(temp_globala > t)
			printWriter.println("YES");
		else
			printWriter.println("NO");
	}
	
	public void Trigger_umd(List<Room> cam, List<Observe> v_obs, List<Umiditate> v_umd, double umiditate_globala) {
		double sum1 = 0;
		double sum2 = 0;
		
		for(Room a: cam) {
		
			
			for(int i = 0; i <= 23; i++) {
			
				if(a.v_obs.get(i).v_umd.isEmpty() == false) {
					
					sum1 = sum1 + a.suprafata * a.v_obs.get(i).v_umd.get(0).umiditate;
					
					break;
			}
		}
			sum2 = sum2 + a.suprafata;
		}
		double t = (double)sum1/sum2;
		//System.out.println(t);
		if(umiditate_globala > t)
			printWriter.println("YES");
		else
			printWriter.println("NO");
	}
	
	public void close() {
		printWriter.close();
	}

}
