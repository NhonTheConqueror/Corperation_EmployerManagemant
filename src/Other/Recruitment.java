package Other;
import java.util.ArrayList;
import java.util.Map;

import People.Candidate;
import People.NewEmployee;

import java.util.HashMap;

public class Recruitment implements Comparable<Recruitment>{
    private ArrayList<Position> hiringPosition;
    private Date startedDate;
    private Date endDate;
    
    //private ArrayList<Candidate> candidates;
    private ArrayList<NewEmployee> newEmployees;
    
    /*/
     * constructor
     */
    public Recruitment(ArrayList<Position> hiringPosition,
						Date startedDate, Date endDate)
    {
    	this.hiringPosition = hiringPosition;
		this.startedDate = startedDate;
		this.endDate = endDate;
		
		this.newEmployees = new ArrayList<NewEmployee>();		
    }


    //default methods
    public ArrayList<Position> getHiringPosition() {return hiringPosition;}
    public void setHiringPosition(ArrayList<Position> hiringPosition) {this.hiringPosition = hiringPosition;}
    public Date getStartedDate() {return startedDate;}
    public void setStartedDate(Date startedDate) {this.startedDate = startedDate;}
    public Date getEndDate() {return endDate;}
    public void setEndDate(Date endDate) {this.endDate = endDate;}
    //Getters and Setters for ApprovedCandidates; Nhon
    public ArrayList<NewEmployee> getNewEmployees() {return newEmployees;}
    public void setNewEmployees(ArrayList<NewEmployee> newE) {
    	this.newEmployees = newE;
    }
 //_________________________________________________________________
    


    //make the plans list sorted by nearest start date
    @Override
    public int compareTo(Recruitment that) {
        if (that == null || that.getStartedDate() == null) return -1;
        if (this.startedDate == null) return 1;
        return -this.startedDate.compareWith(that.getStartedDate());
    }
    
    
}












