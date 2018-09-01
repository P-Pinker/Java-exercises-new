package ex6;

import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetMethodsAndSize {

    private final static Logger logger = Logger.getLogger(GetMethodsAndSize.class.getName());

    private Scanner scanner = new Scanner(System.in);

    private URL url = null;

    private void getUrl() {

        while (url == null) {
            try {
                url = new URL(scanner.next());
            } catch (Exception e) {
                System.out.println("Niepoprawny adres. Spróbuj jeszcze raz");
                logger.log(Level.INFO, e.getMessage());
            }
        }
    }

    

    public static void main(String[] args) {

//        getUrl();

    }



}
