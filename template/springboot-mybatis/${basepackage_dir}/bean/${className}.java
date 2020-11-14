<#include '/share.include'>
package ${basepackage}.bean;

import com.weijs.common.bean.BaseEntity;
import java.util.Date;


/**
 * ${table.remarks}
 * @author ${author}
 * @date ${.now?datetime}
 */
public class ${className} extends BaseEntity {

	<#list columns as column>
	<#if validateBack='true'>
	${column.hibernateValidatorExprssion}</#if>
	<#if column.columnNameFirstLower='isDel'>
	private Integer isDel = 0; // 1已删除,0未删除
	<#else>
	private ${column.possibleShortJavaType    } ${column.columnNameFirstLower};  // ${column.remarks}
	</#if></#list>

<@generateConstructor className/>
<@generateJavaColumns/>

	public String toString() {
		return new StringBuffer("${className}").append("{")
	<#list columns as column>
		.append("${column.columnName}: " + get${column.columnName}())
	</#list>
		.append("}")
		.toString();
	}

}

<#macro generateJavaColumns>
	<#list columns as column>
		<#if column.isDateTimeColumn>

		</#if>
	public void set${column.columnName}(${column.possibleShortJavaType  } value) {
		this.${column.columnNameFirstLower} = value;
	}

	public ${column.possibleShortJavaType  } get${column.columnName}() {
		return this.${column.columnNameFirstLower};
	}

<#if column.columnNameFirstLower='isDel'>
	public Boolean getDeleted() {
		return isDel != null && isDel > 0;
	}

	public void setDeleted(Boolean del) {
		this.isDel = del != null && del ? 1 : 0;
	}
</#if>

	</#list>

</#macro>

