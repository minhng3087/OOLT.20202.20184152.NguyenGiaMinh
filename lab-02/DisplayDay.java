import java.util.Scanner;
public class DisplayDay {

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

        int number_Of_DaysInMonth = 0; 
        String MonthOfName = "Unknown";

        System.out.print("Input a month number: ");
		String month = input.nextLine();
		
		int year;		
		do {
			System.out.println("Input a year: ");
			while (!input.hasNextInt()) {
				System.out.println("That's not a number!");
				input.next();
			}
			year = input.nextInt();
		} while (year <= 0);


		if (month.equals(Integer.toString(1)) || month.equalsIgnoreCase("January") || month.equalsIgnoreCase("Jan") || month.equalsIgnoreCase("Jan.")) 
		{
			number_Of_DaysInMonth = 31;
			MonthOfName = "January";
		}
		else if(month.equals(Integer.toString(2)) || month.equalsIgnoreCase("February") || month.equalsIgnoreCase("Feb") || month.equalsIgnoreCase("Feb."))
		{
			MonthOfName = "February";
			if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
				number_Of_DaysInMonth = 29;
			} else {
					number_Of_DaysInMonth = 28;
				}
		}

		else if (month.equals(Integer.toString(3)) || month.equalsIgnoreCase("March") || month.equalsIgnoreCase("Mar") || month.equalsIgnoreCase("Mar.")) 
		{
			number_Of_DaysInMonth = 31;
			MonthOfName = "March";
		}

		else if (month.equals(Integer.toString(4)) || month.equalsIgnoreCase("April") || month.equalsIgnoreCase("Apr") || month.equalsIgnoreCase("Apr.")) 
		{
			number_Of_DaysInMonth = 30;
			MonthOfName = "April";
		}

		else if (month.equals(Integer.toString(5)) || month.equalsIgnoreCase("May")) 
		{
			number_Of_DaysInMonth = 31;
			MonthOfName = "May";
		}

		else if (month.equals(Integer.toString(6)) || month.equalsIgnoreCase("June") || month.equalsIgnoreCase("Jun")) 
		{
			number_Of_DaysInMonth = 30;
			MonthOfName = "June";
		}

		else if (month.equals(Integer.toString(7)) || month.equalsIgnoreCase("July") || month.equalsIgnoreCase("Jul")) 
		{
			number_Of_DaysInMonth = 31;
			MonthOfName = "July";
		}

		else if (month.equals(Integer.toString(8)) || month.equalsIgnoreCase("August") || month.equalsIgnoreCase("Aug") || month.equalsIgnoreCase("Aug.")) 
		{
			number_Of_DaysInMonth = 31;
			MonthOfName = "August";
		}

		else if (month.equals(Integer.toString(9)) || month.equalsIgnoreCase("September") || month.equalsIgnoreCase("Sept.") || month.equalsIgnoreCase("Sep")) 
		{
			number_Of_DaysInMonth = 30;
			MonthOfName = "September";
		}

		else if (month.equals(Integer.toString(10)) || month.equalsIgnoreCase("October") || month.equalsIgnoreCase("Oct") || month.equalsIgnoreCase("Oct.")) 
		{
			number_Of_DaysInMonth = 31;
			MonthOfName = "October";
		}

		else if (month.equals(Integer.toString(11)) || month.equalsIgnoreCase("November") || month.equalsIgnoreCase("Nov") || month.equalsIgnoreCase("Nov.")) 
		{
			number_Of_DaysInMonth = 30;
			MonthOfName = "November";
		}

		else if (month.equals(Integer.toString(12)) || month.equalsIgnoreCase("December") || month.equalsIgnoreCase("Dec") || month.equalsIgnoreCase("Dec.")) 
		{
			number_Of_DaysInMonth = 31;
			MonthOfName = "December";
		}
		System.out.print(MonthOfName + " " + year + " has " + number_Of_DaysInMonth + " days\n");
		
		input.close();
	}
}
