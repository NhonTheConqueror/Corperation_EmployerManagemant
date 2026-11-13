import static org.junit.jupiter.api.Assertions.*;
 

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import Corp.*;
import Other.*;
import People.*;
class TestingAll {

	//Corp
	@Test
	//test Date_Lê Hoàng Thái Sơn 2511130204
	void testingDate() {
		Date d1 = new Date(12, 7, 2026);
		Date d2 = new Date(10, 7, 2026);
		Date d3 = new Date(11, 7, 2026);
	// Test compareWith()	
		assertEquals(-1, d1.compareWith(d2));
        assertEquals(1, d2.compareWith(d3));
    //Test equalTo(LocalDate)
        assertTrue(d2.equalTo(LocalDate.of(2026, 7, 10)));
        assertFalse(d2.equalTo(LocalDate.of(2026, 7, 11)));
    //Test equalTo(Date)
        assertTrue(d1.equalTo(new Date(12, 7, 2026)));
        assertTrue(d2.equalTo(new Date(10, 7, 2026)));
    // Test getAge()
        assertEquals(LocalDate.now().getYear() - 2000, new Date(1, 1, 2000).getAge());
    }

	

	@Test
	//test benefit_Lê Hoàng Thái Sơn 2511130204
	void testingBenefit() {
		ArrayList<String> decrise1 = new ArrayList<>();
		decrise1.add("Bảo hiểm sức khỏe FPT Care");
		decrise1.add("Thưởng tháng 13");
		ArrayList<String> decrise2 = new ArrayList<>();
		decrise2.add("Bảo hiểm 24/7 BKAV");
		decrise2.add("Phụ cấp ăn trưa");
		ArrayList<String> decrise3 = new ArrayList<>();
		decrise3.add("Thưởng dự án Game VNG");
		decrise3.add("Du lịch hàng năm");
		Benefit be1 = new Benefit(decrise1, 1500, 2500);
		Benefit be2 = new Benefit(decrise2, 1200, 2000);
		Benefit be3 = new Benefit(decrise3, 1800, 3500);
		System.out.println("=== BENEFIT ===");
		System.out.println(be1.getDescribe() + ", " + be1.getMin_wage() + ", " + be1.getMax_wage());
		System.out.println(be2.getDescribe() + ", " + be2.getMin_wage() + " ," + be2.getMax_wage());
		System.out.println(be3.getDescribe() + " ," + be3.getMin_wage() + " ," + be3.getMax_wage());
		
		
	}
	@Test
	//test JD_Đặng Hoài Nhơn 2511130192
	void testingJD() {
		JD jd1 = new JD("Phát triển và bảo trì website", 8, "TP.HCM" );
		JD jd2 = new JD("Kĩ sư AI", 8, "TP.HCM" );
		JD jd3 = new JD("Phát triển game", 8, "TP.HCM" );
		System.out.println("=== JD ===");
		System.out.println("Mô tả:" + jd1.getDescribe() + ", giờ làm việc: " + jd1.getWorkHours() + ", địa điểm làm việc: " + jd1.getWorkLocation());
		System.out.println("Mô tả:" + jd2.getDescribe() + ", giờ làm việc: " + jd2.getWorkHours() + ", địa điểm làm việc: " + jd2.getWorkLocation());
		System.out.println("Mô tả:" + jd3.getDescribe() + ", giờ làm việc: " + jd3.getWorkHours() + ", địa điểm làm việc:" + jd3.getWorkLocation());
		
	}
	
	@Test
	//test person_Lê Hoàng Thái Sơn 2511130204
	void testingPerson() {
		 Date birth1 = new Date(10, 1, 2007);
	     Date birth2 = new Date(4, 3, 2007);
	     Person per1 = new Person("Lê Hoàng Thái Sơn", "Nam", birth1);
	     Person per2 = new Person("Đặng Hoài Nhơn", "Nam", birth2);
     // getAge() 
	         assertEquals(LocalDate.now().getYear() - 2007, per1.getAge());
	         assertEquals(LocalDate.now().getYear() - 2007, per2.getAge());
	     System.out.println("=== PERSON ===");
	     System.out.println("Tên: " + per1.getName() + ", giới tính:  " + per1.getGender() + ", ngày sinh: " + per1.getBirth());
	     System.out.println("Tên: " + per2.getName() + ", giới tính:  " + per2.getGender() + ", ngày sinh: " + per2.getBirth());
		
	}
	
	@Test
	//test skill_Đặng Hoài Nhơn 2511130192
	void testingSkill() {
		Skill s1 = new Skill("Java", 4);
		Skill s2 = new Skill("Python", 3);
		Skill s3 = new Skill("C++", 5);
		
		// test equal lower (Ứng viên "advanced" < yêu cầu "expert" -> false)
		assertFalse(new Skill("Java", "advanced").equals(new Skill("Java", "expert")));
		// test equal higher (Ứng viên "intermediate" > yêu cầu "beginner" -> true)
		assertTrue(new Skill("Java", "intermediate").equals(new Skill("Java", "beginner")));
		// test equal same (Ứng viên "expert" == yêu cầu "expert" -> true)
		assertTrue(new Skill("Java", "expert").equals(new Skill("Java", "expert")));
		
		// test equal masterate
		assertTrue(new Skill("Java", 8.0).equals(new Skill("Java", 6.0)));
		assertFalse(new Skill("Java", 5.0).equals(new Skill("Java", 6.0)));
		
		// test checkSkills available (Ứng viên "expert" >= yêu cầu "advanced" -> true)
		ArrayList<Skill> skillList1 = new ArrayList<>();
		skillList1.add(new Skill("Java", "expert"));
		skillList1.add(new Skill("Python", 9.0));
		ArrayList<Skill> skillReq1 = new ArrayList<>();
		skillReq1.add(new Skill("Java", "advanced"));
		skillReq1.add(new Skill("Python", 8.0));
		assertTrue(Skill.checkSkills(skillList1, skillReq1));
		
		// test checkSkills missing (Thiếu kỹ năng Python -> false)
		ArrayList<Skill> skillList2 = new ArrayList<>();
		skillList2.add(new Skill("Java", "expert"));
		ArrayList<Skill> skillReq2 = new ArrayList<>();
		skillReq2.add(new Skill("Java", "advanced"));
		skillReq2.add(new Skill("Python", 8.0));
		assertFalse(Skill.checkSkills(skillList2, skillReq2));   
		
		System.out.println("=== SKILL ===");
		System.out.println("Kỹ năng: " + s1.title + ", mức độ: " + s1.getMasterRate());
		System.out.println("Kỹ năng: " + s2.title + ", mức độ: " + s2.getMasterRate());
		System.out.println("Kỹ năng: " + s3.title + ", mức độ: " + s3.getMasterRate());		
	}
	
