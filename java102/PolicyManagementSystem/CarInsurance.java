package java102.PolicyManagementSystem;

import java.util.Date;

public class CarInsurance extends Insurance{
    public CarInsurance(String insuranceType) {
        super("Araba sigortası", new Date(), new Date());
        calculate(insuranceType);
    }

    @Override
    public void calculate(String insuranceType) {
        double price=999;
        if(insuranceType.equals("Individual"))
        {
            setPrice(price);
        }
        if(insuranceType.equals("Enterprise")){
            setPrice(price*0.9);
        }
    }
}