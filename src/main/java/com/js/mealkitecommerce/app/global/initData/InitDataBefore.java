package com.js.mealkitecommerce.app.global.initData;

import com.js.mealkitecommerce.app.constants.type.SexType;
import com.js.mealkitecommerce.app.model.VO.Customer.JoinRequestVO;
import com.js.mealkitecommerce.app.service.CustomerService;

public interface InitDataBefore {
    default void before(CustomerService customerService) {
        JoinRequestVO joinForm1 =
                new JoinRequestVO(
                        "idtest1", "1234", "nametest1", "nametest1@naver.com", "010-0000-0000", "20", SexType.M, "청주시", "흥덕구", "08754");
        JoinRequestVO joinForm2 =
                new JoinRequestVO(
                        "idtest2", "1234", "nametest2", "nametest2@naver.com", "010-1234-5678", "25", SexType.F, "서울시", "관악구", "08754");
        customerService.join(joinForm1);
        customerService.join(joinForm2);
    }
}
