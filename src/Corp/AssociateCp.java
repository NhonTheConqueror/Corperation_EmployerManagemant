package Corp;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeMap;

import Other.Date;
import Other.Recruitment;
import People.NewEmployee;

public class AssociateCp extends Company {
	private double parentShares;
    private TreeMap<Company, Double> partnerShares;	
    private ArrayList<NewEmployee> newEmployeeList;
    
    /*/
     * constructor
     */
    public AssociateCp(String taxCode, String name, String field, Date foundingDate,
    		PriorityQueue<Recruitment> recruimentPlans, HR_department hrDepartment,
    		double parentShares, TreeMap<Company, Double> partnerShares)
    {
    	super(taxCode, name, field, foundingDate,recruimentPlans,hrDepartment);
		this.parentShares = parentShares;
		this.partnerShares = (partnerShares != null) ? new TreeMap<>(partnerShares) : new TreeMap<>();
	}
    
    //default methods
    public double getParentShares() {return parentShares;}
    public void setParentShares(double parentShares) {this.parentShares = parentShares;}
    public TreeMap<Company, Double> getPartnerShares() {return partnerShares;}
//_________________________________________________________________________
    
	@Override
	public void updateNewEmployees() {
		this.newEmployeeList = this.hrDepartment.getNewEmployees();
	}
	@Override
	public ArrayList<NewEmployee> getNewEmployees() {
		return this.newEmployeeList;
	}

}
