package com.js.mealkitecommerce.app.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.querydsl.core.types.dsl.PathInits;
import javax.annotation.processing.Generated;

/** QKit is a Querydsl query type for Kit */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKit extends EntityPathBase<Kit> {

    private static final long serialVersionUID = -1605722207L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QKit kit = new QKit("kit");

    public final QBaseEntity _super = new QBaseEntity(this);

    // inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final NumberPath<Integer> discount = createNumber("discount", Integer.class);

    public final StringPath how = createString("how");

    // inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath kind = createString("kind");

    public final QCustomer member;

    // inherited
    public final DateTimePath<java.time.LocalDateTime> modifyDate = _super.modifyDate;

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final StringPath title = createString("title");

    public QKit(String variable) {
        this(Kit.class, forVariable(variable), INITS);
    }

    public QKit(Path<? extends Kit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QKit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QKit(PathMetadata metadata, PathInits inits) {
        this(Kit.class, metadata, inits);
    }

    public QKit(Class<? extends Kit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QCustomer(forProperty("member")) : null;
    }
}
