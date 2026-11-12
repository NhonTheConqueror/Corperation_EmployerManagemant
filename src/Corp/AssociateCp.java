package Corp;
import java.util.PriorityQueue;
import java.util.TreeMap;

import Other.Date;
import Other.Recruitment;

public class AssociateCp extends Company {
	private double parentShares;
    private TreeMap<Company, Double> partnerShares;	
    
    /*/
     * constructor
     */
    public AssociateCp(String taxCode, String name, String field, Date foundingDate,
    		PriorityQueue<Recruitment> recruimentPlans, int totalNewEmployees, HR_department hrDepartment,
    		double parentShares, TreeMap<Company, Double> partnerShares)
    {
    	super(taxCode, name, field, foundingDate,recruimentPlans, totalNewEmployees, hrDepartment);
		this.parentShares = parentShares;
		this.partnerShares = (partnerShares != null) ? new TreeMap<>(partnerShares) : new TreeMap<>();
	}
//_________________________________________________________________________
    
    //default methods
    public double getParentShares() {return parentShares;}
    public void setParentShares(double parentShares) {this.parentShares = parentShares;}
    public TreeMap<Company, Double> getPartnerShares() {return partnerShares;}


}
