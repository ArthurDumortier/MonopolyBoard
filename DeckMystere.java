import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class DeckMystere {
    private Queue<Mystere> mystereCards;

    public DeckMystere() {
        mystereCards = new LinkedList<>();
        mystereCards.add(new Mystere("Aller en prison. Rendez-vous directement en prison. Ne franchissez pas par la case départ, ne touchez pas Epicoins", 1, this));
        mystereCards.add(new Mystere("Amende pour excès de vitesse 200 Epicoins", 2, this));
        mystereCards.add(new Mystere("Amende pour ivresse 100Epicoins", 3, this));
        mystereCards.add(new Mystere("Suite à une attaque informatique, votre argent a été volé! Vous perdez 200 Epicoins", 4, this));
        mystereCards.add(new Mystere("C'est votre jour de chance ! Un investisseur vous paye 100 Epicoins pour expandir votre projects", 5, this));
        mystereCards.add(new Mystere("Le Kebab que tu a mangé chez Mister Kebab n'était pas en bon état. Mauvaise Décision! tu as perdu 8 Epicoins ", 6, this));
        mystereCards.add(new Mystere("Faites une pause et allez manger au Crous. Vous avez mangé deux fois plus ! donc vous payez le double! :)", 7, this));
        mystereCards.add(new Mystere("C'est ton anniversaire! Les joueurs vous donnent 50 Epicoins chacun", 8, this));
        mystereCards.add(new Mystere("Vous avez remporté un prix de l'innovation informatique! Vous obtenez 200 Epicoins", 9, this));
        
        
    }    


    public void drawCard(Pions pion, List<Cases> tableau) {
        // Draw a random card and perform the action
        Mystere drawnCard = mystereCards.poll();
    
        if (drawnCard != null) {
            drawnCard.performAction(pion, tableau);
        } else {
            System.out.println("No more mystere cards in the deck.");
            refillDeck();
        }
    }

  
    private void refillDeck() {
        System.out.println("Refilling the Mystere deck...");
        
        //initialize Chance cards as in the constructor
       
        //shuffle the recycled cards
        List<Mystere> tempList = new ArrayList<>(mystereCards);
        mystereCards.clear();
        Collections.shuffle(tempList);
        mystereCards.addAll(tempList);
    }
}
