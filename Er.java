import java.awt.Color;

public class Er extends Cases {
    public Er() {
        super("Expérimentation et Recherche", IA.class, 260);
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
