package DesignPattern.Factory;

import DesignPattern.Factory.Components.Button.Button;
import DesignPattern.Factory.Components.DropDown.DropDown;
import DesignPattern.Factory.Components.Menu.Menu;

public interface UIFactory {

    Button createButton(); // query
    Menu createMenu();
    DropDown createDropDown();
}
