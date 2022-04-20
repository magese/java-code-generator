package com.magese.freemarker.config;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 实体类配置
 *
 * @author Magese
 * @date 2022/4/20 15:40
 */
@Data
@Builder
public class EntityConfig {

    /**
     * 包名
     */
    private String packageName;
    /**
     * 类名
     */
    private String className;
    /**
     * 字段列表
     */
    private List<FieldPair> fields;

}
