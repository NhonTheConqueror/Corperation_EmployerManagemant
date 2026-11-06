package Other;

import java.time.LocalDate;

public class Date {
	public int day;
    public int month;
    public int year;
    public Date() {
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {return day;}
    public void setDay(int day) {this.day = day;}
    public int getMonth() {return month;}
    public void setMonth(int month) {this.month = month;}
    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}
    
    //to know this date had before that date; Son
    public int compareWith(Date that) {
    	if(this.year < that.year) return 1;
    	else if(this.year == that.year) {
    		if(this.month < that.month) return 1;
			if(this.month == that.month) {
				if(this.day < that.day) return 1;	
				if(this.day == that.day) return 0;
			}
    	}
    	return -1;
	}

    //Son
    public boolean equalTo(LocalDate that) {
		if(this.year == that.getYear() && this.month == that.getMonthValue() && this.day == that.getDayOfMonth()) return true;
		return false;
	}
    //Son
    public boolean equalTo(Date that) {
    	if(this.year == that.year && this.month == that.month && this.day == that.day) return true;
    	return false;
    }
    
    //Nhon
	public int getAge() {
		return LocalDate.now().getYear() - this.year;
	}



}
