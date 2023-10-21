package DesignPattern.Factory;

public class UIFactoryFactory { // practical factory

    public static UIFactory createUIFactory(String platform){
        if (platform.equals("android")) {
            return new AndroidUIFactory();
        } else if (platform.equals("ios")) {
            return new IosUIFactory();
        }

        return null;
    }
}
