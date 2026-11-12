package People;
import java.util.ArrayList;
import java.util.Random;

import Corp.*;
import Other.Certificate;
import Other.Date;
import Other.Position;
import Other.Skill;

public class Candidate extends Person {
	private String health;
    private String appearance;
    private ArrayList<Skill> skillList;
    private ArrayList<Certificate> certificateList;
    private int exp; //years unit
    private Position appliedPos;

    private int pureLuck;

    public Candidate(String name, String gender, Date birth, String health,
    				String appearance, int exp, Position appliedPos)
    {
        super(name, gender, birth);
        this.health = health;
        this.appearance = appearance;
        this.skillList = new ArrayList<>();
        this.certificateList = new ArrayList<>();
        this.exp = exp;
        this.appliedPos = appliedPos;
        this.pureLuck = new Random().nextInt(3);
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
    public Position getAppliedPos() {return appliedPos;}
    public void setAppliedPos(Position appliedPos) {this.appliedPos = appliedPos;}
    public int getPureLuck() {return this.pureLuck;}
    //___________________________________________________________________________

	public static ArrayList<NewEmployee> toNewEmployee(ArrayList<Candidate> approvedCandidates,
			Position assignedHiringPosition) {
		ArrayList<NewEmployee> newEmployees = new ArrayList<NewEmployee>();
		for(Candidate c: approvedCandidates) {
			newEmployees.add(new NewEmployee(NewEmployee.generateEID(c.getName(), c.getGender()), assignedHiringPosition, c.getName(), c.getGender(), c.getBirth()));
		}
		return newEmployees;
	}



}
