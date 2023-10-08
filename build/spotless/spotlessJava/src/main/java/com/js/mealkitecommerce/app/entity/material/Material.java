package com.js.mealkitecommerce.app.entity.material;

import com.js.mealkitecommerce.app.entity.BaseEntity;
import com.js.mealkitecommerce.app.entity.Kit;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Material extends BaseEntity {
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Kit kit;

    @ManyToOne @ToString.Exclude private MaterialKeyword materialKeyword;
}
