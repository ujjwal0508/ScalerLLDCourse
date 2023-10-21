package DesignPattern.Factory;

import DesignPattern.Factory.Components.Button.AndroidButton;
import DesignPattern.Factory.Components.Button.Button;
import DesignPattern.Factory.Components.DropDown.AndroidDropDown;
import DesignPattern.Factory.Components.DropDown.DropDown;
import DesignPattern.Factory.Components.Menu.AndroidMenu;
import DesignPattern.Factory.Components.Menu.Menu;

public class AndroidUIFactory implements UIFactory{
    @Override
    public AndroidButton createButton() {
        return new AndroidButton();
    }

    @Override
    public AndroidMenu createMenu() {
        return new AndroidMenu();
    }

    @Override
    public AndroidDropDown createDropDown() {
        return new AndroidDropDown();
    }
}
