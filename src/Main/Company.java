package Main;
import Other.*;
import java.util.Stack;
public class Company {
	  protected String taxCode;
	    protected String name;
	    protected String field;
	    protected Date foundingDate;
	    protected Stack<Recruitment> recruimentPlans;
	    protected int totalNewEmployees;
	    public Company() {
	        this.recruimentPlans = new Stack<>();
	    }

	    public Company(String taxCode, String name, String field, Date foundingDate) {
	        this.taxCode = taxCode;
	        this.name = name;
	        this.field = field;
	        this.foundingDate = foundingDate;
	        this.recruimentPlans = new Stack<>();
	    }

	    public String getTaxCode() {
	        return taxCode;
	    }

	    public void setTaxCode(String taxCode) {
	        this.taxCode = taxCode;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getField() {
	        return field;
	    }

	    public void setField(String field) {
	        this.field = field;
	    }

	    public Date getFoundingDate() {
	        return foundingDate;
	    }

	    public void setFoundingDate(Date foundingDate) {
	        this.foundingDate = foundingDate;
	    }

	    public Stack<Recruitment> getRecruimentPlans() {
	        return recruimentPlans;
	    }

	    public void setRecruimentPlans(Stack<Recruitment> recruimentPlans) {
	        this.recruimentPlans = recruimentPlans;
	    }

	    public int getTotalNewEmployees() {
	        return totalNewEmployees;
	    }

	    public void setTotalNewEmployees(int totalNewEmployees) {
	        this.totalNewEmployees = totalNewEmployees;
	    }



}
