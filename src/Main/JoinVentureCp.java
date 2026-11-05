package Main;
import Other.*;

import java.util.ArrayList;
public class JoinVentureCp extends Company {
	 private ArrayList<Company> partners;
	  public JoinVentureCp() {
	        this.partners = new ArrayList<>();
	    }

	    public JoinVentureCp(String taxCode, String name, String field, Date foundingDate, ArrayList<Company> partners) {
	        super(taxCode, name, field, foundingDate);
	        this.partners = partners;
	    }

	    public ArrayList<Company> getPartners() {
	        return partners;
	    }

	    public void setPartners(ArrayList<Company> partners) {
	        this.partners = partners;
	    }


}
