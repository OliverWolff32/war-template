
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
        this.runEventLoop();
    }
    
    public void war(Card card1, Card card2) {
        Deck war1 = new Deck();
        Deck war2 = new Deck();
        
        while(card1.getRank() == card2.getRank()) {
            if (player1Deck.getDeckSize() >= 4) {
                 if(player2Deck.getDeckSize() >= 4) {
                      // both players have enough cards
                     
                      for (int i = 0; i < 3; i++) {
                           war1.addCardToDeck(player1Deck.dealCardFromDeck());
                           war2.addCardToDeck(player2Deck.dealCardFromDeck());
                      }
                      card1 = player1Deck.dealCardFromDeck();
                      card2 = player2Deck.dealCardFromDeck();
                      if (card1.getRank() > card2.getRank()) {
                          for (int i = 0; i < war1.getDeckSize(); i++) {
                              player1Deck.addCardToBottomOfDeck(war1.dealCardFromDeck());
                              player1Deck.addCardToBottomOfDeck(war2.dealCardFromDeck());
                          }
                      } else 
                      if (card1.getRank() < card2.getRank()) {
                          for (int i = 0; i < war1.getDeckSize(); i++) {
                              player2Deck.addCardToBottomOfDeck(war1.dealCardFromDeck());
                              player2Deck.addCardToBottomOfDeck(war2.dealCardFromDeck());
                          }
                      } 
                 }
                 //player 1 has enough cards, player 2 doesn't
                
                 
            }
            //neither have enough
        }
    }
    
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
        Card card1;
        Card card2;
        
        int turns = 1;
        while (player1Deck.getDeckSize() > 0 && player2Deck.getDeckSize() > 0 && turns <= 300) {
            card1 = player1Deck.dealCardFromDeck(); 
            card2 = player2Deck.dealCardFromDeck(); 
            
            if (card1.getRank() < card2.getRank()) {
                player2Deck.addCardToBottomOfDeck(card1);
                // player 2 wins war
            } else if (card1.getRank() == card2.getRank()) {
                // war occurs 
                war(card1, card2);
                
            } else if (card1.getRank() > card2.getRank()) {
                player1Deck.addCardToBottomOfDeck(card2);
                //player 1 wins war
            }            
        }
        
        
    }
    
    
    
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
        
    }

}
