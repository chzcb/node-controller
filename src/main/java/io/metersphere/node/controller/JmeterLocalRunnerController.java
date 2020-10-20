package io.metersphere.node.controller;


import io.metersphere.node.controller.request.TestRequest;
import io.metersphere.node.service.LocalRunnerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("jmeter")
public class JmeterLocalRunnerController {
    @Resource
    private LocalRunnerService localRunnerService;


    @PostMapping("/start")
    public String startContainer(@RequestBody TestRequest testRequest) throws IOException {
        localRunnerService.startTest(testRequest);
        return "OK";
    }

    @GetMapping("/stop/{testId}")
    public String stopContainer(@PathVariable String testId) {
        localRunnerService.stopTest(testId);
        return "OK";
    }
}
