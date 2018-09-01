package ex6;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
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

    private Long getContentLength () {

        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpHead request = new HttpHead(String.valueOf(url));
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new IOException("Nieoczekiwany błąd" + response.getStatusLine().getStatusCode());
            }

            Header[] clHeaders = response.getHeaders("Content-Length");

            if (clHeaders.length > 0) {
                Header header=clHeaders[0];
                return Long.parseLong(header.getValue());
            }

        } catch (Exception e) {
            System.out.println("Wystąpił błąd");
            logger.log(Level.INFO, e.getMessage());
        }

        return (long) -1;

//        try {
//            URLConnection uc = url.openConnection();
//            int contentLength = uc.getContentLength();
//            return String.valueOf(contentLength);
//        } catch (Exception e) {
//            System.out.println("Wystąpił błąd");
//            logger.log(Level.INFO, e.getMessage());
//        }
//
//        return "Brak danych";

    }


    private void getHttpMethods(){

        

    }


    public static void main(String[] args) {

        GetMethodsAndSize getMethodsAndSize = new GetMethodsAndSize();
        System.out.println("Podaj adres URL, dla którego chcesz poznać dostępne metody i rozmiar zasobu");
        getMethodsAndSize.getUrl();

        if (getMethodsAndSize.checkIfWebsiteExists()){
            System.out.println("Content Length: " + getMethodsAndSize.getContentLength());
            System.out.println("Available methods: " + getMethodsAndSize.getHttpMethods());
        } else {
            System.out.println("Coś poszło nie tak.");
        }

    }

}
