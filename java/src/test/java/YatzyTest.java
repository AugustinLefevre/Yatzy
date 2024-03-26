import org.junit.*;

import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void givenSomeValue_whenChance_thenReturnTheSumOfAllGivenValues() {
        int expected = 15;
        int actual = Yatzy.chance(2,3,4,5,1);
        assertEquals(expected, actual);
        assertEquals(16, Yatzy.chance(3,3,4,5,1));
    }

    @Test public void givenFiveEqualsValue_whenYatzy_thenReturn50() {
        int expected = 50;
        int actual = Yatzy.yatzy(4,4,4,4,4);
        assertEquals(expected, actual);
        actual =  Yatzy.yatzy(6,6,6,6,6);
        assertEquals(expected, actual);
    }

    @Test public void givenFiveNonEqualsValue_whenYatzy_thenReturn0() {
        int expected = 0;
        int actual =  Yatzy.yatzy(6,6,6,6,3);
        assertEquals(expected, actual);
    }

    @Test public void test_ones() {
        assertEquals(1, Yatzy.ones(1, 2, 3, 4, 5));
        assertEquals(2, Yatzy.ones(1,2,1,4,5));
        assertEquals(0, Yatzy.ones(6,2,2,4,5));
        assertEquals(4, Yatzy.ones(1,2,1,1,1));
    }

    @Test
    public void test_twos() {
        assertEquals(4, Yatzy.twos(1,2,3,2,6));
        assertEquals(10, Yatzy.twos(2,2,2,2,2));
    }

    @Test
    public void test_threes() {
        assertEquals(6, Yatzy.threes(1,2,3,2,3));
        assertEquals(12, Yatzy.threes(2,3,3,3,3));
    }

    @Test
    public void test_fours()
    {
        assertEquals(12, new Yatzy(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy(4,5,5,5,5).fours());
    }

    @Test
    public void test_fives() {
        assertEquals(10, new Yatzy(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy(4,5,5,5,5).fives());
    }

    @Test
    public void test_sixes() {
        assertEquals(0, new Yatzy(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy(6,5,6,6,5).sixes());
    }

    @Test
    public void test_onePair() {
       assertEquals(6, Yatzy.scorePair(3,4,3,5,6));
       assertEquals(10, Yatzy.scorePair(5,3,3,3,5));
       assertEquals(12, Yatzy.scorePair(5,3,6,6,5));
    }

    @Test
    public void givenDistinctNumber_WhenScorePair_ThenReturn0() {
        int expected = 0;
        int actual = Yatzy.scorePair(1, 2, 3, 4, 5);
        assertEquals(expected, actual);
    }


    @Test
    public void test_twoPair() {
        assertEquals(16, Yatzy.twoPair(3,3,5,4,5));
        assertEquals(16, Yatzy.twoPair(3,3,5,5,5));
    }

    @Test
    public void givenDistinctNumber_WhenTwoPair_ThenReturn0() {
        int expected = 0;
        int actual = Yatzy.twoPair(1, 2, 3, 4, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void test_threeOfAKind()
    {
        assertEquals(9, Yatzy.threeOfAKind(3,3,3,4,5));
        assertEquals(15, Yatzy.threeOfAKind(5,3,5,4,5));
        assertEquals(9, Yatzy.threeOfAKind(3,3,3,3,5));
        assertEquals(9, Yatzy.threeOfAKind(3,3,3,2,4));
        assertEquals(9, Yatzy.threeOfAKind(3,3,3,3,3));
    }

    @Test
    public void test_fourOfAKind() {
        assertEquals(12, Yatzy.fourOfAKind(3,3,3,3,5));
        assertEquals(20, Yatzy.fourOfAKind(5,5,5,4,5));
    }

    @Test
    public void givenDistinctNumber_WhenFourOfAKind_ThenReturn0() {
        int expected = 0;
        int actual = Yatzy.fourOfAKind(1, 2, 3, 4, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void givenDistinctNumber_WhenThreeOfAKind_ThenReturn0() {
        int expected = 0;
        int actual = Yatzy.threeOfAKind(1, 2, 3, 4, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void test_smallStraight() {
        assertEquals(15, Yatzy.smallStraight(1,2,3,4,5));
        assertEquals(15, Yatzy.smallStraight(2,3,4,5,1));
        assertEquals(0, Yatzy.smallStraight(1,2,2,4,5));
    }

    @Test
    public void test_largeStraight() {
        assertEquals(20, Yatzy.largeStraight(6,2,3,4,5));
        assertEquals(20, Yatzy.largeStraight(2,3,4,5,6));
        assertEquals(0, Yatzy.largeStraight(1,2,2,4,5));
    }

    @Test
    public void test_fullHouse() {
        assertEquals(18, Yatzy.fullHouse(6,2,2,2,6));
        assertEquals(7, Yatzy.fullHouse(2,1,1,1,2));
        assertEquals(0, Yatzy.fullHouse(2,3,4,5,6));
    }
}
