package Other;

public class Person {
	 public String name;
	    public String gender;
	    public Date birth;

	    public Person(String name, String gender, Date birth) {
	        this.name = name;
	        this.gender = gender;
	        this.birth = birth;
	    }

	    public String getName() {return name;}
	    public void setName(String name) {this.name = name;}
	    public String getGender() {return gender;}
	    public void setGender(String gender) {this.gender = gender;}
	    public Date getBirth() {return birth;}
	    public void setBirth(Date birth) {this.birth = birth;}

	    
	    //Nhon
	    public int getAge() {
	    	return birth.getAge();
	    }


}
