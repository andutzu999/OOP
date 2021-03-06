import java.util.Collections;
import java.util.List;

public class Umiditate implements Comparable<Umiditate>{

	double umiditate;
	
	public Umiditate(double umiditate) {
		
		this.umiditate = umiditate;
	}
	
	public Umiditate() {
	}
	
	public int compareTo(Umiditate u) {
		if( this.umiditate < u.umiditate)
			return 1;
		if( this.umiditate == u.umiditate)
			return 0;
		if( this.umiditate > u.umiditate)
			return -1;
		return 2;
		
	}
	
	public void inserare_umiditate(List<Room> cam, List<Observe> v_obs, List<Umiditate> v_umd, String dev_id_obs, double umiditate, int which_interval, long tmp_ref, long timestamp){
		
		for(Room a : cam) {
			
			if(a.device_id.equals(dev_id_obs)) {
				
				for(int i = 0; i< 24; i++) {
					
					if(a.v_obs.get(i).nr_interval == which_interval && timestamp < tmp_ref) {
						
						Umiditate t = new Umiditate(umiditate);
						a.v_obs.get(i).v_umd.add(t);
						Collections.sort(a.v_obs.get(i).v_umd);
					}
				}
			}
		}
	}
		
}