	@Test
	//test certificate_Đặng Hoài Nhơn 2511130192
	void testingCertificate() {
	    Certificate c1 = new Certificate("English", "IELTS", new Date(12, 1, 2026));
	    c1.setScore(8.0);
	    c1.setStatus("valid");
	    c1.setPassed(true);
	    Certificate c2 = new Certificate("English", "TOEIC", new Date(12, 1, 2026));
	    c2.setScore(850.0);
	    c2.setStatus("valid");
	    c2.setPassed(true);
	    // equals same
	    assertTrue(c1.equals(c2));
	    // equalToSpecific
	    assertFalse(c1.equalToSpecific(c2));
	    // isPassedCertificate
	    ArrayList<Certificate> reqList = new ArrayList<>();
	    reqList.add(c1);
	    ArrayList<Certificate> candiList = new ArrayList<>();
	    candiList.add(c1);
	    boolean result = Certificate.isPassedCertificate(reqList, candiList);
	    assertTrue(result);
	    // test findUniversityName
	    Certificate c3 = new Certificate("University", "Bach Khoa University", new Date(12, 1, 2026));
	    c3.setScore(8.5);
	    c3.setStatus("valid");
	    c3.setPassed(true);
	    Certificate c4 = new Certificate("University", "Nong Lam University", new Date(12, 1, 2026));
	    c4.setScore(850);
	    c4.setStatus("valid");
	    c4.setPassed(true);
	    ArrayList<Certificate> certs1 = new ArrayList<>();
	    certs1.add(c1);
	    certs1.add(c3); 
	    ArrayList<Certificate> certs2 = new ArrayList<>();
	    certs2.add(c2);
	    certs2.add(c4);
	    assertEquals("Bach Khoa University", Certificate.findUniversityName(certs1));
	    assertEquals("Nong Lam University", Certificate.findUniversityName(certs2));
	    System.out.println("=== CERTIFICATE ===");
	    System.out.println(" + Tiêu đề: " + c1.getTitle() + " ,Tên cụ thể: " + c1.getSpecificName() + " ,Ngày nhận: " + c1.getDateGot() + " ,Điểm số: " + c1.getScore() + " ,Trạng thái: " + c1.getStatus() + " ,Đã đậu: " + c1.isPassed());
	    System.out.println(" + Tiêu đề: " + c2.getTitle() + " ,Tên cụ thể: " + c2.getSpecificName() + " ,Ngày nhận: " + c2.getDateGot() + ", Điểm số: " + c2.getScore() + " ,Trạng thái: " + c2.getStatus() + " ,Đã đậu: " + c2.isPassed());
	}
	@Test
	//requirement_Lê Hoàng Thái Sơn 2511130204
	void testingRequirement() {
		Skill s1 = new Skill("Java", 4);
		Skill s2 = new Skill("Python", 3);
		 Certificate c1 = new Certificate("English", "IELTS", new Date(12, 1, 2026));
		    c1.setScore(8.0);
		    c1.setStatus("valid");
		    c1.setPassed(true);
		    Certificate c2 = new Certificate("English", "TOEIC", new Date(12, 1, 2026));
		    c2.setScore(850.0);
		    c2.setStatus("valid");
		    c2.setPassed(true);
	    Requirement req = new Requirement(new ArrayList<>(), 2, 35, "good looking");
		req.addSkillReq(s1);
		req.addSkillReq(s2);
		req.addCertificateReq(c1);
		req.addCertificateReq(c2);
		req.addGenderReq("Nam");
		//Test addSkillReq
		req.addSkillReq(s1);
		assertEquals(3, req.getSkillsReq().size());
		assertEquals("Java", req.getSkillsReq().get(0).title);
		//Test addCertificateReq
		req.addCertificateReq(c1);
		assertEquals(3, req.getCertificateReq().size());
		assertEquals("IELTS", req.getCertificateReq().get(0).getSpecificName());
		System.out.println("=== REQUIREMENT ===");
		System.out.println(" + Kỹ năng yêu cầu 1: " + req.getSkillsReq().get(0).title);
		System.out.println(" + Chứng chỉ yêu cầu 1: " + req.getCertificateReq().get(0).getSpecificName());
		System.out.println(" + Chứng chỉ yêu cầu 2: " + req.getCertificateReq().get(1).getSpecificName());
		System.out.println(" + Kinh nghiệm tối thiểu: " + req.getMin_expReq() + " năm");
		System.out.println(" + giới tính: " + req.getGenderReq() );
		
	}
	@Test
	//Position_Đặng Hoài Nhơn 2511130192
	void testingPosition() {
		Requirement req = new Requirement(new ArrayList<>(), 2, 35, "good looking");
		Requirement req2 = new Requirement(new ArrayList<>(), 1, 32, "normal");
		Requirement req3 = new Requirement(new ArrayList<>(), 5, 35, "normal");
		JD jd1 = new JD("Phát triển và bảo trì website", 8, "TP.HCM" );
		JD jd2 = new JD("Kĩ sư AI", 8, "TP.HCM" );
		JD jd3 = new JD("Phát triển game", 8, "TP.HCM" );
		ArrayList<String> decrise1 = new ArrayList<>();
		decrise1.add("Bảo hiểm sức khỏe FPT Care");
		decrise1.add("Thưởng tháng 13");
		ArrayList<String> decrise2 = new ArrayList<>();
		decrise2.add("Bảo hiểm 24/7 BKAV");
		decrise2.add("Phụ cấp ăn trưa");
		ArrayList<String> decrise3 = new ArrayList<>();
		decrise3.add("Thưởng dự án Game VNG");
		decrise3.add("Du lịch hàng năm");
		Benefit be1 = new Benefit(decrise1, 1500, 2500);
		Benefit be2 = new Benefit(decrise2, 1200, 2000);
		Benefit be3 = new Benefit(decrise3, 1800, 3500);
		Date deadline1 = new Date(30, 12, 2026);
		Position p1 = new Position("kĩ sư phần mềm", 5, req, jd1, be1, deadline1);
		Position p2 = new Position("kĩ sư phần mềm", 5, req2, jd2, be2, deadline1);
		Position p3 = new Position("kiểm thử viên phần mềm", 2, req3, jd3, be3, deadline1);
		// test equal
		assertTrue(p2.equals(p2)); 
		assertFalse(p1.equals(p3)); 
			System.out.println("=== POSITION ===");
			System.out.println(" + Tên vị trí 1: " + p2.getPosName());
			System.out.println(" + Số lượng tuyển: " + p2.getMaxQuantity());
			System.out.println(" + Lương tối thiểu (Benefit): " + p2.getBenefit().getMin_wage());
			System.out.println(" + Tên vị trí 2: " + p1.getPosName());
			System.out.println(" + Số lượng tuyển: " + p1.getMaxQuantity());
			System.out.println(" + Lương tối thiểu (Benefit): " + p1.getBenefit().getMin_wage());
			System.out.println(" + Tên vị trí 3: " + p3.getPosName());
			System.out.println(" + Số lượng tuyển: " + p3.getMaxQuantity());
			System.out.println(" + Lương tối thiểu (Benefit): " + p3.getBenefit().getMin_wage());
		
	}
	@Test
	//recruitment_Lê Hoàng Thái Sơn 2511130204
	void testingRecruitment() {
		Date start1 = new Date(10, 7, 2026);
		Date end1 = new Date(20, 7, 2026);
		Date start2 = new Date(1, 8, 2026);
		Date end2 = new Date(15, 8, 2026);
		Requirement req = new Requirement(new ArrayList<>(), 2, 35, "good looking");
		Requirement req2 = new Requirement(new ArrayList<>(), 1, 32, "normal");
		Requirement req3 = new Requirement(new ArrayList<>(), 5, 35, "normal");
		JD jd1 = new JD("Phát triển và bảo trì website", 8, "TP.HCM" );
		JD jd2 = new JD("Kĩ sư AI", 8, "TP.HCM" );
		JD jd3 = new JD("Phát triển game", 8, "TP.HCM" );
		ArrayList<String> decrise1 = new ArrayList<>();
		decrise1.add("Bảo hiểm sức khỏe FPT Care");
		decrise1.add("Thưởng tháng 13");
		ArrayList<String> decrise2 = new ArrayList<>();
		decrise2.add("Bảo hiểm 24/7 BKAV");
		decrise2.add("Phụ cấp ăn trưa");
		ArrayList<String> decrise3 = new ArrayList<>();
		decrise3.add("Thưởng dự án Game VNG");
		decrise3.add("Du lịch hàng năm");
		Benefit be1 = new Benefit(decrise1, 1500, 2500);
		Benefit be2 = new Benefit(decrise2, 1200, 2000);
		Benefit be3 = new Benefit(decrise3, 1800, 3500);
		Date deadline1 = new Date(30, 12, 2026);
		Position p1 = new Position("kĩ sư phần mềm", 5, req, jd1, be1, deadline1);
		Position p2 = new Position("kĩ sư phần mềm", 5, req2, jd2, be2, deadline1);
		Position p3 = new Position("kiểm thử viên phần mềm", 2, req3, jd3, be3, deadline1);
		ArrayList<Position> pos1 = new ArrayList<>();
		pos1.add(p1);
		pos1.add(p2);
		ArrayList<Position> pos2 = new ArrayList<>();
		pos2.add(p3);
		Recruitment r1 = new Recruitment(pos1, start1, end1);
		Recruitment r2 = new Recruitment(pos2, start2, end2);
		ArrayList<Recruitment> RecruitList = new ArrayList<>();
		RecruitList.add(r1);
		RecruitList.add(r2);
		System.out.println("=== RECRUITMENT ===");
		System.out.println("Tổng số đợt tuyển dụng: " + RecruitList.size());
		int count = 1;
		for (Recruitment r : RecruitList) {
			System.out.println("\n--- Đợt tuyển dụng " + count + " ---");
			System.out.println(" + Ngày bắt đầu: " + r.getStartedDate());
			System.out.println(" + Ngày kết thúc: " + r.getEndDate());
			System.out.println(" + Số vị trí tuyển: " + r.getHiringPosition().size());
			count++;
		}
		}
	@Test
	//NewEmployee_Đặng Hoài Nhơn 2511130192
	void testingNewemployee() {
		Date birth1 = new Date(10, 1, 2007);
	    Date birth2 = new Date(4, 3, 2007);
		Requirement req = new Requirement(new ArrayList<>(), 2, 35, "good looking");
		Requirement req2 = new Requirement(new ArrayList<>(), 1, 32, "normal");
		Requirement req3 = new Requirement(new ArrayList<>(), 5, 35, "normal");
		JD jd1 = new JD("Phát triển và bảo trì website", 8, "TP.HCM" );
		JD jd2 = new JD("Kĩ sư AI", 8, "TP.HCM" );
		JD jd3 = new JD("Phát triển game", 8, "TP.HCM" );
		ArrayList<String> decrise1 = new ArrayList<>();
		decrise1.add("Bảo hiểm sức khỏe FPT Care");
		decrise1.add("Thưởng tháng 13");
		ArrayList<String> decrise2 = new ArrayList<>();
		decrise2.add("Bảo hiểm 24/7 BKAV");
		decrise2.add("Phụ cấp ăn trưa");
		ArrayList<String> decrise3 = new ArrayList<>();
		decrise3.add("Thưởng dự án Game VNG");
		decrise3.add("Du lịch hàng năm");
		Benefit be1 = new Benefit(decrise1, 1500, 2500);
		Benefit be2 = new Benefit(decrise2, 1200, 2000);
		Benefit be3 = new Benefit(decrise3, 1800, 3500);
		Date deadline1 = new Date(30, 12, 2026);
		Position p1 = new Position("kĩ sư phần mềm", 5, req, jd1, be1, deadline1);
		Position p2 = new Position("kĩ sư phần mềm", 5, req2, jd2, be2, deadline1);
		Position p3 = new Position("kiểm thử viên phần mềm", 2, req3, jd3, be3, deadline1);
		NewEmployee emp1 = new NewEmployee(101, p1, "Lê Hoàng Thái Sơn", "Nam", birth1);
		NewEmployee emp2 = new NewEmployee(102, p2, "Đặng Hoài Nhơn", "Nam", birth2);
		//test generateEID
		int generatedId1 = NewEmployee.generateEID("Lê Hoàng Thái Sơn", "Nam");
		assertTrue(generatedId1 > 0);
		int generatedId2 = NewEmployee.generateEID("Đặng Hoài Nhơn", "Nam");
		assertTrue(generatedId2 > 0);
		System.out.println("=== NEW EMPLOYEE ===");
		System.out.println(" + Mã nhân viên (eID): " + emp1.geteID());
		System.out.println(" + Tên nhân viên: " + emp1.getName());
		System.out.println(" + Vị trí công việc: " + emp1.getPosition().getPosName());
		System.out.println(" + Mã EID tự động sinh: " + generatedId1);
		System.out.println(" + Mã nhân viên (eID): " + emp2.geteID());
		System.out.println(" + Tên nhân viên: " + emp2.getName());
		System.out.println(" + Vị trí công việc: " + emp2.getPosition().getPosName());
		System.out.println(" + Mã EID tự động sinh: " + generatedId2);

	}
	@Test
	//Candidate_Đặng Hoài Nhơn 2511130192
	void testingCandidate() {
		Date birth1 = new Date(10, 1, 2007);
	    Date birth2 = new Date(4, 3, 2007);
	    Skill s1 = new Skill("Java", 4);
		Skill s2 = new Skill("Python", 3);
		Skill s3= new Skill("C++", 5);
		 Certificate c1 = new Certificate("English", "IELTS", new Date(12, 1, 2026));
		    c1.setScore(8.0);
		    c1.setStatus("valid");
		    c1.setPassed(true);
		    Certificate c2 = new Certificate("English", "TOEIC", new Date(12, 1, 2026));
		    c2.setScore(850.0);
		    c2.setStatus("valid");
		    c2.setPassed(true);
	    Requirement req = new Requirement(new ArrayList<>(), 2, 35, "good looking");
		Requirement req2 = new Requirement(new ArrayList<>(), 1, 32, "normal");
		Requirement req3 = new Requirement(new ArrayList<>(), 5, 35, "normal");
		JD jd1 = new JD("Phát triển và bảo trì website", 8, "TP.HCM" );
		JD jd2 = new JD("Kĩ sư AI", 8, "TP.HCM" );
		JD jd3 = new JD("Phát triển game", 8, "TP.HCM" );
		ArrayList<String> decrise1 = new ArrayList<>();
		decrise1.add("Bảo hiểm sức khỏe FPT Care");
		decrise1.add("Thưởng tháng 13");
		ArrayList<String> decrise2 = new ArrayList<>();
		decrise2.add("Bảo hiểm 24/7 BKAV");
		decrise2.add("Phụ cấp ăn trưa");
		ArrayList<String> decrise3 = new ArrayList<>();
		decrise3.add("Thưởng dự án Game VNG");
		decrise3.add("Du lịch hàng năm");
		Benefit be1 = new Benefit(decrise1, 1500, 2500);
		Benefit be2 = new Benefit(decrise2, 1200, 2000);
		Benefit be3 = new Benefit(decrise3, 1800, 3500);
		Date deadline1 = new Date(30, 12, 2026);
		Position p1 = new Position("kĩ sư phần mềm", 5, req, jd1, be1, deadline1);
		Position p2 = new Position("kĩ sư phần mềm", 5, req2, jd2, be2, deadline1);
		Position p3 = new Position("kiểm thử viên phần mềm", 2, req3, jd3, be3, deadline1);
		Candidate candi1 = new Candidate("Lê Hoàng Thái Sơn", "Nam", birth1, "Good", "Normal", 3, p1);
		Candidate candi2 = new Candidate("Đặng Hoài Nhơn", "Nam", birth2, "Good", "Good looking", 4, p2);
		candi1.getSkillList().add(s1);
		candi1.getSkillList().add(s2);
		candi1.getCertificateList().add(c1);
		candi2.getSkillList().add(s2);
		candi2.getSkillList().add(s3);
		candi2.getCertificateList().add(c2);
		//test static toNewEmployee
		ArrayList<Candidate> approvedList = new ArrayList<>();
		approvedList.add(candi1);
		approvedList.add(candi2);
		ArrayList<NewEmployee> convertedEmployees = Candidate.toNewEmployee(approvedList);
		assertEquals(2, convertedEmployees.size());
		assertEquals("Lê Hoàng Thái Sơn", convertedEmployees.get(0).getName());
		assertEquals("Đặng Hoài Nhơn", convertedEmployees.get(1).getName());
		System.out.println("=== CANDIDATE  ===");
		System.out.println(" + Ứng viên 1: " + candi1.getName() + " - Kinh nghiệm: " + candi1.getExp() + " năm" +" - Vị trí ứng tuyển: " + candi1.getAppliedPos().getPosName());
		System.out.println(" + Ứng viên 2: " + candi2.getName() + " - Kinh nghiệm: " + candi2.getExp() + " năm" + " - Vị trí ứng tuyển: " + candi2.getAppliedPos().getPosName());
		System.out.println(" + Đã chuyển đổi thành công sang " + convertedEmployees.size() + " nhân viên mới (NewEmployee)!");
		
	}
	@Test
	//recruiter_Lê Hoàng Thái Sơn 2511130204
	void testingRecruiter() {
		Date birth1 = new Date(10, 1, 2007);
	    Date birth2 = new Date(4, 3, 2007);
	    Requirement req = new Requirement(new ArrayList<>(), 2, 35, "good looking");
		Requirement req2 = new Requirement(new ArrayList<>(), 1, 32, "normal");
		Requirement req3 = new Requirement(new ArrayList<>(), 5, 35, "normal");
		JD jd1 = new JD("Phát triển và bảo trì website", 8, "TP.HCM" );
		JD jd2 = new JD("Kĩ sư AI", 8, "TP.HCM" );
		JD jd3 = new JD("Phát triển game", 8, "TP.HCM" );
		ArrayList<String> decrise1 = new ArrayList<>();
		decrise1.add("Bảo hiểm sức khỏe FPT Care");
		decrise1.add("Thưởng tháng 13");
		ArrayList<String> decrise2 = new ArrayList<>();
		decrise2.add("Bảo hiểm 24/7 BKAV");
		decrise2.add("Phụ cấp ăn trưa");
		ArrayList<String> decrise3 = new ArrayList<>();
		decrise3.add("Thưởng dự án Game VNG");
		decrise3.add("Du lịch hàng năm");
		Benefit be1 = new Benefit(decrise1, 1500, 2500);
		Benefit be2 = new Benefit(decrise2, 1200, 2000);
		Benefit be3 = new Benefit(decrise3, 1800, 3500);
		Date deadline1 = new Date(30, 12, 2026);
		Position p1 = new Position("kĩ sư phần mềm", 5, req, jd1, be1, deadline1);
		Position p2 = new Position("kĩ sư phần mềm", 5, req2, jd2, be2, deadline1);
		Position p3 = new Position("kiểm thử viên phần mềm", 2, req3, jd3, be3, deadline1);
		Candidate candi1 = new Candidate("Lê Hoàng Thái Sơn", "Nam", birth1, "Good", "Normal", 3, p1);
		Candidate candi2 = new Candidate("Đặng Hoài Nhơn", "Nam", birth2, "Good", "Good looking", 4, p2);
		Date birthR1 = new Date(10, 1, 2007);
		Date birthR2 = new Date(4, 3, 2007);
		ArrayList<Position> assignedPositions = new ArrayList<>();
		assignedPositions.add(p1); 
		Recruiter r = new Recruiter(501, assignedPositions, "Nguyễn Văn A", "Nam", birthR1);	
		// Test  addPostion
		r.addPostion(p3);
		assertEquals(2, r.getAssignedHiringPositions().size());
		// Test  checkCandidate 
		r.checkCandidate(candi1); 		
		// Test approvedCandidates 
		assertTrue(r.getApprovedCandidates().size() >= 0);
		System.out.println("=== RECRUITER  ===");
		System.out.println(" + Tên Recruiter: " + r.getName());
		System.out.println(" + Số lượng vị trí phụ trách: " + r.getAssignedHiringPositions().size());
		System.out.println(" + Số ứng viên đã duyệt (Approved): " + r.getApprovedCandidates().size());		
	}
	
