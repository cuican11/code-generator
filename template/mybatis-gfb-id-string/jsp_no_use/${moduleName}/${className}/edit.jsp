<#include '/share.include'>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
    <form method="post" action="<c:url value='/${moduleName}/${classNameLow}/update'/>" class="pageForm required-validate"
        onsubmit="return validateCallback(this,navTabAjaxDone);">
        <input type="hidden" name="id" value="<@el2 'vo.id' />" />
        <div class="pageFormContent" layoutH="57">
            <ul>
                <#list table.notPkColumns as column> <#if column.columnNameFirstLower != 'isDel' && column.columnNameFirstLower != 'createTime'&&
                column.columnNameFirstLower != 'updateTime' && column.columnNameFirstLower != 'creatorId'&& column.columnNameFirstLower !=
                'updateId'>
                <li><label>${column.remarksFirst}: </label> <input type="text" name="${column.columnNameFirstLower}"
                    value="<@el2 'vo.${column.columnNameFirstLower}' />"<#if !column.nullable> class="required"</#if> /> </li> 
				</#if>
				</#list>

				<li>
					<label> 已删除:<input type="checkbox" name="deleted" <c:if test="<@el2 'vo.deleted'/>" > checked</c:if> /></label>
				</li>
			</ul>

		</div>

		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div></li>
				<li><div class="button">
						<div class="buttonContent">
							<button type="button" class="close">关闭</button>
						</div>
					</div></li>
			</ul>
		</div>
	</form>
</div>