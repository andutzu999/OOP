
public class Players {

		public String name;
		public double score;
		private static Players obj2;
		private static Players obj3;
		
		
		private Players() {
		}
		
		public static Players getInstance3() {
			
			if(obj3 == null)
				obj3 = new Players();
			return obj3;
			
		}
	
	public Players(String name, double score) {
		this.name = name;
		this.score = score;
	}
	
	
	public Players getInstance2(String name, double score) {
		
		if(obj2 == null)
			obj2 = new Players(name, score);
		return obj2;
		
	}
	
// ---------------------------------------------------------task1-------------------------------------------------------------------------------
	
}
