package lotto.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningNumbers;

public class LottoService {
	
	public Result play(int amount) {
        
		List<Lotto> purchasedLottos = issueLottos(amount);
        WinningNumbers winningNumbers = WinningNumbers.of();
        
        return calculateResult(purchasedLottos, winningNumbers);
    }
	
	private List<Lotto> issueLottos(int purchaseAmount) {
        int count = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    private Result calculateResult(List<Lotto> lottos, WinningNumbers winningNumbers) {
        // 각 로또를 비교해 등수를 계산하고 결과 누적
        return new Result();
    }

}
