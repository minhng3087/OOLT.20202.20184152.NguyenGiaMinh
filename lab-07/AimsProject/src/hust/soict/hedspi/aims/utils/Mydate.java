package hust.soict.hedspi.aims.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Mydate {
    private int day;
    private int month;
    private int year;

    static String[][] dayStr = {
            {"first", "1"}, {"second", "2"}, {"third", "3"}, {"fourth", "4"}, {"fifth", "5"},
            {"sixth", "6"}, {"seventh", "7"}, {"eighth", "8"}, {"ninth", "9"}, {"tenth", "10"},
            {"eleventh", "11"}, {"twelfth", "12"}, {"thirteenth", "13"}, {"fouterteenth", "14"},
            {"fifteenth", "15"}, {"sixteenth", "16"}, {"seventeeth", "17"}, {"eighteenth", "18"},
            {"nineteenth", "19"},{"twentieth", "20"}, {"twenty-first", "21"},{"twenty-second", "22"},
            {"twenty-third", "23"}, {"twenty-fourth", "24"}, {"twenty-fifth", "25"}, {"twenty-sixth", "26"},
            {"twenty-seventh", "27"}, {"twenty-eighth", "28"}, {"twenty-ninth", "29"},{"thirtieth", "30"},{"thirty-first", "31"},
    };

    static String[] monthStr = {
            "January", "February", "March", "April", "May", "June","July", "August", "September","October", "November", "December"
    };

    static String[] yearStr = {
            "nineteen ninety one", "nineteen ninety two", "nineteen ninety three", "nineteen ninety four",
            "nineteen ninety five", "nineteen ninety six", "nineteen ninety seven", "nineteen ninety eight", "nineteen ninety nine",
            "two thousand", "two thousand and one", "two thousand and two", "two thousand and three", "two thousand and four",
            "two thousand and five", "two thousand and six", "two thousand and seven", "two thousand and eight", "two thousand and nine",
            "two thousand and ten", "twenty eleven", "twenty twelse", "twenty thirteen", "twenty fourteen", "twenty fifteen",
            "twenty sixteen", "twenty seventeen", "twenty eighteen", "twenty nineteen", "twenty twenty", "twenty twenty one",
    };

    /**********************************/
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
        String[] part = date.split("/");
        this.day = Integer.parseInt(part[0]);
        this.month = Integer.parseInt(part[1]);
        this.year = Integer.parseInt(part[2]);

    }

    public Mydate(String day, String month, String year) {
        convertDay(day);
        convertMonth(month);
        convertYear(year);
    }

    /**********************************/

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

    /******************************************/
    private void convertDay(String day) {
        for(int i = 0; i < 31 ; i++) {
            if(day.equalsIgnoreCase(dayStr[i][0])) {
                this.day = Integer.parseInt(dayStr[i][1]);
            }
        }
    }

    private void convertMonth(String month) {
        for(int i=0; i< monthStr.length; i++) {
            if(month.equalsIgnoreCase(monthStr[i])) {
                this.month = i+1;
            }
        }
    }

    private void convertYear(String year) {
        for(int i = 0; i < 22; i++) {
            if(year.equalsIgnoreCase(yearStr[i]))
                this.year = i + 1991;
        }
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
            return this.year % 4 == 0;
        }else {
            return (this.year % 4 == 0 && this.year % 100 != 0)
                    || this.year % 400 == 0;
        }
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
        System.out.println("Enter a date (Eg: February 18 2019): ");
        String date = input.nextLine();
        Mydate test = new Mydate(date);
        System.out.println(test.getMonth() + " " + test.getDay() + " " + test.getYear());

        input.close();
    }

    public void printCurrentDate() {
        Mydate date = new Mydate();
        String month = switch (date.getMonth()) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "";
        };

        if(date.getDay() == 1 || date.getDay() == 21 || date.getDay() == 31)
            System.out.println("Today is: " + month + " " + date.day + "st " + date.year);
        else if(date.getDay() == 2 || date.getDay() == 22)
            System.out.println("Today is " + month + " " + date.day + "nd " + date.year);
        else if(date.getDay() == 3 || date.getDay() == 23)
            System.out.println("Today is: " + month + " " + date.day + "rd " + date.year);
        else
            System.out.println("Today is: " + month + " " + date.day + "th " + date.year);
    }
    public void print() {
        if(this.validate().equals("Not error")){
            System.out.println(this.day + "/" + this.month + "/" + this.year);
        }
        else {
            System.out.println(this.validate());
        }
    }

    public void printFormat() {
        Calendar fDate = Calendar.getInstance();
        String dateFormat;
        int choose;
        Scanner input = new Scanner(System.in);

        System.out.println("Select choose:  ");
        System.out.println("1. yyyy-MM-dd");
        System.out.println("2. d/M/yyyy");
        System.out.println("3. dd-MMM-yyyy");
        System.out.println("4. MMM d yyyy");
        System.out.println("5. mm-dd-yyyy");
        choose = input.nextInt();
        dateFormat = switch (choose) {
            case 1 -> "yyyy-MM-dd";
            case 2 -> "d/M/yyyy";
            case 3 -> "dd-MMM-yyyy";
            case 4 -> "MMM d yyyy";
            case 5 -> "mm-dd-yyyy";
            default -> "MMMMM dd yyyy";
        };

        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        System.out.println(formatter.format(fDate.getTime()));
        input.close();

    }
}
