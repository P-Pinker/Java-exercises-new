package ex5;

import javax.swing.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HtmlContent extends JFrame {

    private final static Logger logger = Logger.getLogger(ShowHTMLServlet.class.getName());

//    public void showHtml() {
//
//        new HtmlContent().start();
//
//    }

    void start(URL u) {

        try {
            URL url = new URL(u.toString());
            JEditorPane ed = new JEditorPane(url);
            add(ed);
            setVisible(true);
            setSize(600,600);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }

    }
}
