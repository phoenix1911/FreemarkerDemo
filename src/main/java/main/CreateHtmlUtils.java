package main;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tjl on 2019/3/7 14:26.
 */
public class CreateHtmlUtils {
    /**
     * 通过freemarker生成静态HTML页面
     * @param templateName             模版名称
     * @param targetFileName        模版生成后的文件名
     * @param map                           freemarker生成的数据都存储在MAP中，
     * @创建时间：2017年10月22日21:41:06
     */
    public static void createHtml(String templateName, String targetFileName, Map<String, Object> map) throws Exception{
        //创建fm的配置
        Configuration config = new Configuration();
        //指定默认编码格式
        config.setDefaultEncoding("UTF-8");
        //设置模版文件的路径
        config.setClassForTemplateLoading(CreateHtmlUtils.class, "/ftl");
        //获得模版包
        Template template = config.getTemplate(templateName);
        //从参数文件中获取指定输出路径 ,路径示例：C:/Workspace/shop-test/src/main/webapp/html
        String path = "C:\\Users\\JiaLong\\Documents\\IdeaProject\\FreemarkerDemo\\src\\main\\webapp\\html";
        //定义输出流，注意必须指定编码
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path+"/"+targetFileName)),"UTF-8"));
        //生成模版
        template.process(map, writer);
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> map = new HashMap<>();
        //map的key在ftl中这么用 ${hello}
        map.put("hello", "Hello World!");
        map.put("aaa","Freemarker 是一款模板引擎，是一种基于模版生成静态文件的通用 工具，它是为Java程序员提供的一个开发包，或者说是一个类库，它不是面向最终用户的，而是为程序员提供了一款可以嵌入他们开发产品的应用程序。\n" +
                "\n" +
                "    Freemarker 是使用纯java编写的，为了提高页面的访问速度，需要把页面静态化， 那么Freemarker就是被用来生成html页面。\n" +
                "\n" +
                "    到目前为止，Freemarker使用越来越广泛，不光光只是它强大的生成技术，而且它能够与spring进行很好的集成。\n" );

        CreateHtmlUtils.createHtml("html.ftl","createhtmldemo.html" , map);

    }

}
