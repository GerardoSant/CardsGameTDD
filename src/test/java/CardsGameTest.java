import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardsGameTest {

    @Test
    public void cards_1_0_score_1_0() {
        assertThat(CardsGame.score(new char[]{'1'}, new char[]{'0'})).isEqualTo("1-0");
    }

    @Test
    public void cards_0_1_score_0_1() {
        assertThat(CardsGame.score(new char[]{'0'}, new char[]{'1'})).isEqualTo("0-1");
    }

    @Test
    public void cards_0_0_score_1_1() {
        assertThat(CardsGame.score(new char[]{'0'}, new char[]{'0'})).isEqualTo("1-1");
    }

    @Test
    public void cards_1_1_score_1_1() {
        assertThat(CardsGame.score(new char[]{'1'}, new char[]{'1'})).isEqualTo("1-1");
    }

    @Test
    public void cards_2_1_score_1_0() {
        assertThat(CardsGame.score(new char[]{'2'}, new char[]{'1'})).isEqualTo("1-0");
    }

    @Test
    public void cards_1_2_score_0_1() {
        assertThat(CardsGame.score(new char[]{'1'}, new char[]{'2'})).isEqualTo("0-1");
    }

    @Test
    public void cards_T_J_score_0_1() {
        assertThat(CardsGame.score(new char[]{'T'}, new char[]{'J'})).isEqualTo("0-1");
    }


    @Test
    public void cards_11_00_score_2_0(){
        assertThat(CardsGame.score(new char[]{'1','1'}, new char[]{'0','0'})).isEqualTo("2-0");
    }

    @Test
    public void cards_1T5_3Q2_score_1_2(){
        assertThat(CardsGame.score(new char[]{'1','T','5'}, new char[]{'3','Q','2'})).isEqualTo("1-2");
    }




}
