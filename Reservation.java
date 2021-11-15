import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/*A Reservation Object*/
public class Reservation {
	private String resType, name, roomType;
	private double total;
	public String checkIn, checkOut;
	private static int bookings = 0;
	private int refNo;
	String filePath = "";
	
	/*Reservation Constructor*/
	public Reservation(String name, String type, String roomType, String checkIn, String checkOut) throws Exception{
		if(available(roomType, checkIn, checkOut)) {
			this.name = name;
			this.resType = type;
			this.roomType = roomType;
			this.checkIn = checkIn;
			this.checkOut = checkOut;
			bookings++;
			refNo = bookings;
			addRes();
		}else{
		}
	}
	
	/*Adds reseration to reservation.csv file*/
	public void addRes() {
		try(FileWriter fw = new FileWriter(filePath, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(name+", "+refNo+", "+resType+", "+roomType+", "+checkIn+", "+checkOut);
			    		} catch (IOException e) {
			    
			}
	}
	
	/*Checks if selected room is available for those dates by checking the amount not available in reservation list*/
	public boolean available(String roomType, String checkIn, String checkOut) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
		LocalDate checkIn1 = LocalDate.parse(checkIn, formatter);
		LocalDate checkOut1 = LocalDate.parse(checkOut, formatter);
		File file = new File(filePath);
        FileReader fr = null;
        
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
		}
		
        BufferedReader br = new BufferedReader(fr);
        String line;
        String[] parts;
        int taken = 0;
        
        try {
			while((line = br.readLine()) != null) {
			   parts = line.split(", ");
			   String roomType2 = parts[3];
			   LocalDate checkIn2 = LocalDate.parse(parts[4], formatter);
			   LocalDate checkOut2 = LocalDate.parse(parts[5], formatter);
			   
			   if(roomType2 == roomType && (checkIn1.isBefore(checkIn2) && checkOut1.isBefore(checkIn2)) ||
					   						(checkIn1.isBefore(checkIn2) && checkOut1.isEqual(checkIn2)) ||
					   					 	(checkIn1.isAfter(checkOut2) && checkOut1.isAfter(checkOut2)) ||
					   					 	(checkIn1.isEqual(checkOut2) && checkOut1.isAfter(checkOut2))) {
				   
			   }else{
				   taken++;
			   }
			}
		} catch (IOException e) {
		}
        
        if(taken<RoomList.getRooms(roomType)) {
        	return true;
        }
        
		return false;
	}
}
