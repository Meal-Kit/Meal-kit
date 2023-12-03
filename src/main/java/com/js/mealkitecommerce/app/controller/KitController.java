package com.js.mealkitecommerce.app.controller;

import com.js.mealkitecommerce.app.constants.ExceptionConstants;
import com.js.mealkitecommerce.app.entity.Kit;
import com.js.mealkitecommerce.app.exception.NotKitOwnerException;
import com.js.mealkitecommerce.app.global.rq.Rq;
import com.js.mealkitecommerce.app.global.util.ResponseUtil;
import com.js.mealkitecommerce.app.model.VO.Kit.CreateKitRequestVO;
import com.js.mealkitecommerce.app.model.VO.Kit.ModifyKitRequestVO;
import com.js.mealkitecommerce.app.model.VO.Kit.SearchKitRequestVO;
import com.js.mealkitecommerce.app.model.common.ResponseData;
import com.js.mealkitecommerce.app.model.context.CustomerContext;
import com.js.mealkitecommerce.app.service.KitService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/kit")
public class KitController {
    private final KitService kitService;
    private final Rq rq;


    @GetMapping(
            value = "/listAll",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseBody
    public ResponseEntity<ResponseData> retrieveKitListAll(@RequestBody SearchKitRequestVO request) {
        List<Kit> kits = null;

        // 제목 + 카테고리 : type = all, 제목 : type = title, 카테고리 : type = category
        if (!request.getType().equals("all")) {
            switch(request.getType()) {
                case "title":
                    kits = kitService.findAllByTitle(request.getKeyword());
                case "category":
                    kits = kitService.findAllByCategory(request.getKeyword());
            }
        } else {
            kits = kitService.findAllByTitleOrCategory(request.getKeyword(), request.getKeyword());
        }
        return ResponseUtil.successResponse(kits);
    }

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

    @GetMapping(
            value = "/detail/{kitId}"
    )
    @ResponseBody
    public ResponseEntity<ResponseData> detailKit(@PathVariable Long kitId) {
        Kit kit = kitService.findById(kitId);
        return ResponseUtil.successResponse(kit);
    }

    @PostMapping(
            value = "/modify/{kitId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseBody
    public ResponseEntity<ResponseData> updateKit(@AuthenticationPrincipal CustomerContext customerContext, @RequestBody ModifyKitRequestVO request, @PathVariable Long kitId) {
        Kit kit = null;
        if (kitId == customerContext.getId()) {
            kit = kitService.findById(kitId);
            kitService.updateKit(request, kit);
        } else {
            throw new NotKitOwnerException(ExceptionConstants.NOT_KIT_OWNER);
        }

        return ResponseUtil.successResponse(kit);
    }

    @PostMapping(
            value = "/delete/{kitId}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseBody
    public ResponseEntity<ResponseData> deleteKit(@AuthenticationPrincipal CustomerContext customerContext, @PathVariable Long kitId) {
        Kit kit = null;
        if (kitId == customerContext.getId()) {
            kit = kitService.findById(kitId);
            kitService.deleteKit(kit);
        } else {
            throw new NotKitOwnerException(ExceptionConstants.NOT_KIT_OWNER);
        }

        return ResponseUtil.successResponse("SUCCESS_DELETE");
    }
}