	@Test
	//HR_departmentTest_Đặng Hoài Nhơn 2511130192
	void testingHR_department() {
		Date start1 = new Date(10, 7, 2026);
		Date end1 = new Date(20, 7, 2026);
		Date start2 = new Date(1, 8, 2026);
		Date end2 = new Date(15, 8, 2026);
		Requirement req = new Requirement(new ArrayList<>(), 2, 35, "good looking");
		Requirement req2 = new Requirement(new ArrayList<>(), 1, 32, "normal");
		Requirement req3 = new Requirement(new ArrayList<>(), 5, 35, "normal");
		JD jd1 = new JD("Phát triển và bảo trì website", 8, "TP.HCM" );
		JD jd2 = new JD("Kĩ sư AI", 8, "TP.HCM" );
		JD jd3 = new JD("Phát triển game", 8, "TP.HCM" );
		ArrayList<String> decrise1 = new ArrayList<>();
		decrise1.add("Bảo hiểm sức khỏe FPT Care");
		decrise1.add("Thưởng tháng 13");
		ArrayList<String> decrise2 = new ArrayList<>();
		decrise2.add("Bảo hiểm 24/7 BKAV");
		decrise2.add("Phụ cấp ăn trưa");
		ArrayList<String> decrise3 = new ArrayList<>();
		decrise3.add("Thưởng dự án Game VNG");
		decrise3.add("Du lịch hàng năm");
		Benefit be1 = new Benefit(decrise1, 1500, 2500);
		Benefit be2 = new Benefit(decrise2, 1200, 2000);
		Benefit be3 = new Benefit(decrise3, 1800, 3500);
		Date deadline1 = new Date(30, 12, 2026);
		Position p1 = new Position("kĩ sư phần mềm", 5, req, jd1, be1, deadline1);
		Position p2 = new Position("kĩ sư phần mềm", 5, req2, jd2, be2, deadline1);
		Position p3 = new Position("kiểm thử viên phần mềm", 2, req3, jd3, be3, deadline1);
		ArrayList<Position> pos1 = new ArrayList<>();
		pos1.add(p1);
		pos1.add(p2);
		ArrayList<Position> pos2 = new ArrayList<>();
		pos2.add(p3);
		Recruitment r1 = new Recruitment(pos1, start1, end1);
		Recruitment r2 = new Recruitment(pos2, start2, end2);
		Date birthR1 = new Date(10, 1, 2007);
		ArrayList<Position> assignedPositions = new ArrayList<>();
		assignedPositions.add(p1); 
		Recruiter r = new Recruiter(501, assignedPositions, "Nguyễn Văn A", "Nam", birthR1);	
		Company company = null; 
		ArrayList<Recruiter> staffs = new ArrayList<>();
		staffs.add(r); 
		HR_department hr = new HR_department(company, staffs);
		assertNotNull(hr.getManager());
		assertEquals(1, hr.getStaffs().size());
		// Test takeTask 
		hr.takeTask(r1);
		//Test  getNewEmployees and updateNewEmployees
		ArrayList<NewEmployee> newEmp = hr.getNewEmployees();
		assertNotNull(newEmp);
		Recruitment updatedRecruitment = hr.updateNewEmployees();
		assertNotNull(updatedRecruitment);
		System.out.println("=== HR DEPARTMENT == ");
		System.out.println(" + Số lượng nhân viên HR: " + hr.getStaffs().size());
		System.out.println(" + Trưởng phòng (Manager): " + hr.getManager().getName());
		System.out.println(" + Số lượng nhân viên mới được cập nhật từ HR: " + newEmp.size());
	}
	
