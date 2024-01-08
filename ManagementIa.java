import java.awt.Color;

public class ManagementIa extends Cases {
    public ManagementIa() {
        super("Management", IA.class, 280);
        setBase(40);
        setPlanification(150);
        setConception(270);
        setDevelopment(450);
        setTest(680);
        setDeployment(1250);
        setColor(Color.YELLOW);
        setLevel(getBase(), getPlanification(), getConception(), getDevelopment(), getTest(), getDeployment());
        setDebt(getBase());
    }
}
