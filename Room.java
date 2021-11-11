public class Room {
	private String type;
	private int occupancy;
	
	public Room(String type, int occ) {
		this.type = type;
		occupancy = occ;
	}
	
	public String getType() {
		return type;
	}
	
	public int getOccupancy() {
		return occupancy;
	}
}