		@Test
		//company_Lê Hoàng Thái Sơn 2511130204
		void testingCompany() {
			Date start1 = new Date(10, 7, 2026);
			Date end1 = new Date(20, 7, 2026);
			Date start2 = new Date(1, 8, 2026);
			Date end2 = new Date(15, 8, 2026);
			Requirement req1 = new Requirement(new ArrayList<>(), 2, 35, "normal");
			Requirement req2 = new Requirement(new ArrayList<>(), 5, 35, "normal");
			JD jd = new JD("Phát triển và bảo trì website", 8, "TP.HCM");
			Benefit be = new Benefit(new ArrayList<>(), 1500, 2500);
			Position p1 = new Position("kĩ sư phần mềm", 5, req1, jd, be, new Date(30, 12, 2026));
			Position p2 = new Position("kiểm thử viên phần mềm", 2, req2, jd, be, new Date(30, 12, 2026));
			ArrayList<Position> pos1 = new ArrayList<>();
			pos1.add(p1);
			ArrayList<Position> pos2 = new ArrayList<>();
			pos2.add(p2);
			Recruitment r1 = new Recruitment(pos1, start1, end1);
			Recruitment r2 = new Recruitment(pos2, start2, end2);
			Recruiter hrStaff = new Recruiter(501, new ArrayList<>(), "Nguyễn Văn A", "Nam", new Date(10, 1, 1990));
			ArrayList<Recruiter> staffs = new ArrayList<>();
			staffs.add(hrStaff);
			HR_department hr = new HR_department(null, staffs);
			PriorityQueue<Recruitment> recruimentPlans = new PriorityQueue<>();
			recruimentPlans.add(r2);
			recruimentPlans.add(r1);
			Date d1 = new Date(12, 7, 2026);
			Date d2 = new Date(10, 7, 2026);
			Date d3 = new Date(11, 7, 2026);
			Company tapDoan = new JoinVentureCp("0100000000", "Tập đoàn FPT", "Công nghệ thông tin",
					d1, new PriorityQueue<>(), hr, new ArrayList<>());
			Company c1 = new SubsidiaryCp("0101234567", "Công ty Giải pháp Phần mềm FPT", "Lập trình Web & Mobile", d1, recruimentPlans, hr, tapDoan);
			Company c2 = new SubsidiaryCp("0107654321", "Công ty Trí tuệ Nhân tạo BKAV", "Lập trình AI & An ninh mạng", d2, recruimentPlans, hr, tapDoan);
			Company c3 = new SubsidiaryCp("0109998887", "Công ty Phát triển Game VNG", "Lập trình Game", d3, recruimentPlans, hr, tapDoan);
			//Test PriorityQueue
			assertSame(r1, c1.getRecruimentPlans().peek());
			//Test setTaskForHR(Date) - ngày không khớp
			c1.setTaskForHR(new Date(5, 7, 2026));
			assertEquals(2, recruimentPlans.size());
			assertEquals(0, hrStaff.getAssignedHiringPositions().size());
			//Test setTaskForHR(Date) - ngày khớp
			c1.setTaskForHR(new Date(10, 7, 2026));
			assertEquals(1, recruimentPlans.size());
			assertSame(r2, recruimentPlans.peek());
			assertEquals(1, hrStaff.getAssignedHiringPositions().size());
			//Test setTaskForHR()
			c1.setTaskForHR();
			assertTrue(recruimentPlans.isEmpty());
			assertEquals(2, hrStaff.getAssignedHiringPositions().size());
			System.out.println("=== COMPANY1 ===");
			System.out.println(" + Mã số thuế: " + c1.getTaxCode());
			System.out.println(" + Tên công ty: " + c1.getName());
			System.out.println(" + Lĩnh vực: " + c1.getField());
			System.out.println(" + Ngày thành lập: " + c1.getFoundingDate());
			System.out.println(" + Số đợt tuyển dụng còn lại: " + c1.getRecruimentPlans().size());
			System.out.println(" + Số vị trí HR đã nhận: " + hrStaff.getAssignedHiringPositions().size());
			System.out.println("=== COMPANY2 ===");
			System.out.println(" + Mã số thuế: " + c2.getTaxCode());
			System.out.println(" + Tên công ty: " + c2.getName());
			System.out.println(" + Lĩnh vực: " + c2.getField());
			System.out.println(" + Ngày thành lập: " + c2.getFoundingDate());
			System.out.println(" + Số đợt tuyển dụng còn lại: " + c2.getRecruimentPlans().size());
			System.out.println(" + Số vị trí HR đã nhận: " + hrStaff.getAssignedHiringPositions().size());
			System.out.println("=== COMPANY3 ===");
			System.out.println(" + Mã số thuế: " + c3.getTaxCode());
			System.out.println(" + Tên công ty: " + c3.getName());
			System.out.println(" + Lĩnh vực: " + c3.getField());
			System.out.println(" + Ngày thành lập: " + c3.getFoundingDate());
			System.out.println(" + Số đợt tuyển dụng còn lại: " + c3.getRecruimentPlans().size());
			System.out.println(" + Số vị trí HR đã nhận: " + hrStaff.getAssignedHiringPositions().size());
		}

