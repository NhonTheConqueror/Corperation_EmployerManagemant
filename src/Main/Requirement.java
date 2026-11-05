package Main;
import Other.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Requirement {
	private HashMap<Person, ArrayList<Candidate>> interviewersList;
	private ArrayList<Person> approvedCandidates;
	private ArrayList<Skill> skillsReq;
	private int Min_expReq; //years unit
	private int Max_age;
	private ArrayList<Certificate> certificateReq;
	private ArrayList<String> genderReq; // male || female || other || any (should be empty)
	private String heatlhReq; // bad || good
	private String appearanceReq; //good looking || normal || ugly
    
	private ArrayList<Person> potentalCandidates; // list of all candidates
    
    public Requirement(int Min_expReq, int Max_age, String heatlhReq, String appearanceReq) {
        this.interviewersList = new HashMap<>();
        this.approvedCandidates = new ArrayList<>();
        this.skillsReq = new ArrayList<>();
        this.Min_expReq = Min_expReq;
        this.Max_age = Max_age;
        this.certificateReq = new ArrayList<>();
        this.genderReq = new ArrayList<>();
        this.heatlhReq = heatlhReq;
        this.appearanceReq = appearanceReq;
    }

    //default methods
    public HashMap<Person, ArrayList<Candidate>> getInterviewers() {return interviewersList;}
    public void setInterviewers(HashMap<Person, ArrayList<Candidate>> interviewersList) {this.interviewersList = interviewersList;}
    public ArrayList<Person> getApprovedCandidates() {return approvedCandidates;}
    public void setApprovedCandidates(ArrayList<Person> approvedCandidates) {this.approvedCandidates = approvedCandidates;}
    public ArrayList<Skill> getSkillsReq() {return skillsReq;}
    public void setSkillsReq(ArrayList<Skill> skillsReq) {this.skillsReq = skillsReq;}
    public int getMin_expReq() {return Min_expReq;}
    public void setMin_expReq(int Min_expReq) {this.Min_expReq = Min_expReq;}
    public int getMax_age() {return Max_age;}
    public void setMax_age(int Max_age) {this.Max_age = Max_age;}
    public ArrayList<Certificate> getCertificateReq() {return certificateReq;}
    public void setCertificateReq(ArrayList<Certificate> certificateReq) {this.certificateReq = certificateReq;}
    public ArrayList<String> getGenderReq() {return genderReq;}
    public void setGenderReq(ArrayList<String> genderReq) {this.genderReq = genderReq;}
    public String getHeatlhReq() {return heatlhReq;}
    public void setHeatlhReq(String heatlhReq) {this.heatlhReq = heatlhReq;}
    public String getAppearanceReq() {return appearanceReq;}
    public void setAppearanceReq(String appearanceReq) {this.appearanceReq = appearanceReq;}
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    //Son
    public void addInterviewer(Person interviewer) {
    	if(!interviewersList.containsKey(interviewer)) {
			interviewersList.put(interviewer, new ArrayList<>());
		}
	}// Son
    public void addCandidateToInterviewer(Person interviewer, Candidate candidate) {
		if(interviewersList.containsKey(interviewer)) {
			interviewersList.get(interviewer).add(candidate);
		}
		else {
			addInterviewer(interviewer);
			interviewersList.get(interviewer).add(candidate);
		}
	}
    //Son
    public void addGenderReq(String gender) {
    	genderReq.add(gender.toLowerCase());
    }
    //Son
    public void addSkillReq(Skill skill) {
		skillsReq.add(skill);
	}
    //Son
    public void addCertificateReq(Certificate certificate) {
    	certificateReq.add(certificate);
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //chek if the candidate meets the requirements; Nhon
    public boolean isQualified(Candidate candidate) {
    	boolean age = (candidate.getAge() <= this.Max_age) && (candidate.getAge() >= 18);
    	boolean health = candidate.getHealth().equalsIgnoreCase("good");
    	boolean exp = (candidate.getExp() >= this.Min_expReq);
    	boolean appearance = candidate.getAppearance().equalsIgnoreCase(appearanceReq) || appearanceReq.equalsIgnoreCase("good looking");
    	boolean skillCheck = Skill.checkSkills(candidate.getSkillList(), this.skillsReq);
    	boolean certificateCheck = Candidate.checkCertificates(candidate.getCertificateList(), this.certificateReq);
    	boolean genderCheck = this.genderReq.isEmpty() || this.genderReq.contains(candidate.getGender().toLowerCase());
    	
    	return age && health && exp && appearance && skillCheck && certificateCheck && genderCheck;    	
	}
    //add the candidate to the list to check later; Nhon
    public void addCandidate(Candidate candidate) {
		if(isQualified(candidate)) {
			potentalCandidates.add(candidate);
		}
	}
    
    //Start the hiring process; Nhon
    public void Start() {
    	
    }
}
