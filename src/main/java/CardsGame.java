public class CardsGame {

    private static final String cardRank= "123456789TJQK";
    private static int player1score;
    private static int player2score;
    private static char[] p1cards;
    private static char[] p2cards;
    private static int pendingRounds;



    public static String score(char[] player1cards, char[] player2cards){
        setPlayersScoreMarkerAndCards(player1cards, player2cards);
        calculatePlayersScore();
        return gameScoreMarker();
    }

    private static void setPlayersScoreMarkerAndCards(char[] player1cards,char[] player2cards) {
        player1score=0; player2score=0;
        p1cards=player1cards;
        p2cards= player2cards;
        pendingRounds=p1cards.length;
    }

    private static void calculatePlayersScore() {
        while(pendingRounds-->0){
            if (cardsAreTheSame(getPlayer1CurrentRoundCard(pendingRounds), getPlayer2CurrentRoundCard(pendingRounds))){
                drawRound();
            } else if (player1CardRankIsBiggerThanPlayer2Card(getPlayer1CurrentRoundCard(pendingRounds), getPlayer2CurrentRoundCard(pendingRounds))){
                player1WinsRound();
            } else{
                player2WinsRound();
            }
        }
    }

    private static char getPlayer2CurrentRoundCard(int round) {
        return p2cards[round];
    }

    private static char getPlayer1CurrentRoundCard(int round) {
        return p1cards[round];
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

    private static String gameScoreMarker() {
        return player1score + "-" + player2score;
    }


    private static int numberOfCards(char[] player1cards) {
        return player1cards.length;
    }

    private static boolean player1CardRankIsBiggerThanPlayer2Card(char player1card, char player2card) {
        return cardRank(player1card) > cardRank(player2card);
    }

    private static int cardRank(char player1card) {
        return cardRank.indexOf(player1card);
    }

    private static boolean cardsAreTheSame(char player1card, char player2card) {
        return player1card == player2card;
    }
}
