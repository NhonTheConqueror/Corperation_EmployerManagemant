package Main;
import Other.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class Recruitment {
	  private ArrayList<Position> hiringPosition;
	    private Date startedDate;
	    private Date endDate;
	    private Map<Person, Position> HRlist;


	    public Recruitment(ArrayList<Position> hiringPosition, Date startedDate, Date endDate, ArrayList<Person> HRlist) {
	        this.hiringPosition = hiringPosition;
	        this.startedDate = startedDate;
	        this.endDate = endDate;
	        this.HRlist = new HashMap<>();
	        
	        for(Person hr: HRlist) {
	        	this.HRlist.put(hr, null);
	        }
	    }

	    //default methods
	    public ArrayList<Position> getHiringPosition() {return hiringPosition;}
	    public void setHiringPosition(ArrayList<Position> hiringPosition) {this.hiringPosition = hiringPosition;}
	    public Date getStartedDate() {return startedDate;}
	    public void setStartedDate(Date startedDate) {this.startedDate = startedDate;}
	    public Date getEndDate() {return endDate;}
	    public void setEndDate(Date endDate) {this.endDate = endDate;}
	    public Map<Person, Position> getHRlist() {return HRlist;}
	    public void setHRlist(Map<Person, Position> HRlist) {this.HRlist = HRlist;}
	    
	    //Son
	    public void addHR(Person hr, Position position) {
	    	if(!HRlist.containsKey(hr)) {
	    		HRlist.put(hr, position);
	    	}
	    }
}
