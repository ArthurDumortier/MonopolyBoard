import java.awt.Color;

public class Materiel extends Cases {
    public Materiel() {
        super("Materiel", IOT.class, 180);
        setBase(12);
        setPlanification(70);
        setConception(130);
        setDevelopment(280);
        setTest(480);
        setDeployment(750);
        setColor(Color.ORANGE);
        setLevel(getBase(), getPlanification(), getConception(), getDevelopment(), getTest(), getDeployment());
        setDebt(getBase());
    }
}
