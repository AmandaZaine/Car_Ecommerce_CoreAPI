package com.amandazaine.carecommerce.config;

import com.amandazaine.carecommerce.ssh.SFTPBuilder;
import com.amandazaine.carecommerce.utils.PropertiesConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SFTPConfig {

    //@Bean
    public SFTPBuilder getCarReportConfig() {
        PropertiesConfigUtils properties = new PropertiesConfigUtils("/home/amanda/Documentos/Car_Ecommerce_CoreAPI/src/main/resources/");

        String port = properties.getPropertyValue("car.report.port");
        String ip = properties.getPropertyValue("car.report.ip");
        String username = properties.getPropertyValue("car.report.username");
        String password = properties.getPropertyValue("car.report.password");
        String outputPath = properties.getPropertyValue("car.report.outputpath");

        return new SFTPBuilder
                .Builder()
                .setPort(port)
                .setIp(ip)
                .setUsername(username)
                .setPassword(password)
                .setOutputPath(outputPath)
                .build();
    }

}
