///*
// * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
// */
//
//package com;
//import org.mybatis.generator.api.MyBatisGenerator;
//import org.mybatis.generator.config.Configuration;
//import org.mybatis.generator.config.xml.ConfigurationParser;
//import org.mybatis.generator.exception.InvalidConfigurationException;
//import org.mybatis.generator.exception.XMLParserException;
//import org.mybatis.generator.internal.DefaultShellCallback;
//
//import java.io.File;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 这是用来启动MyBatis Generator 的启动类
// *
// * @author Cll
// * @date 2018/10/10 9:49
// * @since 1.0.0
// */
//
//public class PromoterXML {
//    public static void main(String[] args) {
//        List<String> warnings = new ArrayList<>();
//        boolean overwrite = true;
//        //读取mybatis generator 的配置文件
//        File configFile = new File("src/main/resources/generatorConfig.xml");
//
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        try {
//            Configuration config = cp.parseConfiguration(configFile);
//            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,callback,warnings);
//            myBatisGenerator.generate(null);
//            warnings.forEach(a-> System.out.println("warnings have this problem"+a));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (XMLParserException e) {
//            e.printStackTrace();
//        } catch (InvalidConfigurationException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
