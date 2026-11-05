package Main;
import Other.*;
import java.util.TreeMap;

public class AssociateCp extends Company {
	private double parentShares;
    private TreeMap<Company, Double> partnerShares;	
    
    public AssociateCp() {
        this.partnerShares = new TreeMap<>();
    }

    public AssociateCp(String taxCode, String name, String field, Date foundingDate, double parentShares) {
        super(taxCode, name, field, foundingDate);
        this.parentShares = parentShares;
        this.partnerShares = new TreeMap<>();
    }

    public double getParentShares() {
        return parentShares;
    }

    public void setParentShares(double parentShares) {
        this.parentShares = parentShares;
    }

    public TreeMap<Company, Double> getPartnerShares() {
        return partnerShares;
    }


}
