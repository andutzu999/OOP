import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Observe {
	
	double temperatura;
	long timestamp;
	long nr_interval;
	List<Temperature> v_temp;
	List<Umiditate> v_umd;
	
	public Observe() {
		
	}
	
	public Observe(List<Umiditate> v_umd, List<Temperature> v_temp, int nr_interval) {
		
		this.v_umd = v_umd;
		this.v_temp = v_temp;
		this.nr_interval = nr_interval;
	}
	
	public List<Temperature> getList(){
		return this.v_temp;
	}
}
 
