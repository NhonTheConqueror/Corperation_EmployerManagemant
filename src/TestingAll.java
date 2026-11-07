import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Main.*;
import Other.*;

class TestingAll {
	
	//testing all the class's methods and constructors;
	
	@Test
	//test benefit class: Lê Hoàng Thái Sơn 2511130204
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
        Benefit bn1 = new Benefit(decrise1, 1500, 2500);
        Benefit bn2 = new Benefit(decrise2, 1200, 2000);
        Benefit bn3 = new Benefit(decrise3, 1800, 3500);
        bn1.addDescribe("Hỗ trợ mua laptop");
        bn2.addDescribe("Gửi xe miễn phí");
        bn3.addDescribe("Hỗ trợ tiền xăng");
        System.out.println("=== TEST GÓI PHÚC LỢI 1 ===");
        System.out.println("Mức lương: " + bn1.getMin_wage() + " - " + bn1.getMax_wage() + " VNĐ");
        System.out.println("Danh sách đãi ngộ:");
        for (String moTa : bn1.getDescribe()) {
            System.out.println(" + " + moTa);
        }
	}
	
	@Test
	void testingSkill() {
		Skill skill1 = new Skill("Java", 4);
		Skill skill2 = new Skill("Python", 3);
		Skill skill3 = new Skill("C++", 5);
		System.out.println("=== TEST KỸ NĂNG ===");
		System.out.println("Kỹ năng: " + skill1.title + ", Mức độ: " + skill1.title);
		System.out.println("Kỹ năng: " + skill2.title + ", Mức độ: " + skill2.title);
		System.out.println("Kỹ năng: " + skill3.title + ", Mức độ: " + skill3.title);
	}
}
