package com.js.mealkitecommerce.app.entity.material;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMaterial is a Querydsl query type for Material
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMaterial extends EntityPathBase<Material> {

    private static final long serialVersionUID = 2031760345L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMaterial material = new QMaterial("material");

    public final com.js.mealkitecommerce.app.entity.QBaseEntity _super = new com.js.mealkitecommerce.app.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final com.js.mealkitecommerce.app.entity.QKit kit;

    public final QMaterialKeyword materialKeyword;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifyDate = _super.modifyDate;

    public QMaterial(String variable) {
        this(Material.class, forVariable(variable), INITS);
    }

    public QMaterial(Path<? extends Material> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMaterial(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMaterial(PathMetadata metadata, PathInits inits) {
        this(Material.class, metadata, inits);
    }

    public QMaterial(Class<? extends Material> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.kit = inits.isInitialized("kit") ? new com.js.mealkitecommerce.app.entity.QKit(forProperty("kit"), inits.get("kit")) : null;
        this.materialKeyword = inits.isInitialized("materialKeyword") ? new QMaterialKeyword(forProperty("materialKeyword")) : null;
    }

}

