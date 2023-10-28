package DesignPattern.decorator;

public class OrangeCone implements IceCreamConeConstituents {

    OrangeCone(){}

    @Override
    public String getDescription() {
        return "Orange Cone";
    }

    @Override
    public int getCost() {
        return 20;
    }

    public void setVitaminCLevel(int newLevel) {}
}
