package ex6;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetMethodsAndSize {

    private final static Logger logger = Logger.getLogger(GetMethodsAndSize.class.getName());

    private Scanner scanner = new Scanner(System.in);

    private URL url = null;

    public static void main(String[] args) {

        GetMethodsAndSize getMethodsAndSize = new GetMethodsAndSize();

        System.out.println("Podaj adres URL, dla którego chcesz poznać dostępne metody i rozmiar zasobu");

        if (getMethodsAndSize.getUrlIfExists()) {
            System.out.println("Content Length: " + getMethodsAndSize.getContentLength());
            System.out.println("Available methods: " + getMethodsAndSize.getHttpMethods());
        } else if (!getMethodsAndSize.getUrlIfExists()) {
            System.out.println("Wystąpił błąd - strona nie istnieje.");
            System.exit(1);
        } else {
            System.out.println("Wystąpił błąd");
        }

    }

    private boolean getUrlIfExists() {

        while (url == null) {
            try {
                url = new URL(scanner.next());
            } catch (Exception e) {
                System.out.println("Wystąpił błąd. Spróbuj jeszcze raz");
                logger.log(Level.INFO, e.getMessage());
            }
        }

        try {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();

            if (responseCode == 404) {
                return false;
            } else {
                return true;
            }

        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }

        return false;

    }

//    private boolean checkIfWebsiteExists() {


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
                Header header = clHeaders[0];
                return Long.parseLong(header.getValue());
            }

        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }

        return (long) -1;

    }


    private String getHttpMethods(){

        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpOptions request = new HttpOptions(String.valueOf(url));
            HttpResponse response = client.execute(request);

            if (response.containsHeader("Allow")){
                return response.getFirstHeader("Allow").getValue();
            } else if (response.containsHeader("Access-Control-Allow-Methods")) {
                return response.getFirstHeader("Access-Control-Allow-Methods").getValue();
            }

        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }

//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("OPTIONS");
//        System.out.println(connection.getHeaderField("Allow"));

        return "Brak danych";

    }

}
