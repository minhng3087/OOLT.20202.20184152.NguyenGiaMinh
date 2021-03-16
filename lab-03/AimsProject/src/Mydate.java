import java.util.Calendar;
import java.util.Scanner;
public class Mydate {
    private int day;
	private int month;
    private int year;

    public Mydate() {
        Calendar cal = Calendar.getInstance();
        this.day = cal.get(Calendar.DAY_OF_MONTH);
        this.month = cal.get(Calendar.MONTH)+1;
        this.year = cal.get(Calendar.YEAR);
    }

    public Mydate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
 
    public Mydate(String date) {
        String part[] = date.split("/");
        this.day = Integer.parseInt(part[0]);
        this.month = Integer.parseInt(part[1]);;
        this.year = Integer.parseInt(part[2]);
        
    }
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
  
    public int getDaysInMonth() {
     
        switch(this.month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if(isLeapYear()) return 29;
                else return 28;	
            default: 
                return -1;
        }
    }
    
    public boolean isLeapYear() {
        if(this.year <= 1752) {
            if(this.year % 4 == 0) return true;
        }else {
            if((this.year % 4 == 0 && this.year % 100 != 0)
                || this.year % 400 == 0) {
                return true;
            }
        }
        return false;
    }
    

    public String validate() {    
        if(this.year <= 0) {
            return "Invalid year";
        }else if (this.month < 1 || this.month > 12) {
            return "Invalid month";
        }else if (this.day < 1 || this.day > 31) {
            return "Invalid day";
        }else if (this.day > this.getDaysInMonth()) {
            return "Month " + this.month + " don't have " + this.day + " days";
        }else
            return "Not error";
            
    }

    public void accept() {
		Scanner input = new Scanner(System.in);
        System.out.println("Enter dd/mm/yyyy");
        String date = input.nextLine();
        String part[] = date.split("/");
        this.day = Integer.parseInt(part[0]);
        this.month = Integer.parseInt(part[1]);;
        this.year = Integer.parseInt(part[2]);
        input.close();
    }

    public void print() {
        if(this.validate().equals("Not error")){
            System.out.println(this.day + "/" + this.month + "/" + this.year);
        }
        else {
            System.out.println(this.validate());
        }
    }
}

   
