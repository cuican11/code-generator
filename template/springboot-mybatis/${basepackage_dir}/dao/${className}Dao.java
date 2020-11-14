<#include '/share.include'>
package ${basepackage}.dao.${moduleName};

import com.weijs.common.db.dao.IDao;
import ${basepackage}.bean.${className};

/**
 * ${table.remarks}
 * @author ${author}
 * @date ${.now?datetime}
 */
public interface ${className}Dao extends IDao<Integer, ${className}> {

}
