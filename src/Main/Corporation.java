package Main;
import Other.*;
import java.util.ArrayList;

public class Corporation {
	  private String id;
	    private String name;
	    private ArrayList<Company> memberCompanies;
	    private int totalNewEmployees;
	
public Corporation() {
    this.memberCompanies = new ArrayList<>();
}

public Corporation(String id, String name) {
    this.id = id;
    this.name = name;
    this.memberCompanies = new ArrayList<>();
}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public ArrayList<Company> getMemberCompanies() {
    return memberCompanies;
}

public void setMemberCompanies(ArrayList<Company> memberCompanies) {
    this.memberCompanies = memberCompanies;
}
public int getTotalNewEmployees(int totalNewEmployees) {
	return totalNewEmployees;
}
public void setTotalNewEmployees(int totalNewEmployees) {
    this.totalNewEmployees = totalNewEmployees;
}

}

