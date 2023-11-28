package com.js.mealkitecommerce.app.controller;

import com.js.mealkitecommerce.app.entity.Kit;
import com.js.mealkitecommerce.app.global.rq.Rq;
import com.js.mealkitecommerce.app.global.util.ResponseUtil;
import com.js.mealkitecommerce.app.model.VO.Kit.CreateKitRequestVO;
import com.js.mealkitecommerce.app.model.common.ResponseData;
import com.js.mealkitecommerce.app.model.context.CustomerContext;
import com.js.mealkitecommerce.app.service.KitService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/kit")
public class KitController {
    private final KitService kitService;
    private final Rq rq;

    @PostMapping(
            value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseBody
    public ResponseEntity<ResponseData> createKit(@AuthenticationPrincipal CustomerContext customerContext, @RequestBody CreateKitRequestVO createKitRequestVO) {
        Kit newKit = kitService.createKit(customerContext.getCustomer(), createKitRequestVO);
        return ResponseUtil.successResponse(newKit);
    }
}
