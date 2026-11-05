package Main;
import Other.*;

public class Certificate {
	public String title;
    public String specificName;
    private Date dateGot; //to Recruiters, dateGot is the date which they accept certificate validation, can't allow any date before dateGot
    private double score;
    private String status;
    private boolean passed;

    public Certificate(String title, String specificName, double score) {
        this.title = title;
        this.specificName = specificName;
        this.score = score;
    }

    public Certificate(String title, String specificName, String status) {
        this.title = title;
        this.specificName = specificName;
        this.status = status;
    }
    
    public Certificate(String title, String specificName, boolean passed) {
		this.title = title;
		this.specificName = specificName;
		this.passed = passed;
	}
    
    public Certificate(String title, String specificName, Date dateGot) {
		this.title = title;
		this.specificName = specificName;
		this.dateGot = dateGot;
	}
    
    //default method
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getSpecificName() {return specificName;}
    public void setSpecificName(String specificName) {this.specificName = specificName;}
    public Date getDateGot() {return dateGot;}
    public void setDateGot(Date dateGot) {this.dateGot = dateGot;}
    public double getScore() {return score;}
    public void setScore(double score) {this.score = score;}
    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}
    public boolean isPassed() {return passed;}
    public void setPassed(boolean passed) {this.passed = passed;}
    
    

    
    @Override //Son
    public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) return false;
		Certificate that = (Certificate) obj;		
		return title.equals(that.title) && specificName.equals(that.specificName);
	}
    
    //find out if the candidate matches the Certificate; Nhon
    public boolean isSatify(Candidate candidate) {
    	return candidate.matchCertificate(this);
	}

}
