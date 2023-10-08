package com.js.mealkitecommerce.app.entity.material;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMaterialKeyword is a Querydsl query type for MaterialKeyword
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMaterialKeyword extends EntityPathBase<MaterialKeyword> {

    private static final long serialVersionUID = 304294864L;

    public static final QMaterialKeyword materialKeyword = new QMaterialKeyword("materialKeyword");

    public final com.js.mealkitecommerce.app.entity.QBaseEntity _super = new com.js.mealkitecommerce.app.entity.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath listUrl = createString("listUrl");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifyDate = _super.modifyDate;

    public QMaterialKeyword(String variable) {
        super(MaterialKeyword.class, forVariable(variable));
    }

    public QMaterialKeyword(Path<? extends MaterialKeyword> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMaterialKeyword(PathMetadata metadata) {
        super(MaterialKeyword.class, metadata);
    }

}

