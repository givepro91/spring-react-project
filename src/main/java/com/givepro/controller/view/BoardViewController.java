package com.givepro.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardViewController {

    @RequestMapping("/board")
    public String lists() {
        return "board list page";
    }

}
