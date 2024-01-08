import java.awt.Color;

public class Devvr extends Cases {
    public Devvr() {
        super("Dev VR", VR.class, 300);
        setBase(40);
        setPlanification(180);
        setConception(300);
        setDevelopment(450);
        setTest(750);
        setDeployment(1400);
        setColor(Color.GREEN);
        setLevel(getBase(), getPlanification(), getConception(), getDevelopment(), getTest(), getDeployment());
        setDebt(getBase());
    }
}
