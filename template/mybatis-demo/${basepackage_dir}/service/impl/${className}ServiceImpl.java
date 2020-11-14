<#include '/share.include'>

package ${basepackage}.service.impl;

import ${basepackage}.common.db.domain.PageInfo;
import ${basepackage}.common.db.domain.PageControl;
import ${basepackage}.bean.${className};
import ${basepackage}.service.${className}Service;
import ${basepackage}.dao.${className}Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * ${table.remarks}
 * @author ${author}
 * @date ${.now?datetime}
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
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

	public ${className} find(Integer id){
		return ${classNameLow}Dao.getEntityById(id);
	}

	public Integer deleteLogical(Integer id){
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


}
