package com.js.mealkitecommerce.app.global.initData;

import com.js.mealkitecommerce.app.constants.type.PackingType;
import com.js.mealkitecommerce.app.constants.type.SexType;
import com.js.mealkitecommerce.app.entity.Customer;
import com.js.mealkitecommerce.app.model.VO.Customer.JoinRequestVO;
import com.js.mealkitecommerce.app.model.VO.Kit.CreateKitRequestVO;
import com.js.mealkitecommerce.app.service.CustomerService;
import com.js.mealkitecommerce.app.service.KitService;

public interface InitDataBefore {
    default void before(CustomerService customerService, KitService kitService) {
        JoinRequestVO joinForm1 =
                new JoinRequestVO(
                        "idtest1",
                        "1234",
                        "nametest1",
                        "nametest1@naver.com",
                        "010-0000-0000",
                        "20",
                        SexType.M,
                        "청주시",
                        "흥덕구",
                        "08754");
        JoinRequestVO joinForm2 =
                new JoinRequestVO(
                        "idtest2",
                        "1234",
                        "nametest2",
                        "nametest2@naver.com",
                        "010-1234-5678",
                        "25",
                        SexType.F,
                        "서울시",
                        "관악구",
                        "08754");
        customerService.join(joinForm1);
        customerService.join(joinForm2);

        Customer customer1 = customerService.findByUsername("idtest1").get();
        Customer customer2 = customerService.findByUsername("idtest2").get();

        CreateKitRequestVO createKitRequest1 =
                new CreateKitRequestVO("키트제목1", "카테고리1", 1000, 10, "만드는 방법", 5, PackingType.frozen);
        CreateKitRequestVO createKitRequest2 =
                new CreateKitRequestVO(
                        "키트제목2", "카테고리2", 2000, 20, "만드는 방법2", 10, PackingType.room_temperature);
        kitService.createKit(customer1, createKitRequest1);
        kitService.createKit(customer2, createKitRequest2);
    }
}
