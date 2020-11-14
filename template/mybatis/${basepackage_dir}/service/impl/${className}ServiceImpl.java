<#include '/share.include'>

package ${basepackage}.service.impl;

import com.wp.common.db.PageInfo;
import com.wp.common.db.PagerControl;
import ${basepackage}.bean.${className};
import ${basepackage}.service.${className}Service;
import ${basepackage}.dao.${className}Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ${table.remarks}
 * @author ${author}
 * @date ${.now?datetime}
 */
@Service
public class ${className}ServiceImpl implements ${className}Service {

    @Autowired
    private ${className}Dao ${classNameLow}Dao;
    
    public Integer insert${className}(${className} ${classNameLow}){
	if (${classNameLow} == null) {
	    return 0;
	}
	
	Integer i = ${classNameLow}Dao.insert(${classNameLow});
	return i;
    }

    public Integer update${className}(${className} ${classNameLow}){
	if (${classNameLow} == null) {
	    return 0;
	}
	
	Integer i = ${classNameLow}Dao.update(${classNameLow});
	return i;
    }

    public PagerControl<${className}> page(${className} ${classNameLow}, PageInfo pageInfo, String whereSql, String orderSql){
	return ${classNameLow}Dao.getPagerByObj(${classNameLow}, pageInfo, whereSql, orderSql);
    }

    public ${className} find(Integer id){
	return ${classNameLow}Dao.getEntityById(id);
    }
    
    public Integer delete(Integer id){
	${className} temp = new ${className}();
	temp.setId(id);
	temp.setDeleted(true);
	return ${classNameLow}Dao.update(temp);
    }
    
    public Integer delete(Integer id, Integer updateId) {
	${className} temp = new ${className}();
	temp.setId(id);
	temp.setDeleted(true);
	temp.setUpdateId(updateId);
	return ${classNameLow}Dao.update(temp);
    }
    

}
