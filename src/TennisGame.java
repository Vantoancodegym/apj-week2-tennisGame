public class TennisGame {
    final static int SCORE_ZERO=0;
    final static int SCORE_ONE=1;
    final static int SCORE_TWO=2;
    final static int SCORE_THREE=3;
    final static int SCORE_FOUR=4;

    public static String getScoreOfTheMatch(String firstPlayerName, String secondPlayerName, int firstPlayer_score, int secondPlayer_score) {
        String scoreOfTheMatch = "";
        final boolean isEqualPoint = firstPlayer_score == secondPlayer_score;
        if (isEqualPoint)
        {
            scoreOfTheMatch = getScoreSenceOne(firstPlayer_score);
        }
        else {
            boolean isPointLager = firstPlayer_score >= SCORE_FOUR || secondPlayer_score >= SCORE_FOUR;
            if (isPointLager)
            {
                scoreOfTheMatch = getScoreSenceTwo(firstPlayer_score, secondPlayer_score);
            }
            else
            {
                scoreOfTheMatch = getScoreSenceThree(firstPlayer_score, secondPlayer_score, scoreOfTheMatch);
            }
        }
        return scoreOfTheMatch;
    }

    public static String getScoreSenceThree(int firstPlayer_score, int secondPlayer_score, String scoreOfTheMatch) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = firstPlayer_score;
            else { scoreOfTheMatch +="-"; tempScore = secondPlayer_score;}
            switch(tempScore)
            {
                case 0:
                    scoreOfTheMatch +="Love";
                    break;
                case 1:
                    scoreOfTheMatch +="Fifteen";
                    break;
                case 2:
                    scoreOfTheMatch +="Thirty";
                    break;
                case 3:
                    scoreOfTheMatch +="Forty";
                    break;
            }
        }
        return scoreOfTheMatch;
    }

    public static String getScoreSenceTwo(int firstPlayer_score, int secondPlayer_score) {
        String scoreOfTheMatch;
        int minusResult = firstPlayer_score - secondPlayer_score;
        if (minusResult==1) scoreOfTheMatch ="Advantage player1";
        else if (minusResult ==-1) scoreOfTheMatch ="Advantage player2";
        else if (minusResult>=2) scoreOfTheMatch = "Win for player1";
        else scoreOfTheMatch ="Win for player2";
        return scoreOfTheMatch;
    }

    public static String getScoreSenceOne(int firstPlayer_score) {
        String scoreOfTheMatch;
        switch (firstPlayer_score)
        {
            case SCORE_ZERO:
                scoreOfTheMatch = "Love-All";
                break;
            case SCORE_ONE:
                scoreOfTheMatch = "Fifteen-All";
                break;
            case SCORE_TWO:
                scoreOfTheMatch = "Thirty-All";
                break;
            case SCORE_THREE:
                scoreOfTheMatch = "Forty-All";
                break;
            default:
                scoreOfTheMatch = "Deuce";
                break;

        }
        return scoreOfTheMatch;
    }
}
