public class CardsGame {

    private static final String cardRank= "123456789TJQK";
    private static int player1score;
    private static int player2score;
    private static char[] p1cards;
    private static char[] p2cards;
    private static int currentRound;
    private static int maxRounds;



    public static String score(char[] player1cards, char[] player2cards){
        initPlayersScoreMarkerAndCards(player1cards, player2cards);
        calculatePlayersScore();
        return gameScoreMarker();
    }

    private static void initPlayersScoreMarkerAndCards(char[] player1cards,char[] player2cards) {
        player1score=0; player2score=0;
        p1cards=player1cards; p2cards= player2cards;
        currentRound=0;
        maxRounds= p1cards.length;
    }

    private static void calculatePlayersScore() {
        while(currentRound++<maxRounds){
            if (currentRoundCardsAreTheSame()){
                drawRound();
            } else if (player1CurrentRoundCardRankIsBiggerThanPlayer2CurrentRoundCard()){
                player1WinsRound();
            } else{
                player2WinsRound();
            }
        }
    }

    private static String gameScoreMarker() {
        return player1score + "-" + player2score;
    }

    private static boolean currentRoundCardsAreTheSame() {
        return cardsAreTheSame(getPlayer1CurrentRoundCard(currentRound), getPlayer2CurrentRoundCard(currentRound));
    }

    private static char getPlayer2CurrentRoundCard(int currentRound) {
        return p2cards[currentRound-1];
    }

    private static char getPlayer1CurrentRoundCard(int currentRound) {
        return p1cards[currentRound-1];
    }

    private static void player2WinsRound() {
        player2score++;
    }

    private static void player1WinsRound() {
        player1score++;
    }

    private static void drawRound() {
        player1score++;
        player2score++;
    }

    private static boolean player1CurrentRoundCardRankIsBiggerThanPlayer2CurrentRoundCard() {
        return cardRank(getPlayer1CurrentRoundCard(currentRound)) > cardRank(getPlayer2CurrentRoundCard(currentRound));
    }

    private static int cardRank(char player1card) {
        return cardRank.indexOf(player1card);
    }

    private static boolean cardsAreTheSame(char player1card, char player2card) {
        return player1card == player2card;
    }
}
