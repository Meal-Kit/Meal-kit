package com.js.mealkitecommerce.app.controller;

import com.js.mealkitecommerce.app.entity.Kit;
import com.js.mealkitecommerce.app.global.rq.Rq;
import com.js.mealkitecommerce.app.service.KitService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/kit")
public class KitController {
    private final KitService kitService;
    private final Rq rq;

    @GetMapping("list")
    public String showList(Model model) {
        List<Kit> kits = kitService.findAllForPrintByOrderByIdDesc(rq.getCustomer());

        model.addAttribute("kits", kits);

        return "kit/list";
    }
}
