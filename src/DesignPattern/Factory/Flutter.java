package DesignPattern.Factory;

public class Flutter {

    String platform;
    Flutter(String platform){
        this.platform = platform;
    }

    public void setTheme() {
        System.out.println("setting the theme for flutter");
    }

    public void setRefreshRate() {
        System.out.println("setting refresh rate for flutter");
    }

    public UIFactory createUIFactory() {
        return UIFactoryFactory.createUIFactory(platform);
    }
}
