import java.util.Arrays;
import java.util.List;

public class Yatzy {
    protected int[] dice;

    public Yatzy(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        dice = new int[]{dice1, dice2, dice3, dice4, dice5};
    }

    public static int chance(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
       return calulateIntegerListTotal(Arrays.asList(dice1, dice2, dice3, dice4, dice5));
    }

    /**
     * Calculate the total for a given integer list
     * @param dices a list of integer
     * @return the sum of the values given in the list
     */
    private static int calulateIntegerListTotal(List<Integer> dices) {
        return dices.stream().reduce(0, Integer::sum);
    }

    public static int yatzy(int... dices)
    {
        int[] counts = new int[6];
        for (int dice : dices){
            counts[dice-1]++;
        }
        if(intArrayContains(counts, 5)){
            return 50;
        }
        return 0;
    }

    /**
     * Verify if an array of integer contains a given value
     * @param intArray the array to be checked
     * @param value the value to look for
     * @return true if the value is present in the array
     */
    private static boolean intArrayContains(int[] intArray, int value) {
        return Arrays.stream(intArray).anyMatch(v -> v == value);
    }

    public static int ones(int dice1, int dice2, int dice3, int dice4, int dice5) {
        List<Integer> dices = Arrays.asList(dice1,dice2,dice3,dice4,dice5);
        return countNumberOfOccurrenceInIntList(dices, 1);
    }

    /**
     * Count the presence of a given value in a list of integer
     * @param dices the list of integer to check
     * @param value the searched value
     * @return the number of occurrence of the given value int the given list
     */
    private static int countNumberOfOccurrenceInIntList(List<Integer> dices, int value) {
        return (int)dices.stream().filter(i -> i == value).count();
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



