package com.amandazaine.carecommerce.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfigUtils {

    private Properties properties;

    public PropertiesConfigUtils(String propertiesFilePath) {
        properties = new Properties();
        FileInputStream fileInput = null;

        try {
            fileInput = new FileInputStream(propertiesFilePath);
            properties.load(fileInput);

            if (fileInput != null) {
                fileInput.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillInPropValueWithEnvVars() {
        for(String chave : properties.stringPropertyNames()) {
            String valor = properties.getProperty(chave);

            if(valor != null && valor.startsWith("${") && valor.endsWith("}")) {
                String nomeVarAmb = valor.substring(2, valor.length() - 1);

                //System.getenv: acessa variáveis de ambiente do sistema operacional através do nome da variável
                String valorVarAmb = System.getenv(nomeVarAmb);

                if(valorVarAmb != null) {
                    properties.setProperty(chave, valorVarAmb);
                }
            }
        }
    }

    public String getPropertyValue(String propertyKey) {
        return properties.getProperty(propertyKey);
    }
}
