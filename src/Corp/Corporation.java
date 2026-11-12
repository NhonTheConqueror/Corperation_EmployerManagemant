package Corp;
import java.util.ArrayList;

import People.NewEmployee;

public class Corporation {
	private String id;
    private String name;
    private ArrayList<Company> memberCompanies;
	
    private ArrayList<NewEmployee> newEmployeeList;
    
	public Corporation(String id, String name) {
	    this.id = id;
	    this.name = name;
	    this.memberCompanies = new ArrayList<>();
	}
	
	//Default methods
	public String getId() {return id;}	
	public void setId(String id) {this.id = id;}
		public String getName() {return name;}	
	public void setName(String name) {this.name = name;}	
	public ArrayList<Company> getMemberCompanies() {return memberCompanies;}
	public void setMemberCompanies(ArrayList<Company> memberCompanies) {
	    this.memberCompanies = memberCompanies;
	}
	public  ArrayList<NewEmployee> getNewEmployeeList(){
		return this.newEmployeeList;
	}
//_______________________________________________________________________________
	

	public void updateNewEmployees() {
		
		if(newEmployeeList == null) newEmployeeList = new ArrayList<NewEmployee>();
		
		for(Company c: memberCompanies) {
			newEmployeeList.addAll(c.getNewEmployees());
		}
	}
	
}

