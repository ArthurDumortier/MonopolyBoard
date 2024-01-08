import java.awt.Color;

public class ManagementIot extends Cases {
    public ManagementIot() {
        super("Management", IOT.class, 200);
        setBase(15);
        setPlanification(80);
        setConception(150);
        setDevelopment(300);
        setTest(500);
        setDeployment(850);
        setColor(Color.ORANGE);
        setLevel(getBase(), getPlanification(), getConception(), getDevelopment(), getTest(), getDeployment());
        setDebt(getBase());
    }
}
