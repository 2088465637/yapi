package com.yuanchanglin.yapi;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import cn.hutool.core.io.resource.ResourceUtil;

import java.io.IOException;
import java.util.*;

/**
 * @author ycl
 * @since 2019-07-17
 */
public class CodeGenerator {
    private static final String AUTHOR = "yuanchanglin";
    private static final String ENTITYNAME = "%sPo";
    private static final String SERVICENAME = "%sService";
    private static final String MAPPERNAME = "%sMapper";
    private static final String XMLNAME = "%sMapper2";
    private static final String BASECONTROLLERPATH = "base.BaseController";

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        p.load(ResourceUtil.getStream("application.properties"));
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 当前项目的绝对路径
        String projectPath = System.getProperty("user.dir");
        // 输出目录
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(AUTHOR);
        gc.setEntityName(ENTITYNAME);
        gc.setBaseResultMap(false);
        gc.setBaseColumnList(false);
        gc.setMapperName(MAPPERNAME);
        gc.setXmlName(XMLNAME);
        gc.setServiceName(SERVICENAME);
        gc.setOpen(false);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(p.getProperty("spring.datasource.url"));
        // 选择数据库
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(p.getProperty("spring.datasource.username"));
        dsc.setPassword(p.getProperty("spring.datasource.password"));
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 如果不分模块注释这下面行
        pc.setModuleName(scanner("模块名"));
        pc.setParent(CodeGenerator.class.getPackage().getName());
        pc.setXml("mapper");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                String entityName = tableInfo.getEntityName();
                entityName = entityName.substring(0,entityName.length()-2);

                String moduleName = pc.getModuleName()==null||pc.getModuleName().isEmpty()?"":pc.getModuleName()+"/";
                return projectPath + "/src/main/resources/mapper/" + moduleName + entityName + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setController("/templates/controller.java");
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(false);
        strategy.setRestControllerStyle(true);
        strategy.setSuperControllerClass(CodeGenerator.class.getPackage().getName()+"."+BASECONTROLLERPATH);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        // 数据库主键字段名为id则不映射,如要映射则注释下一行
        strategy.setSuperEntityColumns("id");
        // Controller映射'-'分割
        strategy.setControllerMappingHyphenStyle(false);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}