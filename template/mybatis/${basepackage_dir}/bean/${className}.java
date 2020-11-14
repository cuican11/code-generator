<#include '/share.include'>
package ${basepackage}.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.wp.common.db.bean.BaseEntity;

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
	private Integer isDel=-1; // 已删除,1,-1
	<#else>
	private ${column.possibleShortJavaType    } ${column.columnNameFirstLower};  // ${column.remarks}
	</#if></#list>

<@generateConstructor className/>
<@generateJavaColumns/>

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		<#list columns as column>
			.append("${column.columnName}",get${column.columnName}())
		</#list>
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
		<#list pkColumns as column>
			.append(get${column.columnName}())
		</#list>
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof ${className} == false) return false;
		if(this == obj) return true;
		${className} other = (${className})obj;
		return new EqualsBuilder()
			<#list pkColumns as column>
			.append(get${column.columnName}(),other.get${column.columnName}())
			</#list>
			.isEquals();
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
	</#list>


<#if column.columnNameFirstLower='isDel'>
	public Boolean getDeleted() {
		return isDel != null && isDel > 0;
	}

	public void setDeleted(Boolean del) {
		this.isDel = del != null && del ? 1 : 0;
	}
</#if>
</#macro>

