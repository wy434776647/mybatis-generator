package com.zmor.mybatis.generator.plugins;

import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.JDBCConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @author Liweizhou  2018/6/6
 */
public class LombokPlugin extends PluginAdapter {

    private String author;

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //添加domain的import
        topLevelClass.addImportedType("lombok.Getter");
        topLevelClass.addImportedType("lombok.Setter");
        topLevelClass.addImportedType("lombok.NoArgsConstructor");
//        topLevelClass.addImportedType("lombok.AllArgsConstructor");

        //添加domain的注解
        topLevelClass.addAnnotation("@Getter");
        topLevelClass.addAnnotation("@Setter");
        topLevelClass.addAnnotation("@NoArgsConstructor");
//        topLevelClass.addAnnotation("@AllArgsConstructor");

        String remarks = introspectedTable.getRemarks();
        //添加domain的注释
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine("* " + remarks);
        topLevelClass.addJavaDocLine("*");
        topLevelClass.addJavaDocLine("* @author " + author);
        topLevelClass.addJavaDocLine("*/");

        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //Mapper文件的注释
        interfaze.addJavaDocLine("/**");
        interfaze.addJavaDocLine("* @author " + author);
        interfaze.addJavaDocLine("*/");
        return true;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        //不生成getter
        return false;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        //不生成setter
        return false;
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        this.author = properties.getProperty("author");
    }
}
