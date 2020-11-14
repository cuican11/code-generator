<#include '/share.include'>
package ${basepackage}.service;

import ${basepackage}.vo.${className};
import ${basepackage}.repo.${className}Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ${table.remarks}
 *
 * @author ${author}
 * @date ${.now?datetime}
 */
@Service
@Transactional
public class  ${className}Service{

        @Autowired
        private ${className}Repo ${classNameLow}Repo;

        /**
         * @param pageable
         * @return
         */
        public Page<${className}> list(Pageable pageable){
            Page<${className}> ${classNameLow}Page = ${classNameLow}Repo.findAll(pageable);
            return ${classNameLow}Page;
        }

        /**
         * 根据ID查询一条数据
         * @param id
         * @return
         */
        public ${className} findOne(int id){
            ${className} ${classNameLow} = ${classNameLow}Repo.findOne(id);
            return ${classNameLow};
        }

        /**
         * 修改
         * @param
         * @return
         */
        public void edit(${className} ${classNameLow}){
            if (${classNameLow} == null) {
                return;
            }
            ${classNameLow}Repo.save(${classNameLow});
        }

        /**
         * 新增
         * @param
         * @return
         */
        public void add(${className} ${classNameLow}){
            if (${classNameLow} == null) {
                return;
            }
            ${classNameLow}Repo.save(${classNameLow});
        }

        /**
         * 删除
         * @param id
         * @return
         */
        public void del(int id){
            ${classNameLow}Repo.delete(id);
        }

        /**
         * 检查数据库中是否已存在（当作模板使用，条件根据实际情况定义）
         * @param name
         * @return true为存在  false不存在
         */
        /*
        private boolean checkIfExists(String name) {

        ${className} ${classNameLow} = ${classNameLow}Repo.findFirstByName(name);

        if (null != ${classNameLow}) {
                return true;
        }
        return false;
        }
        */

}
