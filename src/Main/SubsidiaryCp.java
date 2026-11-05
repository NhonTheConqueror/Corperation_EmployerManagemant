package Main;
import Other.*;

public class SubsidiaryCp extends Company{
	private Company parentCp;
	 public SubsidiaryCp() {
	    }

	    public SubsidiaryCp(String taxCode, String name, String field, Date foundingDate, Company parentCp) {
	        super(taxCode, name, field, foundingDate);
	        this.parentCp = parentCp;
	    }

	    public Company getParentCp() {
	        return parentCp;
	    }

	    public void setParentCp(Company parentCp) {
	        this.parentCp = parentCp;
	    }

}