			@Test
			//SubsidiaryCp_Lê Hoàng Thái Sơn 2511130204
			void testingSubsidiaryCp() {
					Date d1 = new Date(12, 7, 2026);
					Requirement req = new Requirement(new ArrayList<>(), 2, 35, "normal");
					JD jd = new JD("Phát triển và bảo trì website", 8, "TP.HCM");
					Benefit be = new Benefit(new ArrayList<>(), 1500, 2500);
					Position p1 = new Position("kĩ sư phần mềm", 5, req, jd, be, new Date(30, 12, 2026));
					Recruiter staff = new Recruiter(501, new ArrayList<>(), "Nguyễn Văn A", "Nam", new Date(10, 1, 1990));
					staff.getNewEmployees().add(new NewEmployee(100, p1, "Lê Hoàng Thái Sơn", "Nam", new Date(10, 1, 2007)));
					staff.getNewEmployees().add(new NewEmployee(101, p1, "Đặng Hoài Nhơn", "Nam", new Date(4, 3, 2007)));
					ArrayList<Recruiter> staffs = new ArrayList<>();
					staffs.add(staff);
					HR_department hr = new HR_department(null, staffs);
					Company parent1 = new JoinVentureCp("0100000000", "Tập đoàn FPT", "Công nghệ thông tin",
					d1, new PriorityQueue<>(), hr, new ArrayList<>());
					Company parent2 = new JoinVentureCp("0100000009", "FPT Holdings", "Công nghệ thông tin",
					d1, new PriorityQueue<>(), hr, new ArrayList<>());
					SubsidiaryCp sub = new SubsidiaryCp("0101234567", "Công ty Giải pháp Phần mềm FPT", "Lập trình Web & Mobile",
					d1, new PriorityQueue<>(), hr, parent1);
					//Test getParentCp
					assertSame(parent1, sub.getParentCp());
					//Test getNewEmployees
					assertNull(sub.getNewEmployees());
					//Test updateNewEmployees
					sub.updateNewEmployees();
					assertEquals(2, sub.getNewEmployees().size());
					assertEquals("Lê Hoàng Thái Sơn", sub.getNewEmployees().get(0).getName());
					//Test setParentCp
					sub.setParentCp(parent2);
					assertSame(parent2, sub.getParentCp());
					System.out.println("=== SUBSIDIARY COMPANY ===");
					System.out.println(" + Công ty con: " + sub.getName());
					System.out.println(" + Công ty mẹ: " + sub.getParentCp().getName());
					System.out.println(" + Số nhân viên mới: " + sub.getNewEmployees().size());
				}

