
<#include '/share.include'>
package ${basepackage}.dao.${moduleName};

import ${basepackage}.common.db.dao.BaseDao;
import ${basepackage}.bean.${className};
import ${basepackage}.dao.${className}Dao;
import org.springframework.stereotype.Repository;

/**
 * ${table.remarks}
 * @author ${author}
 * @date ${.now?datetime}
 */
@Repository
public class ${className}DaoImpl extends BaseDao<Integer, ${className}> implements ${className}Dao {

}
