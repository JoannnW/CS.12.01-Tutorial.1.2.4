public class WordMatch {
    private String secret;

    public WordMatch(String secret) {
        this.secret=secret;
    }

    public int scoreGuess(String guess){
        int score = 0;
        int occurences = 0;
        int guessLength = guess.length();

        if (guess.isEmpty()){
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }
        if (guessLength>secret.length()){
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        }

        for (int i = 0; i < secret.length() - guessLength + 1; i++){
            if (secret.substring(i,i+guessLength).equals(guess)){
                occurences +=1;
            }
        }
        score = occurences * guessLength * guessLength;
        return score;
    }

    public String findBetterGuess(String guess1, String guess2){
        String str;
        int guess1Score = scoreGuess(guess1);
        int guess2Score = scoreGuess(guess2);
        if (guess1Score >= guess2Score){
            str = guess1;
        }else{
            str = guess2;
        }
        return str;
    }
}
