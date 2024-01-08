import java.awt.Color;

public class Design extends Cases {
    public Design() {
        super("Design", Tkinter.class, 80);
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
