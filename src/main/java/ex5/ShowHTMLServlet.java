package ex5;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;



@WebServlet("/showHTML")
public class ShowHTMLServlet extends HttpServlet {

    private final static Logger logger = Logger.getLogger(ShowHTMLServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private HtmlContent htmlContent;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "ShowHTML.ftlh");
        Map<String, Object> model = new HashMap<>();

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            PrintWriter out = resp.getWriter();
            URL url = new URL(req.getParameter("url"));
            WebClient webClient = new WebClient();
            String urlString = url.toString();
            HtmlPage page = webClient.getPage(urlString);
            WebResponse response = page.getWebResponse();
            String content = response.getContentAsString();
            out.write(content);
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }


//
//        getHtmlSourceCode(url);
//
//    }
//
//    private void getHtml (URL url){
//
//        htmlContent.getHtmlSourceCode(url);
//
//    }
//
//    void getHtmlSourceCode (URL u) {


    }

}