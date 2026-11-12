package Corp;
import java.util.ArrayList;
import java.util.PriorityQueue;

import Other.Date;
import Other.Recruitment;

public class SubsidiaryCp extends Company{
	private Company parentCp;

	/*/
	 * constructor
	 */
    public SubsidiaryCp(String taxCode, String name, String field,
            Date foundingDate, PriorityQueue<Recruitment> recruimentPlans,
            int totalNewEmployees, HR_department hrDepartment,
            Company parentCp)
    {
    	super(taxCode, name, field, foundingDate,recruimentPlans, totalNewEmployees, hrDepartment);
        this.parentCp = parentCp;
    }
//_____________________________________________________________________
    //default methods
    public Company getParentCp() {return parentCp;}
    public void setParentCp(Company parentCp) {this.parentCp = parentCp;}

}
