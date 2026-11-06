package Other;

public class JD {
  	private String describe;
    private double workHours;
    private String workLocation;

    public JD(String describe, double workHours, String workLocation) {
        this.describe = describe;
        this.workHours = workHours;
        this.workLocation = workLocation;
    }
//___________________________________________________________________
    //default methods
    public String getDescribe() {return describe;}
    public void setDescribe(String describe) {this.describe = describe;}
    public double getWorkHours() {return workHours;}
    public void setWorkHours(double workHours) {this.workHours = workHours;}
    public String getWorkLocation() {return workLocation;}
    public void setWorkLocation(String workLocation) {this.workLocation = workLocation;}
	
    
    //Son
    @Override
	public String toString() {
		return "JD [describe=" + describe + ", workHours=" + workHours + ", workLocation=" + workLocation + "]";
	}


}
