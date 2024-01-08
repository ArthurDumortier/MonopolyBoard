import java.util.List;
import javax.swing.JOptionPane;

public class Chance {
    private String description;
    private int id;
    private DeckChance deckChance;

    public Chance(String description, int id, DeckChance deckChance) {
        this.description = description;
        this.id = id;
        this.deckChance = deckChance;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void performAction(Pions pion, List<Cases> tableau) {
        switch (id) {
            case 1:
                // "get 150 epiCoins from the bank"
                pion.getMoney(150);
                showMessage("CARTE CHANCE", "" + description + "\n");
                break;

            case 2:
                // "move to case depart"
                Plateau.removePionFromPanel(pion);
                pion.moveTo(10, 10);
                pion.getMoney(200);
                showMessage("CARTE CHANCE", "" + description + "\n");
                break;

            case 3:
                // "Move to Tkinter"
                Plateau.removePionFromPanel(pion);
                pion.moveTo(10, 1);
                pion.payDebt(50);
                showMessage("CARTE CHANCE", "" + description + "\n");
                break;

            case 4:

                // "Move to the Boulevard de VR"
                Plateau.removePionFromPanel(pion);
                pion.moveTo(1, 10);
                pion.payDebt(60);
                showMessage("CARTE CHANCE", "" + description + "\n");
                break;

            case 5:
                // manger à la boulangerie
                Plateau.removePionFromPanel(pion);
                pion.moveTo(5, 10);
                pion.payDebt(5);
                showMessage("CARTE CHANCE", "" + description + "\n");
                break;

            case 6:
                // la moulinette
                pion.getMoney(150);
                showMessage("CARTE CHANCE", "" + description + "\n");
                break;

            case 7:
                // votre jour de chance
                pion.getMoney(50);
                showMessage("CARTE CHANCE", "" + description + "\n");
                break;

            case 8:
                // Reculez de trois cases
                Plateau.removePionFromPanel(pion);
                pion.moveTo(pion.getX() - 3, pion.getY() - 3);
                showMessage("CARTE CHANCE", "" + description + "\n");
                break;
            default:
                System.out.println("Unhandled Chance card action with id: " + id);
        }
    }

    // display a dialog box
    private void showMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private void moveToNearestUnownedProperty(Pions pion, List<Cases> gameBoard) {
        // move to the nearest unowned property and buying it
        Cases nearestUnownedProperty = findNearestUnownedProperty(gameBoard, pion.getX(), pion.getY());

        if (nearestUnownedProperty != null) {
            // pion.moveToSpecificCase(nearestUnownedProperty);
            System.out.println("In Progress");
        } else {
            System.out.println("No unowned properties nearby.");
        }
    }

    private Cases findNearestUnownedProperty(List<Cases> gameBoard, int currentPlayerX, int currentPlayerY) {
        return null;
    }
}