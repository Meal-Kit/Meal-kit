package com.js.mealkitecommerce.app.repository;

import com.js.mealkitecommerce.app.entity.Kit;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KitRepository extends JpaRepository<Kit, Long> {
    List<Kit> findAllByOrderByIdDesc();

    List<Kit> findAllByTitleContainingOrderByCreateDateDesc(String title);

    List<Kit> findAllByCategoryContainingOrderByCreateDateDesc(String keyword);

    List<Kit> findAllByTitleOrCategoryContainingOrderByCreateDateDesc(String title, String category);

    Optional<Kit> findById(Long id);
}
