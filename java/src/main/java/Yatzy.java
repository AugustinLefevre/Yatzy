import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Yatzy {
    protected int[] dices;

    public Yatzy(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        dices = new int[]{dice1, dice2, dice3, dice4, dice5};
    }

    @Deprecated
    public static int chance(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
       return yatzy.chance();
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
    private int calculateIntegerArrayTotal(int... dices)
    {
        return Arrays.stream(dices)
            .reduce(0, Integer::sum);
    }

    @Deprecated
    public static int yatzy(int... dices)
    {
        if(Arrays.stream(dices).distinct().count() == 1)
        {
            return 50;
        }
        return 0;
    }

    public int yatzy()
    {
        if(Arrays.stream(dices).distinct().count() == 1)
        {
            return 50;
        }
        return 0;
    }

    /**
     * Calculate th sum of a given value in a list of integer
     * @param dices the list of integer to check
     * @param value the searched value
     * @return the sum of the given value int the given list
     */
    private int calculateSumOfSearchedNumberInIntList(IntStream dices, int value) {
        return dices
            .filter(i -> i == value)
            .reduce(0, Integer::sum);
    }

    @Deprecated
    public static int ones(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        return yatzy.ones();
    }

    public int ones() {
        IntStream dices = IntStream.of(this.dices);
        return calculateSumOfSearchedNumberInIntList(dices, 1);
    }

    @Deprecated
    public static int twos(int dice1, int dice2, int dice3, int dice4, int dice5) {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        return yatzy.twos();
    }
    @Deprecated
    public int twos() {
        IntStream dices = IntStream.of(this.dices);
        return  calculateSumOfSearchedNumberInIntList(dices, 2);
    }
    @Deprecated
    public static int threes(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        return yatzy.threes();
    }
    public int threes()
    {
        IntStream dices = IntStream.of(this.dices);
        return  calculateSumOfSearchedNumberInIntList(dices, 3);
    }

    public int fours()
    {
        IntStream dices = IntStream.of(this.dices);
        return  calculateSumOfSearchedNumberInIntList(dices, 4);
    }

    public int fives()
    {
        IntStream dices = IntStream.of(this.dices);
        return  calculateSumOfSearchedNumberInIntList(dices, 5);
    }

    public int sixes()
    {
        IntStream dices = IntStream.of(this.dices);
        return  calculateSumOfSearchedNumberInIntList(dices, 6);
    }

    @Deprecated
    public static int scorePair(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        return yatzy.scorePair();
    }
    public int scorePair()
    {
        List<Integer> dices = IntStream.of(this.dices)
            .boxed()
            .collect(Collectors.toList());

        return dices.stream()
            .filter(i -> Collections.frequency(dices, i) > 1)
            .map(integer -> integer * 2)
            .max(Integer::compareTo)
            .orElse(0);
    }

    @Deprecated
    public static int twoPair(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        return yatzy.twoPair();
    }

    public int twoPair()
    {
        List<Integer> dices = IntStream.of(this.dices)
            .boxed()
            .collect(Collectors.toList());

        return dices.stream()
            .filter(i -> Collections.frequency(dices, i) >= 2)
            .distinct()
            .map(integer -> integer * 2)
            .reduce(0, Integer::sum);
    }

    @Deprecated
    public static int fourOfAKind(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        return yatzy.fourOfAKind();
    }
    public int fourOfAKind()
    {
        List<Integer> dices = IntStream.of(this.dices)
            .boxed()
            .collect(Collectors.toList());
        return dices.stream()
            .filter(i -> Collections.frequency(dices, i) >= 4)
            .map(integer -> integer * 4)
            .findFirst()
            .orElse(0);
    }

    @Deprecated
    public static int threeOfAKind(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        return yatzy.threeOfAKind();
    }
    public int threeOfAKind()
    {
        List<Integer> dices = IntStream.of(this.dices)
            .boxed()
            .collect(Collectors.toList());

        return dices.stream()
            .filter(i -> Collections.frequency(dices, i) >= 3)
            .map(integer -> integer * 3)
            .findFirst()
            .orElse(0);
    }

    @Deprecated
    public static int smallStraight(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        return yatzy.smallStraight();
    }
    public int smallStraight()
    {
        if(IntStream.of(dices).distinct().count() == 5 &&
            IntStream.of(dices).noneMatch(value -> value == 6)){
                return 15;
        }
        return 0;
    }


    @Deprecated
    public static int largeStraight(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        Yatzy yatzy = new Yatzy(dice1, dice2,dice3, dice4, dice5);
        return yatzy.largeStraight();
    }
    public int largeStraight()
    {
        if(IntStream.of(dices).distinct().count() == 5 &&
            IntStream.of(dices).noneMatch(value -> value == 1)){
            return 20;
        }
        return 0;
    }

    @Deprecated
    public static int fullHouse(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        return yatzy.fullHouse();
    }
    public int fullHouse()
    {
        List<Integer> dices = IntStream.of(this.dices)
            .boxed()
            .collect(Collectors.toList());

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



