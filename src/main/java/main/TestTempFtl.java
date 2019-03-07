package main;

/**
 * Created by Tjl on 2019/3/7 11:41.
 */
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class TestTempFtl {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setObjectWrapper(new DefaultObjectWrapper());
        //FTL文件所存在的位置(在IDEA中.ftl文件需要放在 resources资源目录下才能找到
        configuration.setTemplateLoader(new ClassTemplateLoader(TestTempFtl.class, "/ftl"));
        try {
            //具体的ftl文件
            Template template = configuration.getTemplate("a.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> context = new HashMap<String, Object>();

            context.put("message", "我的第一个Maven_FreeMarker程序");

            template.process(context, writer);
            System.out.println(writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}



