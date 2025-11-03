package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Rank;

public class RankTest {

	@DisplayName("6개 일치 시 1등을 반환한다.")
    @Test
    void Rank_1등_테스트() {
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개 + 보너스 일치 시 2등을 반환한다.")
    @Test
    void Rank_2등_테스트() {
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개 일치 시 3등을 반환한다.")
    @Test
    void Rank_3등_테스트() {
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("3개 미만 일치 시 MISS를 반환한다.")
    @Test
    void Rank_MISS_테스트() {
        assertThat(Rank.of(2, false)).isEqualTo(Rank.MISS);
    }

    @DisplayName("각 Rank의 상금이 올바르게 설정되어 있다.")
    @Test
    void Rank_상금_검증() {
        assertThat(Rank.FIRST.getPrize()).isEqualTo(2_000_000_000);
        assertThat(Rank.FIFTH.getPrize()).isEqualTo(5_000);
    }
    
}
