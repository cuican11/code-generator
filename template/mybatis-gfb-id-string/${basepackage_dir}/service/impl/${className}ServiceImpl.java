<#include '/share.include'>

package ${basepackage}.service.impl;

import com.elmsc.common.db.domain.PageInfo;
import com.elmsc.common.db.domain.PageControl;
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

	public ${className} find(String id){
		return ${classNameLow}Dao.getEntityById(id);
	}

	public	Integer delete(String id) {
		return ${classNameLow}Dao.delete(id);
	}

	public Integer deleteLogical(String id){
		${className} temp = new ${className}();
		temp.setId(id);
		temp.setDeleted(true);
		return ${classNameLow}Dao.update(temp);
	}

	public Integer update${className}(${className} ${classNameLow}){
		if (${classNameLow} == null) {
		return 0;
	}

		Integer i = ${classNameLow}Dao.update(${classNameLow});
		return i;
	}

	public PageControl<${className}> pageAndSortById(${className} ${classNameLow}, PageInfo pageInfo){
		return ${classNameLow}Dao.getPageByObject(${classNameLow}, pageInfo, null, " order by id asc ");
	}

	public PageControl<${className}> page(${className} ${classNameLow}, PageInfo pageInfo, String whereSql, String orderSql){
		return ${classNameLow}Dao.getPageByObject(${classNameLow}, pageInfo, whereSql, orderSql);
	}

    /*public Integer delete(Integer id, Integer updateId) {
		${className} temp = new ${className}();
		temp.setId(id);
		temp.setDeleted(true);
		temp.setUpdateId(updateId);
		return ${classNameLow}Dao.update(temp);
    }*/


}
