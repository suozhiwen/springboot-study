package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * ${table.comment!} Mapper 接口
 *
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>

public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

    List<${entity}> select${entity}List(${entity} parameter);

    ${entity} selectEntity(${entity} parameter);

    Integer update(${entity} parameter);

    Integer insert(${entity} parameter);

    Integer deleteByIdById(@Param("id") Integer id);

    Integer deleteByIds(Integer[] ids);
}
</#if>
