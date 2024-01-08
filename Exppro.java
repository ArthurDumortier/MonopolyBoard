import java.awt.Color;

public class Exppro extends Cases {
    public Exppro() {
        super("Exp et pro", VR.class, 300);
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
