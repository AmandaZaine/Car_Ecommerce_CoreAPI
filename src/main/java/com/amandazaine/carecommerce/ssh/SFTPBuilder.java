package com.amandazaine.carecommerce.ssh;

//Design Pattern: Builder
public class SFTPBuilder {

    private final String port;
    private final String ip;
    private final String username;
    private final String password;
    private final String outputPath;

    public SFTPBuilder(Builder builder) {
        this.port = builder.port;
        this.ip = builder.ip;
        this.username = builder.username;
        this.password = builder.password;
        this.outputPath = builder.outputPath;
    }

    public String getPort() {
        return port;
    }

    public String getIp() {
        return ip;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public static class Builder {
        private String port;
        private String ip;
        private String username;
        private String password;
        private String outputPath;

        public Builder setPort(String port) {
            this.port = port;
            return this;
        }

        public Builder setIp(String ip) {
            this.ip = ip;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setOutputPath(String outputPath) {
            this.outputPath = outputPath;
            return this;
        }

        public SFTPBuilder build() {
            return new SFTPBuilder(this);
        }
    }

}
