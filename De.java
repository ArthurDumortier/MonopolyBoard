import java.util.Random;

import javax.swing.JOptionPane;

public class De {

    private int de1;
    private int de2;
    private boolean double1;

    public int getValue() {
        return de1 + de2;
    }

    public boolean isDouble() {
        return double1;
    }

    public void setDouble1(boolean double1) {
        this.double1 = double1;
    }

    // méthode qui lance les dés et renvoie la somme des deux dés lancés et dit si
    // il y a un double
    public int throwDe() {
        Random random = new Random();

        // Génère un nombre aléatoire entre 1 et 6
        // de1 = random.nextInt(6) + 1;
        // de2 = random.nextInt(6) + 1;
        de1 = 1;
        de2 = 4;
        setDouble1(false);
        if (de1 == de2) {
            System.out.println("Double ! Vous pouvez rejouer !");
            JOptionPane.showMessageDialog(null, "Double ! Vous pouvez rejouer.", "Double !",
                    JOptionPane.INFORMATION_MESSAGE);
            setDouble1(true);
            return de1 + de2;
        }
        return de1 + de2;
    }
}
