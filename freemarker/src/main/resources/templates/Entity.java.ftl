package ${packageName};

import lombok.Data;

@Data
public class ${className} {

<#list fields as field>
    private ${field.fieldType.simpleName} ${field.fieldName};

</#list>

}
