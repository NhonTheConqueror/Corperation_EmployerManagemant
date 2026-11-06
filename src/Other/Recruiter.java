package Other;

import Main.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Recruiter extends Person{
	
	private int eID;
	private Position assignedHiringPosition;
	private Date deadline;
	
	private ArrayList<Candidate> approvedCandidates; //pass CV
	private ArrayList<NewEmployee> newEmployees;
	
	private ArrayList<String> terminatingKeywords; //for terminating candidates, if the candidate has any of these keywords in their CV, they will be terminated.
	
	public Recruiter(int eID,Position assignedPosition, String name, String gender, Date birth, Date deadline) {
		super(name, gender, birth);
		this.eID = eID;
		this.assignedHiringPosition = assignedPosition;	
		this.deadline = deadline;
		this.approvedCandidates = new ArrayList<Candidate>();
		this.newEmployees = new ArrayList<NewEmployee>();
		
		this.terminatingKeywords = new ArrayList<String>();
		{
			terminatingKeywords.add("hutech");
			terminatingKeywords.add("rmit");
			terminatingKeywords.add("vlu");
			terminatingKeywords.add("hiu");
		}
	}

	//default methods
    public int getEID() {return eID;}
	public Position getAssignedHiringPosition() {return assignedHiringPosition;}
	public Date getDeadline() {return deadline;}
	public ArrayList<Candidate> getApprovedCandidates() {return approvedCandidates;}
	public ArrayList<NewEmployee> getNewEmployees() {return newEmployees;}
	public ArrayList<String> getTerminatingKeywords() {return terminatingKeywords;}
	public void seteID(int eID) {this.eID = eID;}
	public void setAssignedHiringPosition(Position assignedHiringPosition) {
		this.assignedHiringPosition = assignedHiringPosition;
	}
	public void setDeadline(Date deadline) {this.deadline = deadline;}
	public void setApprovedCandidates(ArrayList<Candidate> approvedCandidates) {
		this.approvedCandidates = approvedCandidates;
	}
	public void setNewEmployees(ArrayList<NewEmployee> newEmployees) {
		this.newEmployees = newEmployees;
	}
	public void setTerminatingKeywords(ArrayList<String> terminatingKeywords) {
		this.terminatingKeywords = terminatingKeywords;
	}
//________________________________________________________________


	//check if the candidate meets the requirements; Nhon
    private boolean isQualified(Candidate candidate, Requirement req) { //todo: this = Requirement
        boolean age = (candidate.getAge() <= req.getMax_age()) && (candidate.getAge() >= 18);
        boolean health = candidate.getHealth().equalsIgnoreCase("good");
        boolean exp = (candidate.getExp() >= req.getMin_expReq());
        boolean appearance = candidate.getAppearance().equalsIgnoreCase(req.getAppearanceReq()) || req.getAppearanceReq().equalsIgnoreCase("good looking");
        boolean skillCheck = Skill.checkSkills(candidate.getSkillList(), req.getSkillsReq());
        boolean certificateCheck = Certificate.isPassedCertificate(candidate.getCertificateList(), req.getCertificateReq());
        boolean genderCheck = req.getGenderReq().isEmpty() || req.getGenderReq().contains(candidate.getGender().toLowerCase());
        
        return age && health && exp && appearance && skillCheck && certificateCheck && genderCheck;    	
    }
    
    
    
    //realtime update ;Nhon
    public void checkCandidate(Candidate candidate) {
    	if(isQualified(candidate, this.assignedHiringPosition.getRequirment())) {
    		this.approvedCandidates.add(candidate);
    		interviewing();
    	}
    }
    
    //Nhon
    private void interviewing()
    {
    	// if this HR get more approved candidates than position requirement, terminating a few of them...
    	int n = this.approvedCandidates.size() - assignedHiringPosition.getMaxQuantity(), id;
    	
    	if(n>0)
    	{
    		
    		//Prioritize experience first
    		ArrayList<Integer> removingID = new ArrayList<Integer>();
    		for(int i = 0; i<n; i++) {
    			id = new Random().nextInt(approvedCandidates.size());
    			if(approvedCandidates.get(id).getExp()
    					 == this.assignedHiringPosition.getRequirment().getMin_expReq()) {
    				removingID.add(id);
    			}
    		}
    		
    		terminating(removingID); removingID = new ArrayList<Integer>();
    		n = this.approvedCandidates.size() - assignedHiringPosition.getMaxQuantity();
    		
    		// Second is luck:))
    		if(n>0) {
    			for(int i = 0; i<n; i++) {
    				id = new Random().nextInt(approvedCandidates.size());
    				if(approvedCandidates.get(id).getPureLuck() == 0) removingID.add(id);
    			}    			
    		}
    		
    		terminating(removingID); removingID = new ArrayList<Integer>();
    		n = this.approvedCandidates.size() - assignedHiringPosition.getMaxQuantity();
    		
    		//Third is university: tứ đại bổ túc - specific name : hutech; rmit; vlu; hiu.
    		if(n>0) {
				for(int i = 0; i<n; i++) {
					id = new Random().nextInt(approvedCandidates.size());
					String universityName = Certificate.findUniversityName(approvedCandidates.get(id).getCertificateList());
					if(terminatingKeywords.contains(universityName.toLowerCase())) removingID.add(id);
				}    			
			}
			
			terminating(removingID); removingID = new ArrayList<Integer>();
			n = this.approvedCandidates.size() - assignedHiringPosition.getMaxQuantity();
			
			//fourth is appearance: good looking > normal > ugly
			if(n>0) {
				for(int i = 0; i<n; i++) {
					id = new Random().nextInt(approvedCandidates.size());
					if(approvedCandidates.get(id).getAppearance().equalsIgnoreCase("ugly")) removingID.add(id);
					else if(approvedCandidates.get(id).getAppearance().equalsIgnoreCase("normal")) removingID.add(id);
				}    			
			}
			
			terminating(removingID); removingID = new ArrayList<Integer>();
			n = this.approvedCandidates.size() - assignedHiringPosition.getMaxQuantity();
			
			//last is random:))
			if(n>0) {
				for(int i = 0; i<n; i++) {
					id = new Random().nextInt(approvedCandidates.size());
					removingID.add(id);
				}    			
			}
			
			terminating(removingID);
    	}
    	
    	setNewEmployees(Candidate.toNewEmployee(this.approvedCandidates, this.assignedHiringPosition));
    	
    }
    
	//Nhon
	private void terminating(ArrayList<Integer> removingID) {
		for(int id: removingID) {
			this.approvedCandidates.remove(id);
		}
	}

    

}
