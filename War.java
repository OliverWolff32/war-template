
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    // need to write eventloop
    
    
    
    
    
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
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
        Card Card1;
        Card Card2;
        int turns = 1;
        while (player1Deck.getDeckSize() > 0 && player2Deck.getDeckSize() > 0 && turns <= 300) {
            Card1 = player1Deck.dealCardFromDeck(); 
            Card2 = player2Deck.dealCardFromDeck(); 
            
            if (Card1.getRank() > Card2.getRank()) {
                player2Deck.addCardToDeck(Card1);
            } else if (Card1.getRank() == Card2.getRank()) {
                while(Card1.getRank() == Card2.getRank()) {
                    
                }
            } else {
                player1Deck.addCardToDeck(Card2);
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
