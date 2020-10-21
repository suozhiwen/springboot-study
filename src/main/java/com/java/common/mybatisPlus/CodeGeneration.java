package com.java.common.mybatisPlus;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 通过junit test 生成代码
 * 演示：自定义代码模板
 * 默认不会覆盖已有文件，如果需要覆盖，配置GlobalConfig.setFileOverride(true)
 * </p>
 *
 * @author szw
 */
public class CodeGeneration {
    /**
     * 根获取项目路径
     */
    static String projectPath = System.getProperty("user.dir");
    public static void main(String[] args) {
        /** 需要生成单表的名称 */
        String tableNamesInclude = "sys_user";

        /** 生成代码存放的路径 */
        String parent = "com.java";
        AutoGenerator mpg = new AutoGenerator();
        //定义模板是  Freemarker
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("szw");
        gc.setOpen(false);
        // XML ResultMap  返回结果
        gc.setBaseResultMap(true);
        // XML columList 通用查询结果列通用结果列
        gc.setBaseColumnList(true);
        //开启 swagger2 模式
        gc.setSwagger2(false);

        //默认不覆盖，如果文件存在，将不会再生成，配置true就是覆盖
        gc.setFileOverride(true);
        mpg.setGlobalConfig(gc);

        /** 数据源配置 */
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/world?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&nullCatalogMeansCurrent=true");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //设置包路径
        pc.setParent(parent);
        mpg.setPackageInfo(pc);

        // 策略配置  数据库配置
        StrategyConfig strategy = new StrategyConfig();

        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //开启lombok
        strategy.setEntityLombokModel(true);
        //开启 链式模型
        strategy.setChainModel(true);

        //输入单表名称则只生成相应的单表文件
        if (StringUtils.isNotBlank(tableNamesInclude)) {
            strategy.setInclude(tableNamesInclude);
        }

        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setEntityTableFieldAnnotationEnable(true);
        //生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        configCustomizedCodeTemplate(mpg);
        configInjection(mpg);
        mpg.execute();

        System.out.println("代码生成完成");
    }

    /**
     * 自定义模板
     *
     * @param mpg
     */
    private static void configCustomizedCodeTemplate(AutoGenerator mpg) {
        //配置 自定义模板
        TemplateConfig templateConfig = new TemplateConfig()
                //指定Entity生成使用自定义模板
                .setEntity("templates/MyEntityTemplate.java")
                //指定Controller生成使用自定义模板
                .setController("templates/MyControllerTemplate.java")
                //指定Mapper接口模板
                .setMapper("templates/MyMapperTemplate.java")
                .setXml(null)
                .setService("templates/MyService.java")
                .setServiceImpl("templates/MyServiceImpl.java");
        mpg.setTemplate(templateConfig);
    }

    /**
     * 配置自定义参数/属性
     *
     * @param mpg
     */
    private static void configInjection(AutoGenerator mpg) {
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/MyMapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 指定mapper.xml  模板生成，自定义生成文件到哪个地方
                return projectPath + "/src/main/resources/mapper/"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
    }
}
