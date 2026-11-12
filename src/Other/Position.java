package Other;


public class Position {	
	private String posName;
	private int maxQuantity;
	private Requirement requirment;
	private JD jobDescription;
	private Benefit benefit;
	private Date deadline;
	
	// 1: hard - 3,4 HR; 2: medium - 2 HR; 3: easy - 1 HR
	//private int difficultyLevel; //the higher diff level means the more HR employees needed
	
	/*/
	 * constructor for new employee
	 */
	public Position(String posName, Benefit benefit) {
		this.posName = posName;
		this.benefit = benefit;
	}
	
	public Position(String posName, int maxQuantity, Requirement requirment, JD jobDescription, Benefit benefit, Date deadline) {
	    this.posName = posName;
	    this.maxQuantity = maxQuantity;
	    this.requirment = requirment;
	    this.jobDescription = jobDescription;
	    this.benefit = benefit;
	    this.deadline = deadline;
	}
	
	//default methods
	public String getPosName() {return posName;}
	public void setPosName(String posName) {this.posName = posName;}
	public int getMaxQuantity() {return maxQuantity;}
	public void setMaxQuantity(int maxQuantity) {this.maxQuantity = maxQuantity;}
	public Requirement getRequirment() {return requirment;}
	public void setRequirment(Requirement requirment) {this.requirment = requirment;}
	public JD getJobDescription() {return jobDescription;}
	public void setJobDescription(JD jobDescription) {this.jobDescription = jobDescription;}
	public Benefit getBenefit() {return benefit;}
	public void setBenefit(Benefit benefit) {this.benefit = benefit;}
	public Date getDeadline() {return deadline;}
	public void setDeadline(Date deadline) {this.deadline = deadline;}
//_________________________________________________________________________________
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null || this==null) return false;
		Position that = (Position) obj;
		if(this.posName == that.getPosName() && this.maxQuantity == that.getMaxQuantity()
				&& this.requirment.equals(that.getRequirment())) {
			return true;
		} return false;
	}
	
}
