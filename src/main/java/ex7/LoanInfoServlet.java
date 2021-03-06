package ex7;

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
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/loanSimulator")
public class LoanInfoServlet extends HttpServlet {

    private final static Logger logger = Logger.getLogger(LoanInfoServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private LoanDao loanDao;

    @Inject
    private LoanMonthlyDao loanMonthlyDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        Template template = templateProvider.getTemplate(getServletContext(), "LoanSimulator.ftlh");
        Map<String, Object> model = new HashMap<>();

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        Template template = templateProvider.getTemplate(getServletContext(), "LoanSimulator.ftlh");
        Map<String, Object> model = new HashMap<>();

        double APR = loanDao.getAnnualPercentageRate(parseToDouble(req.getParameter("profit")));
        model.put("APR", APR);

        double totalCostOfCredit = loanDao.getTotalCostOfCredit(
                parseToBigDecimal(req.getParameter("loan")),
                parseToDouble(req.getParameter("profit")),
                parseToDouble(req.getParameter("markup")));
        model.put("totalCostOfCredit", totalCostOfCredit);

        List<LoanMonthly> loanParams = loanMonthlyDao.getLoanMonthlyParams(
            parseToBigDecimal(req.getParameter("loan")),
            parseToDouble(req.getParameter("profit")),
            parseToInteger(req.getParameter("months"))
            );
        model.put("loanParams", loanParams);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

    }

    private int parseToInteger(Object o) {
        return Integer.parseInt(o.toString());
    }

    private Double parseToDouble(Object o) {
        return Double.parseDouble(o.toString());
    }

    private BigDecimal parseToBigDecimal(Object o) {
        return BigDecimal.valueOf(parseToDouble(o));
    }

}