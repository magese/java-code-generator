package com.magese.freemarker.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Magese
 * @date 2022/4/20 15:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldPair {

    /**
     * 字段类型
     */
    private Class<?> fieldType;
    /**
     * 字段名称
     */
    private String fieldName;

    public static FieldPair of(Class<?> fieldType, String fieldName) {
        return new FieldPair(fieldType, fieldName);
    }
}
