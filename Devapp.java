import java.awt.Color;

public class Devapp extends Cases {
    public Devapp() {
        super("Developpement applicatif", Java.class, 220);
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
