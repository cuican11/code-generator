<#include '/share.include'>

package ${basepackage}.service;

import com.elmsc.common.db.domain.PageInfo;
import com.elmsc.common.db.domain.PageControl;
import ${basepackage}.bean.${className};


/**
 * ${table.remarks}
 * @author ${author}
 * @date ${.now?datetime}
 */
public interface ${className}Service {

        Integer insert${className}(${className} ${classNameLow});

        ${className} find(String id);

        Integer delete(String id);

        Integer deleteLogical(String id);

        Integer update${className}(${className} ${classNameLow});

        PageControl<${className}> pageAndSortById(${className} ${classNameLow}, PageInfo pageInfo);

        PageControl<${className}> page(${className} ${classNameLow}, PageInfo pageInfo, String whereSql, String orderSql);

//    Integer delete(Integer id, Integer updateId);

 }
