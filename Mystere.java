import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Mystere {
    private String description;
    private int id;
    private DeckMystere deckMystere;

    public Mystere(String description, int id, DeckMystere deckMystere) {
        this.description = description;
        this.id = id;
        this.deckMystere = deckMystere;
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
                // go prison
                pion.moveToPrison(pion);
                showMessage("CARTE MYSTERE", "" + description + "\n");
                break;

            case 2:
                // "excès de vitesse"
                pion.payDebt(200);
                showMessage("CARTE MYSTERE", "" + description + "\n");
                break;

            case 3:
                // Amende pour ivresse
                pion.payDebt(100);
                showMessage("CARTE MYSTERE", "" + description + "\n");
                break;

            case 4:
                // attaque informatique
                pion.payDebt(200);
                showMessage("CARTE MYSTERE", "" + description + "\n");
                break;

            case 5:
                // "investisseur"
                pion.getMoney(200);
                showMessage("CARTE MYSTERE", "" + description + "\n");
                break;

            case 6:
                // Kebab
                Plateau.removePionFromPanel(pion);
                pion.moveTo(10, 5);
                pion.payDebt(8);
                showMessage("CARTE MYSTERE", "" + description + "\n");
                break;

            case 7:
                // Crous
                Plateau.removePionFromPanel(pion);
                pion.moveTo(5, 0);
                // if to add
                pion.getMoney(100);
                showMessage("CARTE MYSTERE", "" + description + "\n");
                break;

            case 8:
                // anniversaire
                showMessage("CARTE MYSTERE", "" + description + "\n");
                // Player receives 50 Ephicoins from each other player
                int amountPerPlayer = 50;
                for (Pions otherPlayer : Plateau.pions) {
                    if (otherPlayer != pion) {
                        pion.payOtherPlayer(amountPerPlayer, otherPlayer);
                    }
                }
                break;

            case 9:
                // innovation informatique!
                pion.getMoney(200);
                showMessage("CARTE MYSTERE", "" + description + "\n");
                break;

            default:
                System.out.println("Unhandled Chance card action with id: " + id);
        }
    }

    // Add this method to display a dialog box
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