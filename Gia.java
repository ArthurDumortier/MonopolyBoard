import java.awt.Color;

public class Gia extends Cases {
    public Gia() {
        super("GIA", Cybersecurite.class, 140);
        setBase(9);
        setPlanification(50);
        setConception(100);
        setDevelopment(230);
        setTest(400);
        setDeployment(600);
        setColor(Color.PINK);
        setLevel(getBase(), getPlanification(), getConception(), getDevelopment(), getTest(), getDeployment());
        setDebt(getBase());
    }
}
