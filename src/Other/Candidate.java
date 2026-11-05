package Other;
import java.util.ArrayList;
import Main.*;

public class Candidate extends Person {
	private String health;
    private String appearance;
    private ArrayList<Skill> skillList;
    private ArrayList<Certificate> certificateList;
    private int exp; //years unit
    private String appliedPos;
    private Date interviewDate;
   

    public Candidate(String name, String gender, Date birth, String health, String appearance, int exp, String appliedPos, Date interviewDate) {
        super(name, gender, birth);
        this.health = health;
        this.appearance = appearance;
        this.skillList = new ArrayList<>();
        this.certificateList = new ArrayList<>();
        this.exp = exp;
        this.appliedPos = appliedPos;
        this.interviewDate = interviewDate;
    }

    //default method
    public int getExp() {return exp;}
    public String getHealth() {return health;}
    public void setHealth(String health) {this.health = health;}
    public String getAppearance() {return appearance;}
    public void setAppearance(String appearance) {this.appearance = appearance;}
    public ArrayList<Skill> getSkillList() {return skillList;}
    public void setSkillList(ArrayList<Skill> skillList) {this.skillList = skillList;}
    public ArrayList<Certificate> getCertificateList() {return certificateList;}
    public void setCertificateList(ArrayList<Certificate> certificateList) {this.certificateList = certificateList;}
    public String getAppliedPos() {return appliedPos;}
    public void setAppliedPos(String appliedPos) {this.appliedPos = appliedPos;}
    public Date getInterviewDate() {return interviewDate;}
    public void setInterviewDate(Date interviewDate) {this.interviewDate = interviewDate;}
    //////////////////////////////////////////////////////////////////////////////////////////

    
    //find out if the candidate matches the Certificate; Nhon
	public boolean matchCertificate(Certificate certificate) {
		for (Certificate c : certificateList) {
			if(c.equals(certificate)) {
				if(c.getDateGot()!=null) {return c.getDateGot().compareWith(certificate.getDateGot()) >= 0;}
				else if(c.getStatus()!=null) {return c.getStatus().compareToIgnoreCase(certificate.getStatus()) == 0;}
				else if(c.getScore()!=0) {return c.getScore() >= certificate.getScore();}
				else if(c.isPassed()) {return c.isPassed() == certificate.isPassed();}
			}
		}
		return false;
	}

	public static boolean checkCertificates(ArrayList<Certificate> candidateCertificates, ArrayList<Certificate> certificateReq) {
		for(Certificate req : certificateReq) {
			boolean found = false;
			for(Certificate c : candidateCertificates) {
				if(c.getTitle().equalsIgnoreCase(req.getTitle())) {
					if( !(c.equals(req)) ) return false;
					found = true;
					break;
				}
			}
			if(!found) return false;
		}
		return true;
	}


}
