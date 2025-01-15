package com.amandazaine.Car_Ecommerce_CoreAPI.ssh;

public class SFTPBuilder {

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
    }

}
