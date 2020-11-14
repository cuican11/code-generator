<#include '/share.include'>


package ${basepackage}.controller.admin.${moduleName};

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import ${basepackage}.common.web.controller.BaseController;
import ${basepackage}.service.${className}Service;

/**
 * ${table.remarks}
 * @author ${author}
 * @date ${.now?datetime}
 */
@Controller
@RequestMapping(value = "/admin/${moduleName}/${classNameLow}")
public class ${className}Controller extends BaseController {

    @Autowired
    private ${className}Service ${classNameLow}Service;

    /**
     * 公共信息
     * @param model
     */
    private void addSharedAttr(Model model) {
    	
    }

    /**
     * 分页查询
     * @param vo
     * @param model
     * @return
     */
    @RequestMapping("")
    public String list(${className}ConditionVo vo, Model model) {

		List<${className}Vo> list = ${classNameLow}Service.find${className}Page(vo);
		System.out.println(vo);
	
		model.addAttribute("${classNameLow}List", list);
		addSharedAttr(model);
		model.addAttribute("vo", vo);// 回传信息
		model.addAttribute("pageId", "${className}");// 区分页面
	
		return "/admin/${moduleName}/${classNameLow}/list.html";
    }

    @RequestMapping("/view")
    public String view(int id, Model model) {

    	${className}Vo vo = ${classNameLow}Service.findById(id);
    	addSharedAttr(model);
    	model.addAttribute("vo", vo);

    	return "/admin/${moduleName}/${classNameLow}/view.html";
    }

    /**
     * 
     * @param handler   show 展示页面  其他  新增
     * @param model
     * @param vo
     * @param response
     * @return
     */
    @RequestMapping(value = "/insert")
    public String insert(String handler, Model model, ${className}Vo vo, HttpServletResponse response) {

		if (handler!=null&&handler.equals("show")) {
		    addSharedAttr(model);
		    return "/admin/${moduleName}/${classNameLow}/add.html";
		}
		vo.setCreatorId(getLoginId());
		${classNameLow}Service.insert(vo);
		writeDwzSignal("200", getMessage("msg.operation.success"), "${moduleName}${className}LiNav",
			"closeCurrent", null, response);
		return null;
    }

    /**
     * 
     * @param handler show 显示编辑页面  其他  更新
     * @param model
     * @param vo
     * @param response
     * @return
     */
    @RequestMapping(value = "/update")
    public String update(String handler, Model model, ${className}Vo vo, HttpServletResponse response) {
	
		if (handler!=null&&handler.equals("show")) {
			${className}Vo vo1 = ${classNameLow}Service.findById(vo.getId());
	
		    addSharedAttr(model);
		    model.addAttribute("vo", vo1);
		    return "/admin/${moduleName}/${classNameLow}/edit.html";
		}
		vo.setUpdateId(getLoginId());
		${classNameLow}Service.updateSelective(vo);
	
		writeDwzSignal("200", getMessage("msg.operation.success"), "${moduleName}${className}LiNav",
			"closeCurrent", null, response);
		return null;
    }

    /**
     * 假删除
     * @param ids  1,2,3
     * @param response
     */
    @RequestMapping("/delete")
    public void delete(String ids, HttpServletResponse response) {

		if (ids!=null&&ids.length()>0) {
			${className}Vo model = new ${className}Vo();
			model.setIsDel(1);
			for (String id : ids.split(",")) {
				// ${classNameLow}Service.delete(Integer.valueOf(id));
				model.setId(Integer.valueOf(id));
				model.setUpdateId(getLoginId());
				${classNameLow}Service.updateSelective(model);
			}
		}
	
		writeDwzSignal("200", getMessage("msg.operation.success"), "${moduleName}${className}LiNav", null, null,
			response);
	}
    
}
