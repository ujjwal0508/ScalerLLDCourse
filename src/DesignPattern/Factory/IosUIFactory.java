package DesignPattern.Factory;

import DesignPattern.Factory.Components.Button.Button;
import DesignPattern.Factory.Components.Button.IosButton;
import DesignPattern.Factory.Components.DropDown.DropDown;
import DesignPattern.Factory.Components.DropDown.IosDropDown;
import DesignPattern.Factory.Components.Menu.IosMenu;
import DesignPattern.Factory.Components.Menu.Menu;

public class IosUIFactory implements UIFactory{

    @Override
    public IosButton createButton() {
        return new IosButton();
    }

    @Override
    public IosMenu createMenu() {
        return new IosMenu();
    }

    @Override
    public IosDropDown createDropDown() {
        return new IosDropDown();
    }
}
