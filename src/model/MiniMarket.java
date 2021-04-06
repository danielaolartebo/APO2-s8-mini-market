package model;
import java.util.*;
import exceptions.NoDayException;
import exceptions.NoAgeException;

public class MiniMarket {
	
	private String name;
	private int count;
	private int day;
	private ArrayList<User> users;
	
	public MiniMarket(String name) {
		       
		this.name = name;
		count = 0;
		Calendar c = new GregorianCalendar();
		day = (c.get(Calendar.DATE));
		users = new ArrayList<User>();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public void increaseCounter() {
		count++;
	}
	
	public int getCount() {
		return count;
	}
	
	public void Register(User u) throws NoAgeException, NoDayException {
		
	int penultimateNumber = Character.getNumericValue((u.getDocument().charAt((u.getDocument().length())-2)));

	if(u.getType().equalsIgnoreCase("TI")) {			
			throw new NoAgeException();
	}else if((penultimateNumber%2 == 0 && day %2 == 0) || (penultimateNumber%2 != 0 && day%2 != 0)) {
			throw new NoDayException();
		}else{
			users.add(u);		
		}
	}
	
	public int getDay() {
		return day;
	}
}
