package br.com.contatemeantes;

public class AppConfig {
    public boolean runGeoservice = true;


    private static final AppConfig instance = new AppConfig();
    private AppConfig() {
    }
    public static AppConfig getInstance() {
        return instance;
    }
}