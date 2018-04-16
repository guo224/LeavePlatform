package leave.web.leave.web.controller;

import leave.interfaces.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;


/**
 * Created by 白嘿嘿黑 on 2018/3/27.
 */
@Controller
@RequestMapping(value = "")
public class TemplateController {
    private TemplateEngine templateEngine;
    final  private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final IUserService iUserService;
    @Autowired
    public TemplateController(final ServletContext servletContext, IUserService iUserService) {
        super();
        this.iUserService = iUserService;
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix("/template/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(false);
        templateResolver.setCacheTTLMs(3600000L);
        this.templateEngine = new TemplateEngine();
        this.templateEngine.setTemplateResolver(templateResolver);
    }

    @GetMapping(value = "")
    public String getIndex() throws Exception {
        return "login";
    }
    @GetMapping(value = "index")
    public String getIndex(Model model) throws Exception {
        return "index";
    }
    @GetMapping(value = "leave")
    public String leaveSubmit(Model model) throws Exception {
        return "leave";
    }

}
