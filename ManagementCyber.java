import java.awt.Color;

public class ManagementCyber extends Cases {
    public ManagementCyber() {
        super("Management", Cybersecurite.class, 160);
        setBase(10);
        setPlanification(60);
        setConception(120);
        setDevelopment(250);
        setTest(450);
        setDeployment(650);
        setColor(Color.PINK);
        setLevel(getBase(), getPlanification(), getConception(), getDevelopment(), getTest(), getDeployment());
        setDebt(getBase());
    }
}
