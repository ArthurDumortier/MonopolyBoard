import java.awt.Color;

public class Frontend extends Cases {
    public Frontend() {
        super("front-end", TWeb.class, 60);
        setBase(2);
        setPlanification(10);
        setConception(30);
        setDevelopment(90);
        setTest(160);
        setDeployment(250);
        setColor(Color.MAGENTA);
        setLevel(getBase(), getPlanification(), getConception(), getDevelopment(), getTest(), getDeployment());
        setDebt(getBase());
    }
}