				@Test
				//JoinVentureCp_Đặng Hoài Nhơn 2511130192
				void testingJoinVentureCp() {
					Date d1 = new Date(12, 7, 2026);
					Requirement req = new Requirement(new ArrayList<>(), 2, 35, "normal");
					JD jd = new JD("Phát triển và bảo trì website", 8, "TP.HCM");
					Benefit be = new Benefit(new ArrayList<>(), 1500, 2500);
					Position p1 = new Position("kĩ sư phần mềm", 5, req, jd, be, new Date(30, 12, 2026));
					Recruiter staff = new Recruiter(501, new ArrayList<>(), "Nguyễn Văn A", "Nam", new Date(10, 1, 1990));
					staff.getNewEmployees().add(new NewEmployee(100, p1, "Lê Hoàng Thái Sơn", "Nam", new Date(10, 1, 2007)));
					ArrayList<Recruiter> staffs = new ArrayList<>();
					staffs.add(staff);
					HR_department hr = new HR_department(null, staffs);
					Company fpt = new JoinVentureCp("0101234567", "Công ty Giải pháp Phần mềm FPT", "Lập trình Web & Mobile",
					d1, new PriorityQueue<>(), hr, new ArrayList<>());
					Company bkav = new JoinVentureCp("0107654321", "Công ty Trí tuệ Nhân tạo BKAV", "Lập trình AI & An ninh mạng",
					d1, new PriorityQueue<>(), hr, new ArrayList<>());
					Company vng = new JoinVentureCp("0109998887", "Công ty Phát triển Game VNG", "Lập trình Game",
					d1, new PriorityQueue<>(), hr, new ArrayList<>());
					ArrayList<Company> partners = new ArrayList<>();
					partners.add(fpt);
					partners.add(bkav);
					JoinVentureCp j = new JoinVentureCp("0109990000", "Liên doanh FPT - BKAV", "Lập trình AI",
					d1, new PriorityQueue<>(), hr, partners);
					JoinVentureCp jv = new JoinVentureCp("0100000001", "Công ty Liên doanh Công nghệ", "Phần mềm & AI",
					d1, new PriorityQueue<>(), hr, partners);
					//Test constructor
					assertEquals(2, j.getPartners().size());
					partners.add(vng);
					assertEquals(2, j.getPartners().size());
					assertEquals(2, jv.getPartners().size());
					//Test addCompany
					j.addCompany(vng);
					assertEquals(3, j.getPartners().size());
					j.addCompany(vng);
					assertEquals(3, j.getPartners().size());
					//Test updateNewEmployees
					assertNull(j.getNewEmployees());
					j.updateNewEmployees();
					assertEquals(1, j.getNewEmployees().size());
					System.out.println("=== JOIN VENTURE COMPANY ===");
					System.out.println(" + Công ty liên doanh: " + j.getName());
					for (Company c : j.getPartners()) {
					System.out.println(" + Đối tác: " + c.getName());
					}
					System.out.println(" + Số nhân viên mới: " + j.getNewEmployees().size());
				}

