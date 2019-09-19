package com.jiuyuInfo;

import com.jiuyuInfo.common.config.Global;
import com.jiuyuInfo.common.utils.IpUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 启动程序
 *
 * @author cao_wencao
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class JiuyuInfoApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        ConfigurableApplicationContext context = SpringApplication.run(JiuyuInfoApplication.class, args);
        printKeyLoadMessage(context);
    }

    /**
     * 获取Key加载信息
     */
    public static boolean printKeyLoadMessage(ConfigurableApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();
        // 项目端口
        String port = environment.getProperty("server.port");
        // 项目路径
        String contextPath = environment.getProperty("server.servlet.context-path");
        // 项目名称
        // String projectFinalName = environment.getProperty("server.servlet.context-path");

        String loginUrl = "http://" + IpUtils.getHostIp() + ":" + port + contextPath;
        String swaggerUrl = "http://" + IpUtils.getHostIp() + ":" + port + contextPath + "/swagger-ui.html";
        //http://127.0.0.1:8888/silence/swagger-ui.html
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n======================================================================\r\n");
        sb.append("\r\n            (♥◠‿◠)ﾉﾞ  JiuYuInfo启动成功   ლ(´ڡ`ლ)ﾞ  \r\n");
        sb.append("\r\n    欢迎使用 " + Global.getName() + "  - JiuYuInfo.Version : 4.0.0.RELEASE\r\n");
        sb.append("\r\n======================================================================\r\n");
        System.out.println(sb.toString());
        System.out.println("\tloginUrl:    " + loginUrl);
        System.out.println("\tswaggerUrl: " + swaggerUrl);
        System.out.println("\r");
        return true;
    }
}