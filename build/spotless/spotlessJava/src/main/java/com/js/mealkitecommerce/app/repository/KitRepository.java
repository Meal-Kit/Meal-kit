package com.js.mealkitecommerce.app.repository;

import com.js.mealkitecommerce.app.entity.Kit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KitRepository extends JpaRepository<Kit, Long> {
    List<Kit> findAllByOrderByIdDesc();
}
