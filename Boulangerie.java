import java.awt.Color;

public class Boulangerie extends Cases {
    public Boulangerie() {
        super("Boulangerie", FastFood.class, 200);
        setColor(Color.LIGHT_GRAY);
        setBase(20);
        setPlanification(100);
        setConception(300);
        setDevelopment(900);
        setTest(1600);
        setDeployment(2500);
        setLevel(getBase(), getPlanification(), getConception(), getDevelopment(), getTest(), getDeployment());
        setDebt(getBase());
    }
}
