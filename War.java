
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
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
        Card topCard1;
        Card topCard2;
        int turns = 1;
        while (player1Deck.getDeckSize() > 0 && player2Deck.getDeckSize() > 0 && turns <= 300) {
            
            
            
        }
        
        
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
        
    }

}
