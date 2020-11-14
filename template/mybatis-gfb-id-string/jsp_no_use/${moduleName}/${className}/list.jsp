<#include '/share.include'>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../../management/_frag/pager/pagerForm.jsp"></c:import>
<script>
	$(document).ready(
            function() {
	            $("#moreS${className}").show();
	            sh =
	                    $('#searchHeader${className}').height() - $("#desc${className}").height()
	                            - $(".subBar").height();
	            $("#moreS${className}").hide();
            });
    var sh;
    function vali${className}(form) {
	    if (!$(form).valid()) return false;
	    return navTabSearch(form);
    }
    function openSearch${className}(btn) {
	    /*  $.pdialog.open('${moduleName}/${className}/query' , 'sdf' , '查询' , {minable: false , mask: true , close: '' ,
	         param: "{msg:'message'}"
	     }); */

	    $this = $(btn);

	    //alert($('#searchHeader${className}').height()+','+sh);
	    if ($this.text() == '显示检索区') {
		    // alert(sh);
		    $this.text('隐藏检索区');
		    $("#moreS${className}").show();
		    var $panel = $this.parents('.unitBox:first').find("[layoutH]").each(function() {
			    $(this).attr("layoutH" , parseInt($(this).attr("layoutH")) + sh);
			    $(this).layoutH();
		    });
	    } else {
		    // alert(sh);
		    $this.text('显示检索区');
		    $("#moreS${className}").hide();
		    var $panel = $this.parents('.unitBox:first').find("[layoutH]").each(function() {
			    $(this).attr("layoutH" , parseInt($(this).attr("layoutH")) - sh);
			    $(this).layoutH();
		    });
	    }
	    //alert($this.parents('.unitBox:first').find("[layoutH]").height());
	    return false;
    }
</script>
<form method="post" rel="pagerForm" class="pageForm required-validate" action="<c:url value='/${moduleName}/${classNameLow}'/>"
    onsubmit="return vali${className}(this)">
    <div id='searchHeader${className}' class="pageHeader">
        <div class="searchBar">
            <div id='desc${className}' class="subBar">由${sqlName }生成</div>
            <ul class="searchContent" style='display:none;overflow: visible;' id='moreS${className}'>
                <li><label>
                        已删除:<input type="checkbox" name="deleted" <c:if test="<@el2 'vo.deleted'/>"> checked</c:if> />
                    </label></li>
                <li><label>生成时间起：</label> <input type="text" name="createTime1" class="date" dateFmt="yyyy-MM-dd HH:mm"
                    value='<fmt:formatDate value="<@el2 'vo.createTime1'/>" pattern="yyyy-MM-dd HH:mm"/>' /></li>
                <li><label>生成时间止：</label> <input type="text" name="createTime2" class="date" dateFmt="yyyy-MM-dd HH:mm"
                    value='<fmt:formatDate value="<@el2 'vo.createTime2'/>" pattern="yyyy-MM-dd HH:mm"/>' /></li>
            </ul>
            <div class="subBar">
                <ul>
                    <li>
                        <div class="buttonActive">
                            <div class="buttonContent">
                                <button type="submit">搜索</button>
                            </div>
                        </div>
                        <div class="buttonActive">
                            <div class="buttonContent">
                                <button type='button' onclick='openSearch${className}(this)'>显示检索区</button>
                            </div>
                        </div>
                        <div class="buttonActive">
                            <div class="buttonContent">
                                <button type="reset">重置</button>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</form>


<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add " target="navTab" href="<c:url value='/${moduleName}/${classNameLow}/insert?handler=show'/>" title="添加"><span>添加</span></a></li>
            <li><a class="edit" target="navTab" href="<c:url value='/${moduleName}/${classNameLow}/update?handler=show&id={slt_objId}'/>" title="编辑"><span>编辑</span></a></li>
            <c:if test="<@el2 '!(vo.deleted)'/>">
                <li><a class="delete" target="selectedTodo" rel='ids' postType="string"
                    href="<c:url value='/${moduleName}/${classNameLow}/delete'/>" title="你确定要删除吗?"><span>删除</span></a></li>
            </c:if>
            <li class="line">line</li>
        </ul>
    </div>
    <table class="list" width="98%" layoutH="113">
        <thead>
            <tr>
                <th width="22">
                    <input type="checkbox" group="ids" class="checkboxCtrl">
                </th> <#list columns as column><#if column.columnNameFirstLower ='isDel'><#else>
                <th orderField=${column.sqlName } class="<@el2 " vo.orderField eq '${column.sqlName}' ? vo.orderDirection : ''"/>">${column.remarksFirst }
                </th></#if> </#list>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="<@el2 '${classNameLow}List'/>" varStatus="s">
                <tr target="slt_objId" rel="<@el2 'item.id '/>">
                    <td><input name="ids" type="checkbox" value='<@el2 ' item.id '/>'></td> <#list columns as column> <#if
                    column.possibleShortJavaType ='Date'>
                    <td><fmt:formatDate value="<@el2 'item.${column.columnNameFirstLower  }'/>" pattern="yyyy-MM-dd HH:mm" /></td> <#elseif
                    column.columnNameFirstLower ='isDel'> <#else>
                    <td><@el2 'item.${column.columnNameFirstLower  }'/></td></#if></#list>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <c:import url="../../management/_frag/pager/panelBar.jsp"></c:import>
</div>