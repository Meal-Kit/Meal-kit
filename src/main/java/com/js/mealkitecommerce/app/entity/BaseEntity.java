package com.js.mealkitecommerce.app.entity;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor(access = PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@ToString
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime createDate;

    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime modifyDate;

    public BaseEntity(long id) {
        this.id = id;
    }

    @Transient @Builder.Default private Map<String, Object> extra = new LinkedHashMap<>();
}
