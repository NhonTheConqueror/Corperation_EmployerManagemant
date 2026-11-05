package Main;
import Other.*;
import java.util.ArrayList;

public class Benefit {
    public ArrayList<String> describe;
    public double Min_wage;
    public double Max_wage;
    public Benefit() {
        this.describe = new ArrayList<>();
    }

    public Benefit(double Min_wage, double Max_wage) {
        this.describe = new ArrayList<>();
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


}
