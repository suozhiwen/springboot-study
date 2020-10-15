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

public interface ${table.mapperName}  extends ${superMapperClass}<${entity}> {


}
</#if>
