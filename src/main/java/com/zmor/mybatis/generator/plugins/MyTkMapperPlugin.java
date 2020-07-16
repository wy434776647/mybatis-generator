package com.zmor.mybatis.generator.plugins;

import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.config.Context;
import tk.mybatis.mapper.generator.MapperPlugin;

/**
 * @author wangyang
 * @date 2019/2/28 10:10
 */
public class MyTkMapperPlugin extends MapperPlugin {

    //注释生成器
    private CommentGeneratorConfiguration mycommentCfg;

    @Override
    public void setContext(Context context) {
        super.setContext(context);
        //设置默认的注释生成器
        mycommentCfg = new CommentGeneratorConfiguration();
        mycommentCfg.setConfigurationType(MyMapperCommentGenerator.class.getCanonicalName());
        context.setCommentGeneratorConfiguration(mycommentCfg);
    }

}
