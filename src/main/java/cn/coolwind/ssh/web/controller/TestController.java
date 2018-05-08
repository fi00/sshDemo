package cn.coolwind.ssh.web.controller;

import cn.coolwind.ssh.core.base.BaseController;
import cn.coolwind.ssh.web.entity.Test;
import cn.coolwind.ssh.web.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class TestController extends BaseController {

    @Autowired
    private TestService testService;

    @GetMapping("/index")
    public Map index() {
        return success(testService.test());
    }


    @PostMapping("/change")
    @ResponseBody
    public Map change(@RequestBody Test test) {
        testService.change(test);
        return this.success();
    }

    @GetMapping("/delete")
    @ResponseBody
    public Map delete(int id) {
        testService.delete(id);
        return success();
    }


}
