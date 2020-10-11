<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">

<#if baseResultMap>
    <!-- 通用查询映射结果 -->
    <resultMap id="BaseResultMap" type="${package.Entity}.${entity}">
    <#-- table.fields 来自
     com.baomidou.mybatisplus.generator.config.po.TableInfo
     fields属性
     -->
        <#list table.fields as field>
            <#if field.keyFlag>
            <#--生成主键排在第一位-->
        <id column="${field.name}" property="${field.propertyName}"/>
            </#if>
        </#list>
<#list table.commonFields as field>
<#--生成公共字段 -->
    <result column="${field.name}" property="${field.propertyName}"/>
</#list>
<#list table.fields as field>
    <#if !field.keyFlag>
    <#--生成普通字段 -->
        <result column="${field.name}" property="${field.propertyName}"/>
    </#if>
</#list>
    </resultMap>

</#if>
<#if baseColumnList>
    <!-- 通用查询结果列 -->
    <sql id="Base_Column_List">
        <#list table.commonFields as field>
            ${field.name},
        </#list>
        ${table.fieldNames}
    </sql>

    <select id="select${entity}" parameterType="${package.Entity}.${entity}" resultType="${package.Entity}.${entity}">
        select
        <include refid="Base_Column_List"></include>
        from  ${table.name}
        <where>
        <#list table.fields as field>
            <#if field.keyFlag>
            <#--生成id字段 -->
            <if test="${field.propertyName} !=null ">
               and ${field.name} = <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>
            </if>
            </#if>
        </#list>
         <#list table.fields as field>
             <#if !field.keyFlag>
             <#--生成普通字段 -->
             <#--field.type   写法 同等 ${field.type}-->
            <if test="${field.propertyName} !=null <#if field.type?contains("varchar")> and ${field.propertyName} != ''</#if>">
               and ${field.name} = <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>
            </if>
             </#if>
         </#list>
        </where>
    </select>

    <select id="count" resultType="java.lang.Integer">
        select count(1) from  ${table.name}
        <where>
            <#list table.fields as field>
                <#if field.keyFlag>
                <#--生成id字段 -->
            <if test="${field.propertyName} !=null ">
               and ${field.name} = <#noparse>#{id}</#noparse>
            </if>
                </#if>
            </#list>
        </where>
    </select>

    <select id="select${entity}List" parameterType="${package.Entity}.${entity}"
            resultType="${package.Entity}.${entity}">
        select
        <include refid="Base_Column_List"></include>
        from  ${table.name}
        <where>
        <#list table.fields as field>
            <#if field.keyFlag>
            <#--生成id字段 -->
            <if test="${field.propertyName} !=null ">
               and ${field.name} = <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>
            </if>
            </#if>
        </#list>
         <#list table.fields as field>
             <#if !field.keyFlag>
             <#--生成普通字段 -->
            <if test="${field.propertyName} !=null">
               and ${field.name} = <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>
            </if>
             </#if>
         </#list>
        </where>
    </select>

    <insert id="insert${entity}">
        insert into ${table.name}
        <trim prefix="(" suffix=")" suffixOverrides=",">
        <#list table.fields as field>
        <#if field.keyFlag>
            <if test="${field.propertyName} !=null ">
                ${field.name},
            </if>
        </#if>
        </#list>
        <#list table.fields as field>
            <#if !field.keyFlag><#--生成普通字段 -->
            <if test="${field.propertyName} !=null ">
                ${field.name},
            </if>
            </#if>
        </#list>
        </trim>
        values
        <trim prefix="(" suffix=")" suffixOverrides=",">

        <#list table.fields as field>
            <#--主键id-->
        <#if field.keyFlag>
        <if test="${field.propertyName} !=null ">
           <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>,
        </if>
        </#if>
        <#--生成普通字段 -->
        <#if !field.keyFlag>
            <if test="${field.propertyName} !=null">
                 <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>,
            </if>
        </#if>
        </#list>
        </trim>
    </insert>

    <update id="update${entity}" parameterType="${package.Entity}.${entity}">
        update  ${table.name}
        <trim prefix="SET" suffixOverrides=",">
          <#list table.fields as field>
              <#if field.keyFlag>
            <if test="${field.propertyName} !=null ">
                ${field.name} = <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>,
            </if>
              </#if>
          </#list>
        <#list table.fields as field>
            <#if !field.keyFlag><#--生成普通字段 -->
            <if test="${field.propertyName} !=null ">
                ${field.name} = <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>,
            </if>
            </#if>
        </#list>
        </trim>
        <where>
        <#list table.fields as field>
            <#if field.keyFlag>
            <if test="${field.propertyName} !=null ">
                ${field.name} = <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>
            </if>
            </#if>
        </#list>
        </where>
    </update>

    <delete id="delete${entity}ById" parameterType="Integer">
        delete from  ${table.name}
        <where>
            <#list table.fields as field>
                <#if field.keyFlag>
            <#--生成id字段 -->
            <if test="${field.propertyName} !=null ">
                ${field.name} = <#noparse>#{id}</#noparse>
            </if>
                </#if>
            </#list>
        </where>
    </delete>

    <delete id="delete${entity}ByIds" parameterType="integer">
        delete from  ${table.name}
        where
        <#list table.fields as field>
        <#if field.keyFlag> ${field.name} in
        <#--生成id字段 -->
        <foreach item="${field.name}" collection="array" open="(" separator="," close=")">
            <#noparse>#{id}</#noparse>
        </foreach>
        </#if>
        </#list>
    </delete>


</#if>


</mapper>
