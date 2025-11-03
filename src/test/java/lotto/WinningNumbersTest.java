package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.WinningNumbers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {
	
	@DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호_중복_예외() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void 당첨번호_개수_검증() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 당첨 번호와 보너스 번호로 객체를 생성할 수 있다.")
    @Test
    void 당첨번호_정상_생성() {
        WinningNumbers wn = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(wn.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(wn.getBonusNumber()).isEqualTo(7);
    }

}
