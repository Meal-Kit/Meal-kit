package com.js.mealkitecommerce.app.entity.allergy;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import javax.annotation.processing.Generated;

/** QAllergyKeyword is a Querydsl query type for AllergyKeyword */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAllergyKeyword extends EntityPathBase<AllergyKeyword> {

    private static final long serialVersionUID = -1751137332L;

    public static final QAllergyKeyword allergyKeyword = new QAllergyKeyword("allergyKeyword");

    public final com.js.mealkitecommerce.app.entity.QBaseEntity _super =
            new com.js.mealkitecommerce.app.entity.QBaseEntity(this);

    public final StringPath content = createString("content");

    // inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    // inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath listUrl = createString("listUrl");

    // inherited
    public final DateTimePath<java.time.LocalDateTime> modifyDate = _super.modifyDate;

    public QAllergyKeyword(String variable) {
        super(AllergyKeyword.class, forVariable(variable));
    }

    public QAllergyKeyword(Path<? extends AllergyKeyword> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAllergyKeyword(PathMetadata metadata) {
        super(AllergyKeyword.class, metadata);
    }
}
