package ex5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/AppExceptionHandler")
public class AppExceptionHandler extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processError(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processError(request, response);
    }

    private void processError(HttpServletRequest request, HttpServletResponse response)
            throws IOException {


        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");

            if (servletName == null) {
                servletName = "Unknown";
            }

        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");

            if (requestUri == null) {
                requestUri = "Unknown";
            }
//
//        if (statusCode == 400){
//            response.sendRedirect("/400");
//        } else if (statusCode == 404) {
//            response.sendRedirect("/404");
//        } else if (statusCode == 500) {
//            response.sendRedirect("/500");
//        } else if (statusCode == 502) {
//            response.sendRedirect("/502");
//        } else if (statusCode == 505) {
//            response.sendRedirect("/505");
//        } else {
//            response.sendRedirect("/error");
//        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.write("<html><head><title>Wystapił błąd.</title></head><body>");
        if (statusCode != 500) {
            out.write("<h3>Szczegóły:</h3>");
            out.write("<strong>Status</strong>:"+statusCode+"<br>");
            out.write("<strong>URI</strong>:"+requestUri);
        }else{
            out.write("<h3>Szczegóły</h3>");
            out.write("<ul><li>Servlet:"+servletName+"</li>");
            out.write("<li>Wyjątek:"+throwable.getClass().getName()+"</li>");
            out.write("<li>URI:"+requestUri+"</li>");
            out.write("<li>Wiadomość:"+throwable.getMessage()+"</li>");
            out.write("</ul>");
        }

//        out.write("<br><br>");
//        out.write("<a href=\"index.html\">Home Page</a>");
        out.write("</body></html>");
    }

}