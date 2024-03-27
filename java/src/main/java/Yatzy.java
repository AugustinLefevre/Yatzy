import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Yatzy {
    protected int[] dices;

    public Yatzy(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        Arrays.asList(dice1, dice2, dice3, dice4, dice5)
            .stream()
            .forEach(integer -> {
                if (integer < 1 || integer > 6) {
                    throw new IllegalArgumentException("Dices values are not available");
                }
            });

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
        return IntStream.of(dices)
            .sum();
    }

    @Deprecated
    public static int yatzy(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        return yatzy.yatzy();
    }

    public int yatzy()
    {
        if (Arrays.stream(dices)
            .distinct()
            .count() == 1) {
            return 50;
        }
        return 0;
    }

    @Deprecated
    public static int ones(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        return yatzy.ones();
    }

    public int ones()
    {
        return IntStream.of(this.dices)
            .filter(value -> value == 1)
            .sum();
    }

    @Deprecated
    public static int twos(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        return yatzy.twos();
    }

    public int twos()
    {
        return IntStream.of(this.dices)
            .filter(value -> value == 2)
            .sum();
    }

    @Deprecated
    public static int threes(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        return yatzy.threes();
    }

    public int threes()
    {
        return IntStream.of(this.dices)
            .filter(value -> value == 3)
            .sum();
    }

    public int fours()
    {
        return IntStream.of(this.dices)
            .filter(value -> value == 4)
            .sum();
    }

    public int fives()
    {
        return IntStream.of(this.dices)
            .filter(value -> value == 5)
            .sum();
    }

    public int sixes()
    {
        return IntStream.of(this.dices)
            .filter(value -> value == 6)
            .sum();
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
        if (IntStream.of(dices)
            .distinct()
            .count() == 5 && IntStream.of(dices)
            .noneMatch(value -> value == 6)) {
            return 15;
        }
        return 0;
    }


    @Deprecated
    public static int largeStraight(int dice1, int dice2, int dice3, int dice4, int dice5)
    {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        return yatzy.largeStraight();
    }

    public int largeStraight()
    {
        if (IntStream.of(dices)
            .distinct()
            .count() == 5 && IntStream.of(dices)
            .noneMatch(value -> value == 1)) {
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
            .findFirst()
            .orElse(0);

        int threeOccurrenceSum = dices.stream()
            .filter(i -> Collections.frequency(dices, i) == 3)
            .map(integer -> integer * 3)
            .findFirst()
            .orElse(0);

        if (twoOccurrenceSum == 0 && threeOccurrenceSum == 0) {
            return 0;
        }
        return twoOccurrenceSum + threeOccurrenceSum;
    }
}



