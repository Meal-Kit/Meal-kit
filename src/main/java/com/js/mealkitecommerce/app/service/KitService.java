package com.js.mealkitecommerce.app.service;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import com.js.mealkitecommerce.app.entity.Customer;
import com.js.mealkitecommerce.app.entity.Kit;
import com.js.mealkitecommerce.app.entity.allergy.Allergy;
import com.js.mealkitecommerce.app.entity.material.Material;
import com.js.mealkitecommerce.app.model.VO.Kit.CreateKitRequestVO;
import com.js.mealkitecommerce.app.model.context.CustomerContext;
import com.js.mealkitecommerce.app.repository.KitRepository;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KitService {
    private final KitRepository kitRepository;
    private final MaterialService materialService;
    private final AllergyService allergyService;

    public Kit createKit(Customer customer, CreateKitRequestVO request) {
        Kit kit =
                Kit.builder()
                        .customer(customer)
                        .title(request.getTitle())
                        .category(request.getCategory())
                        .price(request.getPrice())
                        .quantity(request.getQuantity())
                        .how(request.getHow())
                        .discount(request.getDiscount())
                        .packingType(request.getPackingType())
                        .build();

        kitRepository.save(kit);

        return kit;
    }

    public List<Kit> findAllForPrintByOrderByIdDesc(Customer customer) {
        List<Kit> kits = findAllByOrderByIdDesc();

        loadForPrintData(kits, customer);

        return kits;
    }

    private void loadForPrintData(List<Kit> kits, Customer customer) {
        long[] ids = kits.stream().mapToLong(Kit::getId).toArray();

        List<Material> materialsByKitIds = materialService.getMaterialsByKitIdIn(ids);
        List<Allergy> allergiesByKitIds = allergyService.getAllergiesByKitIdIn(ids);

        Map<Long, List<Material>> materialsByProductIdMap =
                materialsByKitIds.stream()
                        .collect(groupingBy(material -> material.getKit().getId(), toList()));

        Map<Long, List<Allergy>> allergiesByProductIdMap =
                allergiesByKitIds.stream()
                        .collect(groupingBy(allergy -> allergy.getKit().getId(), toList()));

        kits.stream()
                .forEach(
                        material -> {
                            List<Material> materials = materialsByProductIdMap.get(material.getId());

                            if (materials == null || materials.size() == 0) return;

                            material.getExtra().put("materials", materials);
                        });

        kits.stream()
                .forEach(
                        allergy -> {
                            List<Material> allergies = materialsByProductIdMap.get(allergy.getId());

                            if (allergies == null || allergies.size() == 0) return;

                            allergy.getExtra().put("allergies", allergies);
                        });
    }

    private List<Kit> findAllByOrderByIdDesc() {
        return kitRepository.findAllByOrderByIdDesc();
    }
}
