import dao.BookDao;
import dao.FlightDao;

public class TesterRunner {
    public static void main(String[] args) {
        FlightDao instance = FlightDao.getInstance();
        BookDao bookDao = BookDao.getInstance();

        System.out.println();
    }
}
