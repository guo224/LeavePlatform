package leave.web.leave.web.controller;

import leave.interfaces.ILeaveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 白嘿嘿黑 on 2018/4/19.
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    private ILeaveRecordService iLeaveRecordService;

    @RequestMapping(value = "revokeLeave",method = RequestMethod.POST)
    public String revokeLeave(@RequestParam("leaveId") String leaveId){
        return iLeaveRecordService.revokeLeave(leaveId);
    }


}
