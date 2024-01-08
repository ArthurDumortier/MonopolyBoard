import java.awt.Color;

public class Devia extends Cases {
    public Devia() {
        super("Dev d'IA", IA.class, 260);
        setBase(33);
        setPlanification(140);
        setConception(250);
        setDevelopment(410);
        setTest(650);
        setDeployment(1150);
        setColor(Color.YELLOW);
        setLevel(getBase(), getPlanification(), getConception(), getDevelopment(), getTest(), getDeployment());
        setDebt(getBase());
    }
}
