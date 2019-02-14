package es.indra.curso.springmicro.springbootdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloController {
    protected final Log logger = LogFactory.getLog(getClass());
    @RequestMapping(value="/api/hello")
    @ResponseBody
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setStatus(200);
        //response.setContentType(HttpServletResponse.);
        logger.info("devolviendo hola mundo");
        return "<h1>hola mundo</h1>";
    }
}