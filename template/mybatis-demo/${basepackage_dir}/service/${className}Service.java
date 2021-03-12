<#include '/share.include'>

package ${basepackage}.service;

import ${basepackage}.common.db.domain.PageInfo;
import ${basepackage}.common.db.domain.PageControl;
import ${basepackage}.bean.${className};


/**
 * ${table.remarks}
 * @author ${author}
 * @date ${.now?datetime}
 */
public interface ${className}Service {

        Integer insert${className}(${className} ${classNameLow});

        ${className} find(Integer id);

        Integer deleteLogical(Integer id);

        Integer deleteBatch(String[] ids);

        Integer update${className}(${className} ${classNameLow});

        PageControl<${className}> pageAndSortById(${className} ${classNameLow}, PageInfo pageInfo);

        PageControl<${className}> page(${className} ${classNameLow}, PageInfo pageInfo, String whereSql, String orderSql);

 }
