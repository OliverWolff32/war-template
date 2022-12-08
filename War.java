
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    // need to write eventloop

    //top card is in index0; bottom is the last index

    Deck player1Deck;
    Deck player2Deck;
    Deck deck;
    Deck pot = new Deck();
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        // Initializations here...
        deck = new Deck();

        deck.initializeNewDeck();
        deck.shuffle();
        Deck[] twoDecks = deck.dealDeck();
        player1Deck = twoDecks[0];
        player2Deck = twoDecks[1];

        // ...then run the event loop
        this.runEventLoop(player1Deck, player2Deck);
    }
    
    public boolean winner() {
        if (player1Deck.getDeckSize() == 0 || player2Deck.getDeckSize() == 0) {
            return true; 
        }
        return false;
    }

    public void war(Card card1, Card card2, Deck player1Deck, Deck player2Deck, int lengthOfWar) {
        
        

        if (winner() == false && player1Deck.getDeckSize() >= lengthOfWar && player2Deck.getDeckSize() >= lengthOfWar) {
            // both players have enough
            System.out.println("Performing war with " + (lengthOfWar+1) + " cards. \n");
            pot.addCardToDeck(card1);
            pot.addCardToDeck(card2);
            
            
            for (int i = 0; i < (lengthOfWar-1); i++) {
                pot.addCardToDeck(player1Deck.dealCardFromDeck());
                pot.addCardToDeck(player2Deck.dealCardFromDeck());
            }

            card1 = player1Deck.dealCardFromDeck();
            card2 = player2Deck.dealCardFromDeck();
            
            System.out.println("Player 1's card is a " + card1.getFace() + " of " + card1.getSuit() + ". Player 2's card is a " + card2.getFace() + " of " + card2.getSuit());
            
            pot.addCardToDeck(card1);
            pot.addCardToDeck(card2);
            
            if (card1.getRank() > card2.getRank()) {
                int potSize = pot.getDeckSize();
                for (int i = 0; i < potSize; i++) {
                    player1Deck.addCardToBottomOfDeck(pot.dealCardFromDeck());
                }
                
                System.out.println("Player 1 wins the war and gets " + potSize + " cards.  \n\n");

            } else if (card1.getRank() < card2.getRank()) {
                int potSize = pot.getDeckSize();
                for (int i = 0; i < potSize; i++) {
                    player2Deck.addCardToBottomOfDeck(pot.dealCardFromDeck());
                }
                
                System.out.println("Player 2 wins the war and gets " + potSize + " cards. \n\n");
            } else { 
                war(card1, card2, player1Deck, player2Deck, 4);
            }

        
        
        } else if (winner() == false && player1Deck.getDeckSize() >= 4 && player2Deck.getDeckSize() < 4) {
            // player 1 has enough, player 2 doesn't
            war(card1, card2, player1Deck, player2Deck, player2Deck.getDeckSize());

        } else if (winner() == false && player2Deck.getDeckSize() >= 4 && player1Deck.getDeckSize() < 4) {
            // player 2 has enough, player 1 doesn't
            war(card1, card2, player1Deck, player2Deck, player1Deck.getDeckSize());

        } else if(winner() == false){
            // neither have enough
            if(player1Deck.getDeckSize() >= player2Deck.getDeckSize()) {
                war(card1, card2, player1Deck, player2Deck, player2Deck.getDeckSize());
                // player2 less cards
            } else {
                war(card1, card2, player1Deck, player2Deck, player1Deck.getDeckSize());
                // player1 less cards
            }
        }

    }

    

    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop(Deck player1Deck, Deck player2Deck) {
        Card card1;
        Card card2;

        int turns = 1;
        while (player1Deck.getDeckSize() > 0 && player2Deck.getDeckSize() > 0 && turns <= 300) {
            System.out.println("Turn: " + turns);
            System.out.println("Player 1 has " + player1Deck.getDeckSize() + " cards.");
            System.out.println("Player 2 has " + player2Deck.getDeckSize() + " cards.");
            
            card1 = player1Deck.dealCardFromDeck(); 
            card2 = player2Deck.dealCardFromDeck(); 
            
            System.out.println("Player 1 shows a " + card1.getFace() + " of " + card1.getSuit() +  ". Player 2 shows a " + card2.getFace() + " of " + card2.getSuit() + "\n");
                        
            if (card1.getRank() == card2.getRank()) {
                war(card1, card2, player1Deck, player2Deck, 4);
            } else if (card1.getRank() < card2.getRank()) {
                
                player2Deck.addCardToBottomOfDeck(card1);
                player2Deck.addCardToBottomOfDeck(card2);
                // player 2 wins battle
                System.out.println("Player 2 wins a battle with a " + card2.getFace() + " of " + card2.getSuit() + " to player 1's " + card1.getFace() + " of " + card1.getSuit());
            } else if (card1.getRank() > card2.getRank()) {
                player1Deck.addCardToBottomOfDeck(card2);
                player1Deck.addCardToBottomOfDeck(card1);
                //player 1 wins battle
                System.out.println("Player 1 wins the battle with a " + card1.getFace() + " to player 2's " + card2.getFace());
            }
            System.out.println("Player 1 has " + player1Deck.getDeckSize() + " cards.");
            System.out.println("Player 2 has " + player2Deck.getDeckSize() + " cards.");
            System.out.println("--------------------\n");
            turns++;
        }
        if (player1Deck.getDeckSize() == 0) {
            System.out.println("----------Player 1 wins!----------");
        } else if (player2Deck.getDeckSize() == 0) {
            System.out.println("----------Player 2 wins!----------");
        } else {
            System.out.println("----------Tie!----------");
        }

    }

    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();

    }

}
