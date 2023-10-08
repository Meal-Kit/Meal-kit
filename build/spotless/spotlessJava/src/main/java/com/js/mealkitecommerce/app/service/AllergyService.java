package com.js.mealkitecommerce.app.service;

import com.js.mealkitecommerce.app.entity.allergy.Allergy;
import com.js.mealkitecommerce.app.repository.AllergyRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AllergyService {
    private final AllergyRepository allergyRepository;

    public List<Allergy> getAllergiesByKitIdIn(long[] ids) {
        return allergyRepository.findAllByKitIdIn(ids);
    }
}
