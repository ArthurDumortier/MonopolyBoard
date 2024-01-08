import java.awt.Color;

public class Loco extends Cases {
    public Loco() {
        super("Logiciel et connectivité", IOT.class, 180);
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
