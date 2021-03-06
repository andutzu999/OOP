import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Room {
	
	List<Observe> v_obs;
	String room;
	String device_id;
	double suprafata;
	

	public Room(List<Observe> v_obs, String room, String device_id, double suprafata) {
		
		this.v_obs = v_obs;
		this.room = room;
		this.device_id = device_id;
		this.suprafata = suprafata;
	}
	
}
