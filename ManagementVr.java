import java.awt.Color;

public class ManagementVr extends Cases {
    public ManagementVr() {
        super("Management", VR.class, 320);
        setBase(60);
        setPlanification(200);
        setConception(350);
        setDevelopment(550);
        setTest(850);
        setDeployment(1500);
        setColor(Color.GREEN);
        setLevel(getBase(), getPlanification(), getConception(), getDevelopment(), getTest(), getDeployment());
        setDebt(getBase());
    }
}
