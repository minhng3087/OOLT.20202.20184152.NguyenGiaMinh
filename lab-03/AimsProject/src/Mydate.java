import java.util.Scanner;
public class Mydate {
    private int day;
	private int month;
    private int year;

    public Mydate() {
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }

    public Mydate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Mydate(Mydate d) {
        this.day = d.day;
        this.month = d.month;
        this.year = d.year;
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
        if(this.month == 1) {
        return 31;
        }else if(this.month == 2) {
            if(isLeapYear()) return 29;
            else return 28;		
        }else if(this.month == 3) {
            return 31;
        }else if(this.month == 4) {
            return 30;
        }else if(this.month == 5) {
            return 31;
        }else if(this.month == 6) {
            return 30;
        }else if(this.month == 7) {
            return 31;
        }else if(this.month == 8) {
            return 31;
        }else if(this.month == 9) {
            return 30;
        }else if(this.month == 10) {
            return 31;
        }else if(this.month == 11) {
            return 30;
        }else if(this.month == 12) {
            return 31;
        }
        return -1;
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

    public boolean validate() {    
        if(this.year <= 0 || (this.month < 1 || this.month > 12) || (this.day< 1 || this.day> 31) || this.day> this.getDaysInMonth()) 
            return true;
        return false;
            
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
        if(this.validate()) {
            System.out.println("Error");
        }
        else {
            System.out.println(this.day + "/" + this.month + "/" + this.year);
        }
    }
    

    

}
