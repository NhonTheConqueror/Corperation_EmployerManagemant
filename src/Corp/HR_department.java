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
        
        //Main code here
        ArrayList<Position> positions = recruitmentTask.getHiringPosition();
        int numPositions = positions.size();
        int numStaffs = staffs.size();
        // staffs > positions -> Lấy ngẫu nhiên đúng n HR để giao việc (tránh tuyển lố)
        if (numStaffs > numPositions) {
            ArrayList<Recruiter> shuffledStaffs = new ArrayList<>(this.staffs);
            java.util.Collections.shuffle(shuffledStaffs); // Xáo trộn thứ tự list copy staffs (không làm đảo thứ tự list gốc)
            
            for (int i = 0; i < numPositions; i++) {
                shuffledStaffs.get(i).addPostion(positions.get(i));
            }
        } 
        //staffs <= positions
        // Duyệt hết positions và chia xoay vòng (%) -> Mỗi HR chắc chắn nhận ít nhất 1 position
        // ví dụ HR [a,b,c] ; pos [1,2,3,4,5] -> a(1,4) ; b(2,5) ; c(3)
        else {
            for (int i = 0; i < numPositions; i++) {
                this.staffs.get(i % numStaffs).addPostion(positions.get(i));
            }
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
	
	
	//sync data; Nhon
	public Recruitment updateNewEmployees() {
		ArrayList<NewEmployee> newEList = new ArrayList<NewEmployee>();
		for(Recruiter staff: this.staffs) {
			newEList.addAll(staff.getNewEmployees());
		}
		this.recruitmentTask.setNewEmployees(newEList);
		return this.recruitmentTask;
	}
}
