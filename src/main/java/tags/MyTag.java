package tags;

import Models.Film;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.ArrayList;


public class MyTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {

        ArrayList<Film> films = (ArrayList<Film>) pageContext.getAttribute("filmList", PageContext.REQUEST_SCOPE);

        String result = "<table class=\"page-table\" " +
                "border=\"1\" cellpadding=\"5\" cellspacing=\"1\" style=\"border-collapse: collapse\">" +
                "<tr><th>ID</th><th>Film</th></tr>";
        for (Film film: films) {
            result +=  "<tr><td>" + film.getID() + "</td><td>" + film.getTitle() + "</td></tr>";
        }
        result += "</table>";

        try {
            JspWriter out = pageContext.getOut();
            out.write(result);
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }

}
