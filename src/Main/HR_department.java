package Main;
import java.util.ArrayList;

import Other.*;

public class HR_department {
	private Person head;
	
	private Company company;
	private ArrayList<Recruiter> staffs;
	
	private Recruitment recruitmentTask;
	
	public HR_department(Company company, ArrayList<Recruiter> staffs) {
		this.company = company;
		this.staffs = staffs;
		this.head = staffs.get(0);
	}

	//default methods
	public Person getHead() {return head;}
	public ArrayList<Recruiter> getStaffs() {return staffs;}
	public void setHead(Person head) {this.head = head;}
	public void setStaffs(ArrayList<Recruiter> staffs) {this.staffs = staffs;}

	
	public void takeTask(Recruitment task) {
		this.recruitmentTask = task;
		executing();
	}
	
	private void executing() {
		//assign the task to the recruiters / staffs
		assignPositionsToStaff();
		update();
	}
	
	//AI
	public void assignPositionsToStaff() {
        if (recruitmentTask == null || recruitmentTask.getHiringPosition() == null || recruitmentTask.getHiringPosition().isEmpty()) {
            System.out.println("Không có vị trí tuyển dụng nào để phân bổ.");
            return;
        }
        if (staffs == null || staffs.isEmpty()) {
            System.out.println("Không có nhân viên HR nào để giao việc.");
            return;
        }

        ArrayList<Position> positions = recruitmentTask.getHiringPosition();
        int numPositions = positions.size();
        int numStaffs = staffs.size();

        // Trường hợp 1: Số lượng vị trí bằng số lượng staff (1 - 1)
        if (numPositions == numStaffs) {
            for (int i = 0; i < numPositions; i++) {
                staffs.get(i).setAssignedHiringPosition(positions.get(i));
            }
        } 
        // Trường hợp 2: Số vị trí ít hơn số staff (P < S)
        // Mỗi position có ít nhất 1 staff, các staff còn lại được ưu tiên gán cho position có độ khó cao hơn
        else if (numPositions < numStaffs) {
            // Sắp xếp các position theo độ khó giảm dần (difficultyLevel)
            ArrayList<Position> sortedPositions = new ArrayList<>(positions);
            sortedPositions.sort((p1, p2) -> Integer.compare(p2.getDifficultyLevel(), p1.getDifficultyLevel()));

            // Bước 1: Gán mỗi position cho 1 staff đầu tiên để đảm bảo vị trí nào cũng có người phụ trách
            for (int i = 0; i < numPositions; i++) {
                staffs.get(i).setAssignedHiringPosition(sortedPositions.get(i));
            }

            // Bước 2: Phân bổ các staff còn thừa xoay vòng cho các vị trí có độ khó cao hơn
            for (int i = numPositions; i < numStaffs; i++) {
                Position targetPos = sortedPositions.get((i - numPositions) % numPositions);
                staffs.get(i).setAssignedHiringPosition(targetPos);
            }
        } 
        // Trường hợp 3: Số vị trí nhiều hơn số staff (P > S)
        // Chia xoay vòng (Round-Robin) để mỗi staff gán vị trí chính, và lưu danh sách mở rộng nếu cần
        else {
            for (int i = 0; i < numPositions; i++) {
                Recruiter assignedRecruiter = staffs.get(i % numStaffs);
                Position pos = positions.get(i);

                // Gán vị trí chính (nếu là vị trí đầu tiên recruiter nhận)
                if (assignedRecruiter.getAssignedHiringPosition() == null) {
                    assignedRecruiter.setAssignedHiringPosition(pos);
                }
                
                // Nếu Recruiter hỗ trợ danh sách nhiều vị trí
                assignedRecruiter.addAssignedPosition(pos); 
            }
        }
    }

	private void update() {
		
	}
	
}
