<#include '/share.include'>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
    <form method="post" action="<c:url value='/${moduleName}/${classNameLow}/insert'/>" class="pageForm required-validate"
        onsubmit="return validateCallback(this,navTabAjaxDone);">
        <div class="pageFormContent" layoutH="57">
            <ul>
                <#list table.notPkColumns as column> <#if column.columnNameFirstLower != 'state' && column.columnNameFirstLower != 'isDel' &&
                column.columnNameFirstLower != 'createTime'&& column.columnNameFirstLower != 'updateTime' && column.columnNameFirstLower !=
                'creatorId'&& column.columnNameFirstLower != 'updateId'>
                <li><label>${column.remarksFirst}: </label> <input type="text" name="${column.columnNameFirstLower}"<#if !column.nullable> class="required"</#if> />
				</li> </#if> </#list>

                <li><label>
                        已删除:<input type="checkbox" name="deleted" />
                    </label></li>
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
