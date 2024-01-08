import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class DeckChance {
    private Queue<Chance> chanceCards;

    public DeckChance() {
        chanceCards = new LinkedList<>();
        chanceCards.add(new Chance("La banque s'est trompée et vous rembourse 100 Epicoins!", 1, this));
        chanceCards.add(new Chance("Avancer jusqu'à la case départ, vous recevez 200 Epicoins!", 2, this));
        chanceCards.add(new Chance("Rendez-vous à l'Avenue TkinterPython. Investissez 50 Epicoins dans le projet.", 3, this));
        chanceCards.add(new Chance("Avancez au Boulevard de VR. Investissez 60 Epicoins dans le projet.", 4, this));
        chanceCards.add(new Chance("Faites une pause et allez manger à la boulangerie. Payer 5 Epicoins", 5, this));
        chanceCards.add(new Chance("Vous avez passé la moulinette! Recevez 150 Epicoins!", 6, this));
        chanceCards.add(new Chance("C'est votre jour de chance! vous avez trouvé un billet de 50 Epicoins!", 7, this));
        chanceCards.add(new Chance("Reculez de trois cases", 8, this));
    }

    public void drawCard(Pions pion, List<Cases> tableau) {
        // Draw a random card and perform the action
        Chance drawnCard = chanceCards.poll();

        if (drawnCard != null) {
            drawnCard.performAction(pion, tableau);
        } else {
            System.out.println("No more chance cards in the deck.");
            refillDeck();
        }
    }

    private void refillDeck() {
        System.out.println("Refilling the Chance deck...");
        //initialize Chance cards as in the constructor
        List<Chance> tempList = new ArrayList<>(chanceCards);
        chanceCards.clear();
        Collections.shuffle(tempList);
        chanceCards.addAll(tempList);
    }

}
