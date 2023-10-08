package com.js.mealkitecommerce.app.repository;

import com.js.mealkitecommerce.app.entity.material.MaterialKeyword;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialKeywordRepository extends JpaRepository<MaterialKeyword, Long> {
    Optional<MaterialKeyword> findByContent(String keywordContent);
}
