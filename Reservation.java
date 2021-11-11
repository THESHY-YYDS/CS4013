import java.util.*;

/*A Reservation Object*/
public class Reservation {
	private String resType, name, roomType;
	private double total;
	public String checkIn, checkOut;
	private static int bookings = 0;
	private int refNo;
	
	/*Reservation Constructor*/
	public Reservation(String name, String type, String roomType, String checkIn, String checkOut) {
		this.name = name;
		this.resType = type;
		this.roomType = roomType;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		bookings++;
		refNo = bookings;
	}
}
