<#include '/share.include'>
package ${basepackage}.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * ${table.remarks}
 * @author ${author}
 * @date ${.now?datetime}
 */
@Entity
public class ${className} implements Serializable {

	<#list columns as column>
	<#if validateBack='true'>
	${column.hibernateValidatorExprssion}</#if>
	<#if column.columnNameFirstLower='isDel'>
	private Integer isDel = 0; // 已删除:1是0否
	<#elseif column.columnNameFirstLower='id'>
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private ${column.possibleShortJavaType} ${column.columnNameFirstLower};  // ${column.remarks}
	<#else>
	private ${column.possibleShortJavaType} ${column.columnNameFirstLower};  // ${column.remarks}
	</#if>
	</#list>

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
	
//	public int hashCode() {
//		return new HashCodeBuilder()
//		<#list pkColumns as column>
//			.append(get${column.columnName}())
//		</#list>
//			.toHashCode();
//	}
	
//	public boolean equals(Object obj) {
//		if(obj instanceof ${className} == false) return false;
//		if(this == obj) return true;
//		${className} other = (${className})obj;
//		return new EqualsBuilder()
//			<#list pkColumns as column>
//			.append(get${column.columnName}(),other.get${column.columnName}())
//			</#list>
//			.isEquals();
//	}
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

