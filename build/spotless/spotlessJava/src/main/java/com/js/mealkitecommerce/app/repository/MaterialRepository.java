package com.js.mealkitecommerce.app.repository;

import com.js.mealkitecommerce.app.entity.material.Material;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    Optional<Material> findByKitIdAndMaterialKeywordId(Long kitId, Long materialKeywordId);

    List<Material> findAllByKitId(Long id);

    List<Material> findAllByKitIdIn(long[] ids);
}
