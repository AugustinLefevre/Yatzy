public class Yatzy {
    protected int[] dice;

    public Yatzy(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        dice = new int[5];
        dice[0] = dice1;
        dice[1] = dice2;
        dice[2] = dice3;
        dice[3] = dice4;
        dice[4] = dice5;
    }

    public static int chance(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        int total = 0;
        total += dice1;
        total += dice2;
        total += dice3;
        total += dice4;
        total += dice5;
        return total;
    }

    public static int yatzy(int... dice)
    {
        int[] counts = new int[6];
        for (int die : dice)
            counts[die-1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    public static int ones(int dice1, int dice2, int dice3, int dice4, int dice5) {
        int sum = 0;
        if (dice1 == 1) sum++;
        if (dice2 == 1) sum++;
        if (dice3 == 1) sum++;
        if (dice4 == 1) sum++;
        if (dice5 == 1) 
            sum++;

        return sum;
    }

    public static int twos(int dice1, int dice2, int dice3, int dice4, int dice5) {
        int sum = 0;
        if (dice1 == 2) sum += 2;
        if (dice2 == 2) sum += 2;
        if (dice3 == 2) sum += 2;
        if (dice4 == 2) sum += 2;
        if (dice5 == 2) sum += 2;
        return sum;
    }
    public static int threes(int dice1, int dice2, int dice3, int dice4, int dice5) {
        int s;    
        s = 0;
        if (dice1 == 3) s += 3;
        if (dice2 == 3) s += 3;
        if (dice3 == 3) s += 3;
        if (dice4 == 3) s += 3;
        if (dice5 == 3) s += 3;
        return s;
    }

    public int fours()
    {
        int sum;    
        sum = 0;
        for (int at = 0; at != 5; at++) {
            if (dice[at] == 4) {
                sum += 4;
            }
        }
        return sum;
    }

    public int fives()
    {
        int s = 0;
        int i;
        for (i = 0; i < dice.length; i++) 
            if (dice[i] == 5)
                s = s + 5;
        return s;
    }

    public int sixes()
    {
        int sum = 0;
        for (int at = 0; at < dice.length; at++) 
            if (dice[at] == 6)
                sum = sum + 6;
        return sum;
    }

    public static int scorePair(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        int[] counts = new int[6];
        counts[dice1-1]++;
        counts[dice2-1]++;
        counts[dice3-1]++;
        counts[dice4-1]++;
        counts[dice5-1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6-at-1] >= 2)
                return (6-at)*2;
        return 0;
    }

    public static int twoPair(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        int[] counts = new int[6];
        counts[dice1-1]++;
        counts[dice2-1]++;
        counts[dice3-1]++;
        counts[dice4-1]++;
        counts[dice5-1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }        
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int fourOfAKind(int _1, int _2, int dice3, int dice4, int dice5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[_1-1]++;
        tallies[_2-1]++;
        tallies[dice3-1]++;
        tallies[dice4-1]++;
        tallies[dice5-1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int threeOfAKind(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        int[] t;
        t = new int[6];
        t[dice1-1]++;
        t[dice2-1]++;
        t[dice3-1]++;
        t[dice4-1]++;
        t[dice5-1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public static int smallStraight(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[dice1-1] += 1;
        tallies[dice2-1] += 1;
        tallies[dice3-1] += 1;
        tallies[dice4-1] += 1;
        tallies[dice5-1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[dice1-1] += 1;
        tallies[dice2-1] += 1;
        tallies[dice3-1] += 1;
        tallies[dice4-1] += 1;
        tallies[dice5-1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[dice1-1] += 1;
        tallies[dice2-1] += 1;
        tallies[dice3-1] += 1;
        tallies[dice4-1] += 1;
        tallies[dice5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



