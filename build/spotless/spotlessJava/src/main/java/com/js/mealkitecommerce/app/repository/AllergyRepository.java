package com.js.mealkitecommerce.app.repository;

import com.js.mealkitecommerce.app.entity.allergy.Allergy;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergyRepository extends JpaRepository<Allergy, Long> {
    List<Allergy> findAllByKitIdIn(long[] ids);
}
