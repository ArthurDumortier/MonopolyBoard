import java.awt.Color;

public class Algorithme extends Cases {
    public Algorithme() {
        super("Algorithme", Tkinter.class, 90);
        setBase(4);
        setPlanification(20);
        setConception(60);
        setDevelopment(180);
        setTest(320);
        setDeployment(450);
        setColor(Color.GRAY);
        setLevel(getBase(), getPlanification(), getConception(), getDevelopment(), getTest(), getDeployment());
        setDebt(getBase());
    }
}
