
<#include '/share.include'>
package ${basepackage}.repo;

import ${basepackage}.vo.${className};
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * ${table.remarks}
 * @author ${author}
 * @date ${.now?datetime}
 */
@Repository
public interface ${className}Repo extends PagingAndSortingRepository<${className}, Integer> {

        //${className} ${classNameLow}Repo.findFirstByName(String name);

}


