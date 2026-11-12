package People;

import java.util.ArrayList;

import Other.Date;
import Other.Position;

import java.time.LocalDate;

public class NewEmployee extends Person{

	private int eID;
	private Position position;
	
	public NewEmployee(int eID, Position pos,String name, String gender, Date birth) {
		super(name, gender, birth);
		this.eID = eID;
		this.position = pos;
	}

	//default methods
	public int geteID() {return eID;}
	public void seteID(int eID) {this.eID = eID;}
	public Position getPosition() {return position;}
	public void setPosition(Position position) {this.position = position;}

	public static int generateEID(String name, String gender) {
		return Integer.parseInt(LocalDate.now().getMonth().toString() 
			+ Integer.toString(name.hashCode()) + Integer.toString((gender.equals("male")? 0:1)));
	}



}
