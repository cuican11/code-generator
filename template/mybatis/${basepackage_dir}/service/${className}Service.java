<#include '/share.include'>

package ${basepackage}.service;

import com.wp.common.db.PageInfo;
import com.wp.common.db.PagerControl;
import ${basepackage}.bean.${className};


/**
 * ${table.remarks}
 * @author ${author}
 * @date ${.now?datetime}
 */
public interface ${className}Service {

    Integer insert${className}(${className} ${classNameLow});

    Integer update${className}(${className} ${classNameLow});

    PagerControl<${className}> page(${className} ${classNameLow}, PageInfo pageInfo, String whereSql, String orderSql);

    ${className} find(Integer id);
    
    Integer delete(Integer id);
    
    Integer delete(Integer id, Integer updateId);

}
