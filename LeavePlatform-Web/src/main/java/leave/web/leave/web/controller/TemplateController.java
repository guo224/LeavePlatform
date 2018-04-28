package leave.web.leave.web.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import leave.interfaces.ILeaveRecordService;
import leave.interfaces.IUserService;
import leave.model.object.LeaveRecord;
import leave.model.object.User;
import leave.repository.LeaveRecordRepository;
import leave.repository.UserRepository;
import leave.util.BaseReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = "teacherIndex")
    public String teacherIndex(Model model) throws Exception {
        return "teacherIndex";
    }
    @GetMapping(value = "adminIndex")
    public String adminIndex(Model model) throws Exception{
        getAllteacher(model);
        return "adminIndex";
    }
    @GetMapping(value = "studentleave")
    public String studentleave(Model model) throws Exception {
        return "studentleave";
    }
    @GetMapping(value = "student")
    public String getAllStudent(Model model) throws Exception {
        PageInfo<User> pageInfo = userRepository.getAllUserType("0","0","0");
        List<User> studentList = pageInfo.getList();
        getAllteacher(model);
        model.addAttribute("studentList",studentList);
        return "student";
    }
    @GetMapping(value = "index")
    public String getIndex(Model model) throws Exception {
        getAllteacher(model);
        return "index";
    }

    @GetMapping(value = "leave")
    public String leaveSubmit(@RequestParam("userId") String userId, Model model) throws Exception {
        getAllteacher(model);
        PageInfo<LeaveRecord> pageInfo = leaveRecordRepository.getLeaveRecord(userId,"0","0");
        List<LeaveRecord> LeaveRecordList = pageInfo.getList();
        for(LeaveRecord leaveRecord :LeaveRecordList){
            User user = iUserService.getUserByUserId(leaveRecord.getUserId());
            leaveRecord.setStartTime1(leaveRecord.getUpdateTime().toString());
            if(user != null ) {
                leaveRecord.setName(user.getName());
            }else{
                leaveRecord.setName("无姓名");
            }
        }
        logger.info(JSON.toJSONString(LeaveRecordList));
        model.addAttribute("LeaveRecordList",LeaveRecordList);
        return "leave";
    }

    private void getAllteacher(Model model) {
        PageInfo<User> pageInfo = userRepository.searchTeacher("0", "0");
        List<User> campusList = pageInfo.getList();
        logger.info(JSON.toJSONString(campusList));
        model.addAttribute("campusList",campusList);
    }

}
