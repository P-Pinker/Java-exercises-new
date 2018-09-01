package ex6;

import java.net.HttpURLConnection;
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
                System.out.println("Wystąpił błąd. Spróbuj jeszcze raz");
                logger.log(Level.INFO, e.getMessage());
            }
        }
    }

    private boolean checkIfWebsiteExists() {

        boolean websiteExists;

        try {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
//            String responseMessage = connection.getResponseMessage();

            if (responseCode != 200) {
                System.out.println("Wystąpił błąd - strona nie istnieje");
                websiteExists = false;
            } else {
                websiteExists = true;
            }

            return websiteExists;

        } catch (Exception e) {
            System.out.println("Wystąpił błąd");
            logger.log(Level.INFO, e.getMessage());
        }

        return false;

    }


    public static void main(String[] args) {

        GetMethodsAndSize getMethodsAndSize = new GetMethodsAndSize();
        System.out.println("Podaj adres URL, dla którego chcesz poznać dostępne metody i rozmiar zasobu");
        getMethodsAndSize.getUrl();


    }



}
