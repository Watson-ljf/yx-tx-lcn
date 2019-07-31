package com.yx.sb.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 数据自动填充
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        LocalDateTime now = LocalDateTime.now();
        Object createdDate = getFieldValByName("createdDate", metaObject);//如果存在，则跳过设置
        Object lastModifiedDate = getFieldValByName("lastModifiedDate", metaObject);//
        if (createdDate == null) {
            setFieldValByName("createdDate", now, metaObject);//mybatis-plus版本2.0.9+
        }
        if (lastModifiedDate == null) {
            setFieldValByName("lastModifiedDate", now, metaObject);//mybatis-plus版本2.0.9+
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LocalDateTime now = LocalDateTime.now();
        setFieldValByName("lastModifiedDate", now, metaObject);
    }
}
