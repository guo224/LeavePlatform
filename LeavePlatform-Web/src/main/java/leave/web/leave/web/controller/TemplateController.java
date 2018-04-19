package leave.web.leave.web.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import leave.interfaces.IUserService;
import leave.model.object.LeaveRecord;
import leave.model.object.User;
import leave.repository.LeaveRecordRepository;
import leave.repository.UserRepository;
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
import java.util.List;


/**
 * Created by 白嘿嘿黑 on 2018/3/27.
 */
@Controller
@RequestMapping(value = "")
public class TemplateController {
    private TemplateEngine templateEngine;
    private final UserRepository userRepository;
    private final LeaveRecordRepository leaveRecordRepository;
    final  private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final IUserService iUserService;
    @Autowired
    public TemplateController(final ServletContext servletContext, UserRepository userRepository, LeaveRecordRepository leaveRecordRepository, IUserService iUserService) {
        super();
        this.userRepository = userRepository;
        this.leaveRecordRepository = leaveRecordRepository;
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
        PageInfo<User> pageInfo = userRepository.searchTeacher("0", "0");
        List<User> campusList = pageInfo.getList();
        logger.info(JSON.toJSONString(campusList));
        model.addAttribute("campusList",campusList);
        return "index";
    }
    @GetMapping(value = "leave")
    public String leaveSubmit(Model model) throws Exception {
        return "leave";
    }

}
