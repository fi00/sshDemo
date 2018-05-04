package cn.coolwind.ssh.web.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    @ApiOperation(notes = "测试控制器",value = "测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a",value = "aa",required = true,dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "b",value = "bb",required = true,dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "c",value = "cc",required = true,dataType = "string",paramType = "query")
    })
    public String Test(String a,String b,String c) {
        return a+b+c;
    }
}
