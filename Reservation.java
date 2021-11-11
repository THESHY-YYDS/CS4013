import java.io.*;
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
		if(available(roomType, checkIn, checkOut)) {
			this.name = name;
			this.resType = type;
			this.roomType = roomType;
			this.checkIn = checkIn;
			this.checkOut = checkOut;
			bookings++;
			refNo = bookings;
		}
	}
	
	public void addRes(Reservation a) {
		try(FileWriter fw = new FileWriter("Desktop\reservations.csv", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(name+", "+refNo+", "+resType+", "+roomType+", "+checkIn+", "+checkOut);
			    		} catch (IOException e) {
			    
			}
	}
	
	public boolean available(String roomType, String checkIn, String checkOut) {
		return false;
	}
}
