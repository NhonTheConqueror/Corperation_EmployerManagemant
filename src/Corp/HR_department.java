package Corp;
import java.util.ArrayList;

import Other.*;
import People.NewEmployee;
import People.Person;
import People.Recruiter;

public class HR_department {
	private Person Manager;
	
	private Company company;
	private ArrayList<Recruiter> staffs;
	
	private Recruitment recruitmentTask;
	
	public HR_department(Company company) {
		this.company = company;
		this.staffs = new ArrayList<Recruiter>();
	}
	
	public HR_department(Company company, ArrayList<Recruiter> staffs) {
		this.company = company;
		this.staffs = staffs;
		this.Manager = staffs.get(0);
	}

	//default methods
	public Person getManager() {return Manager;}
	public ArrayList<Recruiter> getStaffs() {return staffs;}
	public void setManager(Person manager) {this.Manager = manager;}
	public void setStaffs(ArrayList<Recruiter> staffs) {this.staffs = staffs;}
//_________________________________________________________________________________
	
	//Take the task from company; Nhon
	public void takeTask(Recruitment task) {
		this.recruitmentTask = task;
		assignPositionsToStaff();
	}
	
	//assign the positions to the staffs; Nhon
	public void assignPositionsToStaff() {
		//exception handling: check if recruitmentTask or staffs is null or empty
        if (recruitmentTask == null || recruitmentTask.getHiringPosition() == null
        				|| recruitmentTask.getHiringPosition().isEmpty())
        {
            System.out.println("Không có vị trí tuyển dụng nào để phân bổ.");
            return;
        }
        //exception handling: check if there are no staffs in the HR department
        if (staffs == null || staffs.isEmpty()) {
            System.out.println("Không có nhân viên HR nào để giao việc.");
            return;
        }

        ArrayList<Position> positions = recruitmentTask.getHiringPosition();
        int numPositions = positions.size();
        int numStaffs = staffs.size();

        //case 1: staffs = positions
        if (numPositions == numStaffs) {
            for (int i = 0; i < numPositions; i++) {
                staffs.get(i).setAssignedHiringPosition(positions.get(i));
            }
        } 
        // case 2: staffs > positions
        else if (numPositions < numStaffs) {
        	//todo
        } 
        // case 3: staffs < positions
        else {
        	//todo, too lazy now
        }
    }
	
	//for the company to get all the new employees from the HR department; Nhon
	public ArrayList<NewEmployee> getNewEmployees() {
		ArrayList<NewEmployee> ans = new ArrayList<NewEmployee>();
		for(Recruiter staff : staffs) {
			ans.addAll(staff.getNewEmployees());
		}
		return ans;
	}
	
}
