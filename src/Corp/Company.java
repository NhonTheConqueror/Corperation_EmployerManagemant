package Corp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.PriorityQueue;

import Other.Date;
import Other.Recruitment;
import People.NewEmployee;



public abstract class Company{
    protected String taxCode;
    protected String name;
    protected String field;
    protected Date foundingDate;
    protected PriorityQueue<Recruitment> recruimentPlans;
    protected HR_department hrDepartment;

    

    public Company(String taxCode, String name, String field, Date foundingDate,
    		PriorityQueue<Recruitment> recruimentPlans, HR_department hrDepartment)
    {
        this.taxCode = taxCode;
        this.name = name;
        this.field = field;
        this.foundingDate = foundingDate;
        this.recruimentPlans = (recruimentPlans != null)
                                ? recruimentPlans
                                : new PriorityQueue<>();
        this.hrDepartment = hrDepartment;
    }
    
    //default methods
    public String getTaxCode() {return taxCode;}
    public void setTaxCode(String taxCode) {this.taxCode = taxCode;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getField() {return field;}
    public void setField(String field) {this.field = field;}
    public Date getFoundingDate() {return foundingDate;}
    public void setFoundingDate(Date foundingDate) {this.foundingDate = foundingDate;}
    public PriorityQueue<Recruitment> getRecruimentPlans() {return recruimentPlans;}
    public void setRecruimentPlans(PriorityQueue<Recruitment> recruimentPlans) {
    	this.recruimentPlans = recruimentPlans;
    }
//_____________________________________________________________________


    
    //Nhon
    public void setTaskForHR(Date date) {
    	if(this.recruimentPlans.peek().getStartedDate().equalTo(date)) {
			//set task for HR
    		hrDepartment.takeTask(this.recruimentPlans.poll());
		}
		
	}
    
    public void setTaskForHR() {
    	hrDepartment.takeTask(this.recruimentPlans.poll());
    }
    
    public abstract void updateNewEmployees();
    public abstract ArrayList<NewEmployee> getNewEmployees();
}
