package leave.web.leave.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by 白嘿嘿黑 on 2018/3/27.
 */
@Controller
@RequestMapping(value = "")
public class TemplateController {
    final  private Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping(value = "")
    public String getIndex() throws Exception {
        return "login";
    }
}
