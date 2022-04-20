package com.magese.freemarker;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import com.magese.freemarker.config.EntityConfig;
import com.magese.freemarker.config.FieldPair;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Freemarker
 *
 * @author Magese
 * @date 2022/4/12 17:34
 */
@Slf4j
public class FreemarkerDemo {

    public static void main(String[] args) {
        String path = "D:/Develop/Project/java-code-generator/freemarker/src/main/java/com/magese/freemarker";
        String name = "UserVo.java";
        String template = "Entity.java.ftl";

        EntityConfig entityConfig = EntityConfig.builder()
                .packageName("com.magese.freemarker")
                .className("UserVo")
                .fields(ListUtil.of(
                        FieldPair.of(Integer.class, "id"),
                        FieldPair.of(String.class, "username"),
                        FieldPair.of(String.class, "password")
                ))
                .build();

        codeGenerator(path, name, template, entityConfig);
    }

    private static void codeGenerator(String outputPath, String fileName, String templateName, Object dataModel) {
        log.info("开始生成代码文件 => 输出目录：{}，文件名称：{}，模板名称：{}", outputPath, fileName, templateName);

        makeOutputDir(outputPath);

        try (FileOutputStream outputStream = new FileOutputStream(outputPath + "/" + fileName);
             OutputStreamWriter writer = new OutputStreamWriter(outputStream)) {

            Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
            cfg.setDirectoryForTemplateLoading(new File(getTemplateDir()));
            Template template = cfg.getTemplate(templateName);
            template.process(dataModel, writer);
            log.info("生成文件成功");

        } catch (Exception e) {
            log.error("输出文件异常", e);
        }
    }

    private static void makeOutputDir(String path) {
        File outputDir = new File(path);
        if (!outputDir.exists()) {
            if (outputDir.mkdir()) {
                log.info("创建输出文件夹成功");
            } else {
                throw new RuntimeException("创建输出文件夹异常");
            }
        }
    }

    private static String getTemplateDir() {
        return ResourceUtil.getResource("templates").getPath();
    }

}
