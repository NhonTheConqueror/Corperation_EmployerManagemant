package Corp;
import java.util.PriorityQueue;

import Other.Date;
import Other.Recruitment;
import People.NewEmployee;

import java.util.ArrayList;

public class JoinVentureCp extends Company {
    private ArrayList<Company> partners;
    private ArrayList<NewEmployee> newEmployeeList;

    /*/
     * constructor
     */
    public JoinVentureCp(String taxCode, String name, String field,
                         Date foundingDate, PriorityQueue<Recruitment> recruimentPlans,
                         HR_department hrDepartment, ArrayList<Company> partners)
    {
        super(taxCode, name, field, foundingDate,recruimentPlans,hrDepartment);
        this.partners = (partners != null)
                        ? new ArrayList<>(partners)
                        : new ArrayList<>();
    }
    
    //default methods
    public ArrayList<Company> getPartners() {return partners;}
    public void setPartners(ArrayList<Company> partners) {this.partners = partners;}
//____________________________________________________________________

    //Son
    public void addCompany(Company company) {
		if (company != null && !partners.contains(company)) {
			partners.add(company);
		}
	}

	@Override
	public void updateNewEmployees() {
		this.newEmployeeList = this.hrDepartment.getNewEmployees();
	}
	@Override
	public ArrayList<NewEmployee> getNewEmployees() {
		return this.newEmployeeList;
	}
}
