import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Yatzy {
    protected int[] dices;

    public Yatzy(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        dices = new int[]{dice1, dice2, dice3, dice4, dice5};
    }

    public void setDices(int[] dices){
        this.dices = dices;
    }

    @Deprecated
    public static int chance(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
       return calculateIntegerArrayTotal(dice1, dice2, dice3, dice4, dice5);
    }

    public int chance()
    {
        return calculateIntegerArrayTotal(dices);
    }

    /**
     * Calculate the total for a given integer list
     * @param dices a list of integer
     * @return the sum of the values given in the list
     */
    private static int calculateIntegerArrayTotal(int... dices) {
        return Arrays.stream(dices)
            .reduce(0, Integer::sum);
    }

    @Deprecated
    public static int yatzy(int... dices)
    {
        if(Arrays.stream(dices).distinct().count() == 1){
            return 50;
        }
        return 0;
    }

    public int yatzy()
    {
        if(Arrays.stream(dices).distinct().count() == 1){
            return 50;
        }
        return 0;
    }

    public static int ones(int dice1, int dice2, int dice3, int dice4, int dice5) {
        IntStream dices = getIntStream(dice1, dice2, dice3, dice4, dice5);
        return calculateSumOfSearchedNumberInIntList(dices, 1);
    }

    private static IntStream getIntStream(int... dices) {
        return Arrays.stream(dices);
    }

    /**
     * Calculate th sum of a given value in a list of integer
     * @param dices the list of integer to check
     * @param value the searched value
     * @return the sum of the given value int the given list
     */
    private static int calculateSumOfSearchedNumberInIntList(IntStream dices, int value) {
        return dices
            .filter(i -> i == value)
            .reduce(0, Integer::sum);
    }

    public static int twos(int dice1, int dice2, int dice3, int dice4, int dice5) {
        IntStream dices = getIntStream(dice1,dice2,dice3,dice4,dice5);
        return  calculateSumOfSearchedNumberInIntList(dices, 2);
    }
    public static int threes(int dice1, int dice2, int dice3, int dice4, int dice5) {
        IntStream dices = getIntStream(dice1,dice2,dice3,dice4,dice5);
        return  calculateSumOfSearchedNumberInIntList(dices, 3);
    }

    public int fours()
    {
        IntStream dices = getIntStream(this.dices);
        return  calculateSumOfSearchedNumberInIntList(dices, 4);
    }

    public int fives()
    {
        IntStream dices = getIntStream(this.dices);
        return  calculateSumOfSearchedNumberInIntList(dices, 5);
    }

    public int sixes()
    {
        IntStream dices = getIntStream(this.dices);
        return  calculateSumOfSearchedNumberInIntList(dices, 6);
    }

    public static int scorePair(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        List<Integer> dices = Arrays.asList(dice1, dice2, dice3, dice4, dice5);
        return dices.stream()
            .filter(i -> Collections.frequency(dices, i) > 1)
            .map(integer -> integer * 2)
            .max(Integer::compareTo)
            .orElse(0);
    }

    public static int twoPair(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        List<Integer> dices = Arrays.asList(dice1, dice2, dice3, dice4, dice5);
        return dices.stream()
            .filter(i -> Collections.frequency(dices, i) >= 2)
            .distinct()
            .map(integer -> integer * 2)
            .reduce(0, Integer::sum);
    }

    public static int fourOfAKind(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        List<Integer> dices = Arrays.asList(dice1, dice2, dice3, dice4, dice5);
        return dices.stream()
            .filter(i -> Collections.frequency(dices, i) >= 4)
            .map(integer -> integer * 4)
            .findFirst()
            .orElse(0);
    }

    public static int threeOfAKind(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        List<Integer> dices = Arrays.asList(dice1, dice2, dice3, dice4, dice5);
        return dices.stream()
            .filter(i -> Collections.frequency(dices, i) >= 3)
            .map(integer -> integer * 3)
            .findFirst()
            .orElse(0);
    }

    public static int smallStraight(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        List<Integer> dices = Arrays.asList(dice1, dice2, dice3, dice4, dice5);
        for(int i = 1; i < 6 ; i++){
            if(!dices.contains(i)){
                return 0;
            }
        }
        return 15;
    }

    public static int largeStraight(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        List<Integer> dices = Arrays.asList(dice1, dice2, dice3, dice4, dice5);
        for(int i = 2; i < 7 ; i++){
            if(!dices.contains(i)){
                return 0;
            }
        }
        return 20;
    }

    public static int fullHouse(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        List<Integer> dices = Arrays.asList(dice1, dice2, dice3, dice4, dice5);

        int twoOccurrenceSum = dices.stream()
            .filter(i -> Collections.frequency(dices, i) == 2)
            .map(integer -> integer * 2)
            .findFirst().orElse(0);

        int threeOccurrenceSum = dices.stream()
            .filter(i -> Collections.frequency(dices, i) == 3)
            .map(integer -> integer * 3)
            .findFirst().orElse(0);

        if(twoOccurrenceSum == 0 && threeOccurrenceSum == 0){
            return 0;
        }
        return twoOccurrenceSum + threeOccurrenceSum;
    }
}



