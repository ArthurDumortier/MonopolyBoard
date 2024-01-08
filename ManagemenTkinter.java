import java.awt.Color;

public class ManagemenTkinter extends Cases {
    public ManagemenTkinter() {
        super("Management", Tkinter.class, 100);
        setBase(6);
        setPlanification(30);
        setConception(90);
        setDevelopment(200);
        setTest(350);
        setDeployment(500);
        setColor(Color.GRAY);
        setLevel(getBase(), getPlanification(), getConception(), getDevelopment(), getTest(), getDeployment());
        setDebt(getBase());
    }
}