public class TestDateUtils {
    
    
    public static void main(String[] args) {
        int check = DateUtils.compareDate("31/03/2020", "01/04/2020");
        switch (check) {
            case -1 -> System.out.println("Ngay 1 < 2");
            case 1 -> System.out.println("Ngay 1 > 2");
            case 0 -> System.out.println("2 ngay = ");
        }

        String[] date = {"03/05/2020", "31/12/2014", "01/01/2013"};
        DateUtils.sortingDate(date);
        DateUtils.printDate(date);
    }
}
