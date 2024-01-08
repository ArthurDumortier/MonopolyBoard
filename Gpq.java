import java.awt.Color;

public class Gpq extends Cases {
    public Gpq() {
        super("Gestion Projet Qualité", Java.class, 220);
        setBase(20);
        setPlanification(100);
        setConception(190);
        setDevelopment(340);
        setTest(550);
        setDeployment(900);
        setColor(Color.RED);
        setLevel(getBase(), getPlanification(), getConception(), getDevelopment(), getTest(), getDeployment());
        setDebt(getBase());
    }
}
