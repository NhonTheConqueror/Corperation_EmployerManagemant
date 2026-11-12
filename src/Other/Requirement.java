package Other;
import java.util.ArrayList;

import People.Candidate;
import People.Recruiter;

public class Requirement {
    private ArrayList<Skill> skillsReq;
    private int Min_expReq; //years unit
    private int Max_age;
    private ArrayList<Certificate> certificateReq;
    private ArrayList<String> genderReq; // male || female || other || any (should be empty)
    private String appearanceReq; //good looking || normal || ugly
    
    
    public Requirement(ArrayList<Skill> skillsReq, int Min_expReq, int Max_age, String appearanceReq) {
        this.skillsReq = skillsReq;
        this.Min_expReq = Min_expReq;
        this.Max_age = Max_age;
        this.certificateReq = new ArrayList<>();
        this.genderReq = new ArrayList<>();
        this.appearanceReq = appearanceReq;
    }

    //default methods
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
    public String getAppearanceReq() {return appearanceReq;}
    public void setAppearanceReq(String appearanceReq) {this.appearanceReq = appearanceReq;}
 //__________________________________________________________________________________________________________________   
    //Son
    public void addGenderReq(String gender) {
        genderReq.add(gender.toLowerCase());
    }
    //Son
    public void addSkillReq(Skill skill) {
        skillsReq.add(skill);
    }
    //Nhon
    public void addCertificateReq(Certificate certificate) {
        certificateReq.add(certificate);
    }

}