package ex4;

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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@WebServlet("/geocoding")
public class GeocodingServlet extends HttpServlet {

    private final static Logger logger = Logger.getLogger(GeocodingServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "geocoding.ftlh");
        Map<String, Object> model = new HashMap<>();

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String input = String.valueOf(req.getParameterValues("address"));

        String[] params = input.split("\\s+");

        for (int i = 0; i < params.length; i++) {
            params[i] = params[i].replaceAll("[^\\w]", "");
        }

        String data = Arrays.stream(params).collect(Collectors.joining("%2520"));
        resp.sendRedirect("https://google-developers.appspot.com/maps/documentation/utils/geocoder/#q%3D" + data);

    }

}