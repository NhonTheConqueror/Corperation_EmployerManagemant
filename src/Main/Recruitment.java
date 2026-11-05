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
	    public Recruitment() {
	        this.hiringPosition = new ArrayList<>();
	        this.HRlist = new HashMap<>();
	    }

	    public Recruitment(Date startedDate, Date endDate) {
	        this.hiringPosition = new ArrayList<>();
	        this.startedDate = startedDate;
	        this.endDate = endDate;
	        this.HRlist = new HashMap<>();
	    }

	    public ArrayList<Position> getHiringPosition() {
	        return hiringPosition;
	    }

	    public void setHiringPosition(ArrayList<Position> hiringPosition) {
	        this.hiringPosition = hiringPosition;
	    }

	    public Date getStartedDate() {
	        return startedDate;
	    }

	    public void setStartedDate(Date startedDate) {
	        this.startedDate = startedDate;
	    }

	    public Date getEndDate() {
	        return endDate;
	    }

	    public void setEndDate(Date endDate) {
	        this.endDate = endDate;
	    }

	    public Map<Person, Position> getHRlist() {
	        return HRlist;
	    }

	    public void setHRlist(Map<Person, Position> HRlist) {
	        this.HRlist = HRlist;



}
}
