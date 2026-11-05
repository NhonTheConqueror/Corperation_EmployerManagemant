package Main;
import java.util.ArrayList;
import java.util.HashMap;
import Other.*;

public class Skill {
	public String title;
    private double masterRate;
    private String proficiencyLevel; // expert || advanced || intermediate || beginner

    private HashMap<String, Integer> proficiencyLevels = new HashMap<>();
    
    public Skill(String title, double masterRate) {
        this.title = title;
        this.masterRate = masterRate;
    }
        
    public Skill(String title, String proficiencyLevel) {
    	this.title = title;
    	this.proficiencyLevel = proficiencyLevel.toLowerCase();
    	proficiencyLevels.put("beginner", 1);
    	proficiencyLevels.put("intermediate", 2);
    	proficiencyLevels.put("advanced", 3);
    	proficiencyLevels.put("expert", 4);
    }
    
    //default
    public double getMasterRate() {return masterRate;}
    public void setMasterRate(double masterRate) {this.masterRate = masterRate;}
    public String getProficiencyLevel() {return proficiencyLevel;}
    public void setProficiencyLevel(String proficiencyLevel) {this.proficiencyLevel = proficiencyLevel;}

    
    @Override
    //to know if this skill(candidate's skill) is equal or better than the required skill; Nhon
    public boolean equals(Object req) {
    	if(this!=null && this.getClass() != req.getClass()) return false;
    	Skill that = (Skill) req;
    	if(this.title.equalsIgnoreCase(that.title)) {
			if(that.proficiencyLevel != null) {
				if(this.proficiencyLevel==that.proficiencyLevel) return true;
				else if(proficiencyLevels.get(this.proficiencyLevel) >= proficiencyLevels.get(that.proficiencyLevel)) return true;
			}
			else if(that.masterRate != 0) {
				return this.masterRate >= that.masterRate;
			}
		}
		return false;
    }
    
    
    //static method to check if the candidate has all the required skills; Nhon
	public static boolean checkSkills(ArrayList<Skill> skillList, ArrayList<Skill> skillReq) {
		for(Skill req : skillReq) {
			boolean found = false;
			for(Skill skill : skillList) {
				if(skill.title.equalsIgnoreCase(req.title)) {
					if( !(skill.equals(req)) ) return false;
					found = true;
					break;
				}
			}
			if(!found) return false;
		}
		return true;
	}

}



