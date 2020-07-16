package com.zmor.mybatis.generator.model;

import lombok.Data;

/**
 * GeneratorConfig is the Config of mybatis generator config exclude database
 * config
 * <p>
 * Created by Owen on 6/16/16.
 */
@Data
public class GeneratorConfig {

    /**
     * 本配置的名称
     */
    private String name;

    private String connectorJarPath;

    private String projectFolder;

    private String modelPackage;

    private String modelPackageTargetFolder;

    private String daoPackage;

    private String daoTargetFolder;

    private String iServicePath;

    private String baseServicePath;

    private String serviceTargetFolder;

    private String servicePackage;

    private String mapperName;

    private String mappingXMLPackage;

    private String mappingXMLTargetFolder;

    private String tableName;

    private String domainObjectName;

    private boolean offsetLimit;

    private boolean comment;

    private boolean overrideXML;

    private boolean needToStringHashcodeEquals;

    private boolean annotation;

    private boolean useActualColumnNames;

    private boolean useExampe;

    private String generateKeys;

    private String encoding;

    private boolean useTableNameAlias;

    private boolean useSchemaPrefix;

    private boolean useTkMapper;

    private boolean lombok;

    private boolean localDate;

    private String baseMapper;

    private String author;


}
