package com.jk.Integral;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.integral.service.IntegralService;
import org.springframework.stereotype.Controller;

@Controller
public class IntegralController {
    @Reference(version = "1.0")
    private IntegralService integraService;
}
