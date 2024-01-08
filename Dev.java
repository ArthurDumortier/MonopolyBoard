import java.awt.Color;

public class Dev extends Cases {
    public Dev() {
        super("Dev", VisionPro.class, 350);
        setBase(80);
        setPlanification(250);
        setConception(380);
        setDevelopment(600);
        setTest(900);
        setDeployment(1550);
        Color b = new Color(37, 149, 235);
        setColor(b);
        setLevel(getBase(), getPlanification(), getConception(), getDevelopment(), getTest(), getDeployment());
        setDebt(getBase());
    }
}
