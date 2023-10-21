package DesignPattern.Factory;

import DesignPattern.Factory.Components.Button.Button;
import DesignPattern.Factory.Components.DropDown.DropDown;
import DesignPattern.Factory.Components.Menu.Menu;
import DesignPattern.Factory.Flutter;
import DesignPattern.Factory.UIFactory;

public class Client {
    public static void main(String[] args) {
        Flutter flutter = new Flutter("ios");




        UIFactory uiFactory = flutter.createUIFactory();

        Button button = uiFactory.createButton();
        Menu menu = uiFactory.createMenu();
        DropDown dropDown = uiFactory.createDropDown();

        button.sayHi();
    }
}
