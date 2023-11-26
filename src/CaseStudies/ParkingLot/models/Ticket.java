package CaseStudies.ParkingLot.models;

import java.util.Date;

public class Ticket extends BaseModel{

    private String number;
    private Date entryTime;
    private Vehicle vehicle;
    private ParkingSpot assignedSlot;
    private Gate generatedAt;
    private Operator generatedBy;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getAssignedSlot() {
        return assignedSlot;
    }

    public void setAssignedSlot(ParkingSpot assignedSlot) {
        this.assignedSlot = assignedSlot;
    }

    public Gate getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Gate generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Operator getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }
}
