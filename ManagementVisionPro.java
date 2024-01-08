import java.awt.Color;

public class ManagementVisionPro extends Cases {
    public ManagementVisionPro() {
        super("Management", VisionPro.class, 400);
        setBase(100);
        setPlanification(280);
        setConception(400);
        setDevelopment(650);
        setTest(950);
        setDeployment(1750);
        Color b = new Color(37, 149, 235);
        setColor(b);
        setLevel(getBase(), getPlanification(), getConception(), getDevelopment(), getTest(), getDeployment());
        setDebt(getBase());
    }
}
