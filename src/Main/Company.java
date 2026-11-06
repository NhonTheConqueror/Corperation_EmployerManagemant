package Main;
import java.time.LocalDate;
import java.util.PriorityQueue;

import Other.Date;



public class Company implements Comparable<Recruitment>{
    protected String taxCode;
    protected String name;
    protected String field;
    protected Date foundingDate;
    protected PriorityQueue<Recruitment> recruimentPlans;
    protected int totalNewEmployees;
    protected HR_department hrDepartment;



    public Company(String taxCode, String name, String field,
                   Date foundingDate, PriorityQueue<Recruitment> recruimentPlans,
                   int totalNewEmployees, HR_department hrDepartment) {
        this.taxCode = taxCode;
        this.name = name;
        this.field = field;
        this.foundingDate = foundingDate;
        this.recruimentPlans = (recruimentPlans != null)
                                ? recruimentPlans
                                : new PriorityQueue<>();
        this.totalNewEmployees = totalNewEmployees;
        this.hrDepartment = hrDepartment;
    }
    
//_____________________________________________________________________
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
    public int getTotalNewEmployees() {return totalNewEmployees;}
    public void setTotalNewEmployees(int totalNewEmployees) {
        this.totalNewEmployees = totalNewEmployees;
    }


    //make the plans list sorted by nearest start date
    @Override
    public int compareTo(Recruitment that) {
    	if (that == null) return -1;
		return -this.recruimentPlans.peek().getStartedDate().compareWith(that.getStartedDate());
	}
    
    //
    public void setTaskForHR(Date date) {
    	if(this.recruimentPlans.peek().getStartedDate().equalTo(date)) {
			//set task for HR
    		hrDepartment.takeTask(this.recruimentPlans.peek());
		}
		
	}
    
    public void setTaskForHR() {
    	//To do
    }
}
