package Main;
import Other.*;
import java.util.ArrayList;

public class Benefit {
    private ArrayList<String> describe;
    private double Min_wage;
    private double Max_wage;
    
    public Benefit() {
        this.describe = new ArrayList<>();
    }

    public Benefit(ArrayList<String> describe, double Min_wage, double Max_wage) {
        this.describe = describe;
        this.Min_wage = Min_wage;
        this.Max_wage = Max_wage;
    }

    public ArrayList<String> getDescribe() {
        return describe;
    }

    public void setDescribe(ArrayList<String> describe) {
        this.describe = describe;
    }

    public double getMin_wage() {
        return Min_wage;
    }

    public void setMin_wage(double Min_wage) {
        this.Min_wage = Min_wage;
    }

    public double getMax_wage() {
        return Max_wage;
    }

    public void setMax_wage(double Max_wage) {
        this.Max_wage = Max_wage;
    }

    //Son
    public void addDescribe(String description) {
		this.describe.add(description);
	}
    
}
