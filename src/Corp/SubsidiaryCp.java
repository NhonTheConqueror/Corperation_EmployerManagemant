package Corp;
import java.util.ArrayList;
import java.util.PriorityQueue;

import Other.Date;
import Other.Recruitment;
import People.NewEmployee;

public class SubsidiaryCp extends Company{
	private Company parentCp; // Or parrent corporation
	
	private ArrayList<NewEmployee> newEmployeeList;

	/*/
	 * constructor
	 */
    public SubsidiaryCp(String taxCode, String name, String field, Date foundingDate,
    		PriorityQueue<Recruitment> recruimentPlans, HR_department hrDepartment,Company parentCp)
    {
    	super(taxCode, name, field, foundingDate,recruimentPlans, hrDepartment);
        this.parentCp = parentCp;
    }
    //default methods
    public Company getParentCp() {return parentCp;}
    public void setParentCp(Company parentCp) {this.parentCp = parentCp;}
//_____________________________________________________________________
    
    
	@Override
	public void updateNewEmployees() {
		this.newEmployeeList = this.hrDepartment.getNewEmployees();
	}
	@Override
	public ArrayList<NewEmployee> getNewEmployees() {
		return this.newEmployeeList;
	}

}
