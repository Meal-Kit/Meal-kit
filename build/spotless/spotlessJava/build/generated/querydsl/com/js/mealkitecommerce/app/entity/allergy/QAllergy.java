package com.js.mealkitecommerce.app.entity.allergy;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.querydsl.core.types.dsl.PathInits;
import javax.annotation.processing.Generated;

/** QAllergy is a Querydsl query type for Allergy */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAllergy extends EntityPathBase<Allergy> {

    private static final long serialVersionUID = 1497522013L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAllergy allergy = new QAllergy("allergy");

    public final com.js.mealkitecommerce.app.entity.QBaseEntity _super =
            new com.js.mealkitecommerce.app.entity.QBaseEntity(this);

    public final QAllergyKeyword allergyKeyword;

    // inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    // inherited
    public final NumberPath<Long> id = _super.id;

    public final com.js.mealkitecommerce.app.entity.QKit kit;

    // inherited
    public final DateTimePath<java.time.LocalDateTime> modifyDate = _super.modifyDate;

    public QAllergy(String variable) {
        this(Allergy.class, forVariable(variable), INITS);
    }

    public QAllergy(Path<? extends Allergy> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAllergy(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAllergy(PathMetadata metadata, PathInits inits) {
        this(Allergy.class, metadata, inits);
    }

    public QAllergy(Class<? extends Allergy> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.allergyKeyword =
                inits.isInitialized("allergyKeyword")
                        ? new QAllergyKeyword(forProperty("allergyKeyword"))
                        : null;
        this.kit =
                inits.isInitialized("kit")
                        ? new com.js.mealkitecommerce.app.entity.QKit(forProperty("kit"), inits.get("kit"))
                        : null;
    }
}
