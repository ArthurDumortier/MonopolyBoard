import java.awt.Color;

public class ManagementJava extends Cases {
    public ManagementJava() {
        super("Management", Java.class, 240);
        setBase(30);
        setPlanification(130);
        setConception(220);
        setDevelopment(390);
        setTest(600);
        setDeployment(1100);
        setColor(Color.RED);
        setLevel(getBase(), getPlanification(), getConception(), getDevelopment(), getTest(), getDeployment());
        setDebt(getBase());
    }
}