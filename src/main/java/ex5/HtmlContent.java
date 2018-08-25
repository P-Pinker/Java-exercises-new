package ex5;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import javax.swing.*;
import java.io.PrintWriter;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HtmlContent extends JFrame {

    private final static Logger logger = Logger.getLogger(ShowHTMLServlet.class.getName());

//    void getHtmlSourceCode (URL u) {
//
//        try {
//            WebClient webClient = new WebClient();
//            String url = u.toString();
//            HtmlPage page = webClient.getPage(url);
//            WebResponse response = page.getWebResponse();
//            String content = response.getContentAsString();
//        } catch (Exception e) {
//            logger.log(Level.INFO, e.getMessage());
//        }
//
//    }

//     **WORKING WITH J-FRAME**
//    void start(URL u) {
//
//        try {
//            URL url = new URL(u.toString());
//            JEditorPane ed = new JEditorPane(url);
//            add(ed);
//            setVisible(true);
//            setSize(600,600);
//            setDefaultCloseOperation(EXIT_ON_CLOSE);
//        } catch (Exception e) {
//            logger.log(Level.INFO, e.getMessage());
//        }
//
//    }

}