				@Test
				//AssociateCp_Lê Hoàng Thái Sơn 2511130204
				void testingAssociateCp() {
					Date d1 = new Date(12, 7, 2026);
					Requirement req = new Requirement(new ArrayList<>(), 2, 35, "normal");
					JD j = new JD("Phát triển và bảo trì website", 8, "TP.HCM");
					Benefit be = new Benefit(new ArrayList<>(), 1500, 2500);
					Position p1 = new Position("kĩ sư phần mềm", 5, req, j, be, new Date(30, 12, 2026));
					Recruiter staff = new Recruiter(501, new ArrayList<>(), "Nguyễn Văn A", "Nam", new Date(10, 1, 1990));
					staff.getNewEmployees().add(new NewEmployee(100, p1, "Lê Hoàng Thái Sơn", "Nam", new Date(10, 1, 2007)));
					staff.getNewEmployees().add(new NewEmployee(101, p1, "Đặng Hoài Nhơn", "Nam", new Date(4, 3, 2007)));
					ArrayList<Recruiter> staffs = new ArrayList<>();
					staffs.add(staff);
					HR_department hr = new HR_department(null, staffs);
					AssociateCp as = new AssociateCp("0101234567", "Công ty Giải pháp Phần mềm FPT", "Lập trình Web & Mobile",
					d1, new PriorityQueue<>(), hr, 40, new TreeMap<>());
					//Test parentShares
					assertEquals(40, as.getParentShares());
					as.setParentShares(65);
					assertEquals(65, as.getParentShares());
					//Test partnerShares
					assertNotNull(as.getPartnerShares());
					assertTrue(as.getPartnerShares().isEmpty());
					//Test constructor
					TreeMap<Company, Double> src = new TreeMap<>();
					AssociateCp as2 = new AssociateCp("0100000002", "Công ty liên kết 2", "IT",
					d1, new PriorityQueue<>(), hr, 0.2, src);
					assertNotSame(src, as2.getPartnerShares());
					TreeMap<Company, Double> shares = new TreeMap<>();
					Company fpt = new JoinVentureCp("0101234567", "Công ty Giải pháp Phần mềm FPT", "Lập trình Web & Mobile",
					d1, new PriorityQueue<>(), hr, new ArrayList<>());
					assertThrows(ClassCastException.class, () -> shares.put(fpt, 0.5));
					//Test updateNewEmployees
					assertNull(as.getNewEmployees());
					as.updateNewEmployees();
					assertEquals(2, as.getNewEmployees().size());
					System.out.println("=== ASSOCIATE COMPANY ===");
					System.out.println(" + Công ty liên kết: " + as.getName());
					System.out.println(" + Tỷ lệ cổ phần công ty mẹ: " + as.getParentShares());
					System.out.println(" + Số nhân viên mới: " + as.getNewEmployees().size());
				}

