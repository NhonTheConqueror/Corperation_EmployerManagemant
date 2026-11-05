package Main;
import Other.*;

public class JD {
	  public String describe;
	    public double workHours;
	    public String workLocation;
	    public JD() {
	    }

	    public JD(String describe, double workHours, String workLocation) {
	        this.describe = describe;
	        this.workHours = workHours;
	        this.workLocation = workLocation;
	    }

	    public String getDescribe() {
	        return describe;
	    }

	    public void setDescribe(String describe) {
	        this.describe = describe;
	    }

	    public double getWorkHours() {
	        return workHours;
	    }

	    public void setWorkHours(double workHours) {
	        this.workHours = workHours;
	    }

	    public String getWorkLocation() {
	        return workLocation;
	    }

	    public void setWorkLocation(String workLocation) {
	        this.workLocation = workLocation;
	    }

		@Override
		public String toString() {
			return "JD [describe=" + describe + ", workHours=" + workHours + ", workLocation=" + workLocation + "]";
		}


}
