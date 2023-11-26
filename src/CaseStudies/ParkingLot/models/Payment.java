package CaseStudies.ParkingLot.models;

import java.util.Date;

public class Payment extends BaseModel {
    private PaymentStatus paymentStatus;
    private int amount;
    private Date time;
    private PaymentMode paymentMode;
    private String refNumber;
}
