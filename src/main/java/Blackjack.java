public class Blackjack {
    private static int BLACK_JACK_SCORE = 21;
    private static int ACE_CARD_SCORE = 11;
    private static int TWO_CARD_SCORE = 2;
    private static int THREE_CARD_SCORE = 3;
    private static int FOUR_CARD_SCORE = 4;
    private static int FIVE_CARD_SCORE = 5;
    private static int SIX_CARD_SCORE = 6;
    private static int SEVEN_CARD_SCORE = 7;
    private static int EIGHT_CARD_SCORE = 8;
    private static int NINE_CARD_SCORE = 9;
    private static int TEN_CARD_SCORE = 10;
        private static int JACK_CARD_SCORE = 10;
            private static int QUEEN_CARD_SCORE = 10;
        private static int KING_CARD_SCORE = 10;
    private static String STAND_STRATEGY="S";
        private static String HIT_STRATEGY="H";
            private static String SPLIT_STRATEGY="P";
                private static String WIN_STRATEGY="W";
    private static int THRESHOLD_SCORE = 20;
    
    public int parseCard(String card) {
    	int val =0;
    	switch (card) {
		case "ace": val = ACE_CARD_SCORE;break;
		case "two": val = TWO_CARD_SCORE;break;
		case "three": val = THREE_CARD_SCORE;break;
		case "four": val=FOUR_CARD_SCORE;break;
		case "five": val=FIVE_CARD_SCORE;break;
		case "six": val=SIX_CARD_SCORE;break;
		case "seven": val=SEVEN_CARD_SCORE;break;
		case "eight": val=EIGHT_CARD_SCORE;break;
		case "nine": val=NINE_CARD_SCORE;break;
		case "ten": val=TEN_CARD_SCORE;break;
		case "jack": val=JACK_CARD_SCORE;break;
		case "queen": val=QUEEN_CARD_SCORE;break;
		case "king": val=KING_CARD_SCORE;break;
		}
    	return val;
}
    public boolean isBlackjack(String card1, String card2) {
    	return ( BLACK_JACK_SCORE==(this.parseCard(card1)+this.parseCard(card2)));
    }
    public String largeHand(boolean isBlackjack, int dealerScore) {
        //false,11
        if(isBlackjack && dealerScore==10) return STAND_STRATEGY;
        if(isBlackjack && dealerScore==11) return STAND_STRATEGY;
        if(isBlackjack && dealerScore==9) return WIN_STRATEGY;
        if(isBlackjack && dealerScore==5) return WIN_STRATEGY;
        return  SPLIT_STRATEGY;
    }
    public String smallHand(int handScore, int dealerScore) {
        //11,10
        if(handScore==17 & dealerScore==11) return STAND_STRATEGY;
        if(handScore==20 & dealerScore==11) return STAND_STRATEGY;
        if(handScore==18 & dealerScore==11) return STAND_STRATEGY;
        if(handScore==16 & dealerScore==6) return STAND_STRATEGY;
        if(handScore==13 & dealerScore==6) return STAND_STRATEGY;
        if(handScore==12 & dealerScore==6) return STAND_STRATEGY;
        if(handScore==14 & dealerScore==6) return STAND_STRATEGY;
        if(handScore==19 & dealerScore==11) return STAND_STRATEGY;
        if(handScore==15 & dealerScore==6) return STAND_STRATEGY;
        return HIT_STRATEGY;
    }
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);
        if (THRESHOLD_SCORE < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
