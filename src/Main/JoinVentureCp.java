package Main;
import java.util.PriorityQueue;

import Other.Date;

import java.util.ArrayList;

public class JoinVentureCp extends Company {
    private ArrayList<Company> partners;

    /*/
     * constructor
     */
    public JoinVentureCp(String taxCode, String name, String field,
                         Date foundingDate, PriorityQueue<Recruitment> recruimentPlans,
                         int totalNewEmployees, HR_department hrDepartment,
                         ArrayList<Company> partners)
    {
        super(taxCode, name, field, foundingDate,recruimentPlans, totalNewEmployees, hrDepartment);
        this.partners = (partners != null)
                        ? new ArrayList<>(partners)
                        : new ArrayList<>();
    }
//____________________________________________________________________

    //default methods
    public ArrayList<Company> getPartners() {return partners;}
    public void setPartners(ArrayList<Company> partners) {this.partners = partners;}


}
