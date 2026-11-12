package Other;

import java.util.ArrayList;

public class Certificate {
	private String title;
    private String specificName;
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
		return title.equals(that.title);
	}
    //Son
    public boolean equalToSpecific(Certificate that) {	
    	return this.specificName.equals(that.specificName);
    }

    //find out if the candidate matches the Certificate; Nhon
	public static boolean isPassedCertificate(ArrayList<Certificate> candidateReqList, ArrayList<Certificate> certificateList) {
		for(Certificate cert: certificateList) {
			boolean metCert = false;
			for (Certificate candidateCert : candidateReqList) {
				if(candidateCert.equals(cert)) {
					if(candidateCert.getDateGot()!=null) {metCert = candidateCert.getDateGot().compareWith(cert.getDateGot()) >= 0;}
					if(candidateCert.getStatus()!=null) {metCert = candidateCert.getStatus().compareToIgnoreCase(cert.getStatus()) == 0;}
					if(candidateCert.getScore()!=0) {metCert = candidateCert.getScore() >= cert.getScore();}
					if(candidateCert.isPassed()) {metCert = candidateCert.isPassed() == cert.isPassed();}
				}
			}
			if(!metCert) return false;
		}
		return true;
	}

	
	//find out the university name of the candidate; Nhon
	public static String findUniversityName(ArrayList<Certificate> certificateList) {
		for(Certificate cert: certificateList) {
			if(cert.getTitle().equalsIgnoreCase("university")) return cert.getSpecificName();
		}
		//would never happen because the candidate must have a university certificate to graduate and get a job, but just in case, return null
		return null;
	}
     

}
