package com.givepro;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * spa router url 오류 처리
 */
@Controller
public class RootController implements ErrorController {

    @GetMapping("/error")
    public String redirectRoot() {
        return "index.html";
    }

    @Override
    public String toString() {
        return "/error";
    }

}
