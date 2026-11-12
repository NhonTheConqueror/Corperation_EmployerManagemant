package Other;
import java.util.ArrayList;
import java.util.Map;

import People.Candidate;
import People.NewEmployee;

import java.util.HashMap;

public class Recruitment{
    private ArrayList<Position> hiringPosition;
    private Date startedDate;
    private Date endDate;
    
    //private ArrayList<Candidate> candidates;
    private HashMap<Position, ArrayList<NewEmployee>> newEmployees;
    
    /*/
     * constructor
     */
    public Recruitment(ArrayList<Position> hiringPosition,
						Date startedDate, Date endDate)
    {
    	this.hiringPosition = hiringPosition;
		this.startedDate = startedDate;
		this.endDate = endDate;
		
		for(Position p: hiringPosition) {
			newEmployees.put(p, new ArrayList<NewEmployee>());
		}
		
		this.newEmployees = new HashMap<>();
    }


    //default methods
    public ArrayList<Position> getHiringPosition() {return hiringPosition;}
    public void setHiringPosition(ArrayList<Position> hiringPosition) {this.hiringPosition = hiringPosition;}
    public Date getStartedDate() {return startedDate;}
    public void setStartedDate(Date startedDate) {this.startedDate = startedDate;}
    public Date getEndDate() {return endDate;}
    public void setEndDate(Date endDate) {this.endDate = endDate;}
    // Getters and Setters for ApprovedCandidates
    public HashMap<Position, ArrayList<NewEmployee>> getNewEmployees() {return newEmployees;}
    public void setNewEmployees(HashMap<Position, ArrayList<Candidate>> newE) {
    	this.newEmployees = newEmployees;
    }
 //_________________________________________________________________
    
    
    
}












