<#include '/share.include'>

package ${basepackage}.service;

import com.weijs.common.db.domain.PageInfo;
import com.weijs.common.db.domain.PageControl;
import ${basepackage}.bean.${className};


/**
 * ${table.remarks}
 * @author ${author}
 * @date ${.now?datetime}
 */
public interface ${className}Service {

    Integer insert${className}(${className} ${classNameLow});

    ${className} find(Integer id);

<#macro generateJavaColumns>
<#list columns as column>

    <#if column.columnNameFirstLower='isDel'>
        Integer deleteLogical(Integer id);
    </#if>

    </#list>

</#macro>

    Integer update${className}(${className} ${classNameLow});

    PageControl<${className}> pageAndSortById(${className} ${classNameLow}, PageInfo pageInfo);

    PageControl<${className}> page(${className} ${classNameLow}, PageInfo pageInfo, String whereSql, String orderSql);

//    Integer delete(Integer id, Integer updateId);

}
