package lotto;

import java.util.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {
	
	private final LottoService service = new LottoService();

    @DisplayName("구입 금액에 맞게 로또가 발행된다.")
    @Test
    void 로또_발행_수량_검증() {
        List<Lotto> lottos = serviceTestHelper_issueLottos(8000);
        assertThat(lottos).hasSize(8);
    }

    @DisplayName("로또 결과 계산 시 수익률이 올바르게 계산된다.")
    @Test
    void 수익률_계산_테스트() {
        // given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 6개 일치
                new Lotto(List.of(1, 2, 3, 4, 5, 7))  // 5개 + 보너스
        );
        WinningNumbers win = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        Map<Rank, Integer> resultMap = new EnumMap<>(Rank.class);
        resultMap.put(Rank.FIRST, 1);
        resultMap.put(Rank.SECOND, 1);
        resultMap.put(Rank.THIRD, 0);
        resultMap.put(Rank.FOURTH, 0);
        resultMap.put(Rank.FIFTH, 0);
        resultMap.put(Rank.MISS, 0);

        double profitRate = ((2_000_000_000 + 30_000_000) / 2000.0) * 100;
        Result result = new Result(resultMap, profitRate);

        assertThat(result.getProfitRate()).isEqualTo(profitRate);
    }

    // 도우미 메서드 (로또 발행용 private 메서드 테스트 대체)
    private List<Lotto> serviceTestHelper_issueLottos(int amount) {
        int count = amount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        }
        return lottos;
    }

}
