package lotto.service;

import lotto.domain.Result;

public class LottoService {
	
	public Result play(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return null;
    }

}