				@Test
				//Corporation_Đặng Hoài Nhơn 2511130192
				void testingCorporation() {
					Date d1 = new Date(12, 7, 2026);
					Requirement req = new Requirement(new ArrayList<>(), 2, 35, "normal");
					JD jd = new JD("Phát triển và bảo trì website", 8, "TP.HCM");
					Benefit be = new Benefit(new ArrayList<>(), 1500, 2500);
					Position p1 = new Position("kĩ sư phần mềm", 5, req, jd, be, new Date(30, 12, 2026));
					Recruiter staffFpt = new Recruiter(501, new ArrayList<>(), "Nguyễn Văn A", "Nam", new Date(10, 1, 1990));
					staffFpt.getNewEmployees().add(new NewEmployee(100, p1, "Lê Hoàng Thái Sơn", "Nam", new Date(10, 1, 2007)));
					staffFpt.getNewEmployees().add(new NewEmployee(101, p1, "Đặng Hoài Nhơn", "Nam", new Date(4, 3, 2007)));
					ArrayList<Recruiter> staffsFpt = new ArrayList<>();
					staffsFpt.add(staffFpt);
					HR_department hrFpt = new HR_department(null, staffsFpt);
					Recruiter staffBkav = new Recruiter(502, new ArrayList<>(), "Trần Thị B", "Nữ", new Date(5, 5, 1992));
					staffBkav.getNewEmployees().add(new NewEmployee(102, p1, "Lê Hoàng Thái Sơn", "Nam", new Date(10, 1, 2007)));
					ArrayList<Recruiter> staffsBkav = new ArrayList<>();
					staffsBkav.add(staffBkav);
					HR_department hrBkav = new HR_department(null, staffsBkav);
					Recruiter staffVng = new Recruiter(503, new ArrayList<>(), "Lê Văn C", "Nam", new Date(7, 7, 1991));
					ArrayList<Recruiter> staffsVng = new ArrayList<>();
					staffsVng.add(staffVng);
					HR_department hrVng = new HR_department(null, staffsVng);
					Corporation corp = new Corporation("CORP01", "Tập đoàn Công nghệ Phần mềm ");
					//Test constructor + getters
					assertEquals("CORP01", corp.getId());
					assertEquals("Tập đoàn Công nghệ Phần mềm ", corp.getName());
					assertTrue(corp.getMemberCompanies().isEmpty());
					assertNull(corp.getNewEmployeeList());
					//Test updateNewEmployees
					corp.updateNewEmployees();
					assertNotNull(corp.getNewEmployeeList());
					assertTrue(corp.getNewEmployeeList().isEmpty());
					//Test updateNewEmployees
					Corporation corp2 = new Corporation("TD02", "Tập đoàn FPT - BKAV - VNG");
					Company fpt = new JoinVentureCp("0101234567", "Công ty Giải pháp Phần mềm FPT", "Lập trình Web & Mobile",d1, new PriorityQueue<>(), hrFpt, new ArrayList<>());
					Company bkav = new JoinVentureCp("0107654321", "Công ty Trí tuệ Nhân tạo BKAV", "Lập trình AI & An ninh mạng",d1, new PriorityQueue<>(), hrBkav, new ArrayList<>());
					Company vng = new JoinVentureCp("0109998887", "Công ty Phát triển Game VNG", "Lập trình Game",d1, new PriorityQueue<>(), hrVng, new ArrayList<>());
					fpt.updateNewEmployees();
					bkav.updateNewEmployees();
					vng.updateNewEmployees();
					corp2.getMemberCompanies().add(fpt);
					corp2.getMemberCompanies().add(bkav);
					corp2.getMemberCompanies().add(vng);
					corp2.updateNewEmployees();
					assertEquals(3, corp2.getNewEmployeeList().size());
					System.out.println("=== CORPORATION ===");
					System.out.println(" + Mã tập đoàn: " + corp2.getId());
					System.out.println(" + Tên tập đoàn: " + corp2.getName());
					System.out.println(" + Số công ty thành viên: " + corp2.getMemberCompanies().size());
					System.out.println(" + Tổng số nhân viên mới: " + corp2.getNewEmployeeList().size());
				}
			}
			 