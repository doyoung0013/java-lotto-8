package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.WinningNumbers;

public class LottoService {
	
	public List<Lotto> issueLottos(int purchaseAmount) {
	    int count = purchaseAmount / 1000;
	    List<Lotto> lottos = new ArrayList<>();

	    for (int i = 0; i < count; i++) {
	        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6)); // ✅ 복사
	        Collections.sort(numbers);
	        lottos.add(new Lotto(numbers));
	    }

	    return lottos;
	}


	public Result calculateWinningResult(List<Lotto> issueLottos, WinningNumbers winningNumbers) {
		
		Map<Rank, Integer> rankCountMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCountMap.put(rank, 0);
        }
        
        for (Lotto lotto : issueLottos) {
            updateRankCount(rankCountMap, lotto, winningNumbers);
        }

        double profitRate = calculateProfitRate(rankCountMap, issueLottos.size() * 1000);
        return new Result(rankCountMap, profitRate);
	}
	
	private void updateRankCount(Map<Rank, Integer> rankCountMap, Lotto lotto, WinningNumbers winningNumbers) {
	    int matchCount = (int) lotto.getNumbers().stream()
	            .filter(winningNumbers.getNumbers()::contains)
	            .count();

	    boolean hasBonus = lotto.getNumbers().contains(winningNumbers.getBonusNumber());

	    Rank rank = Rank.of(matchCount, hasBonus);
	    rankCountMap.put(rank, rankCountMap.get(rank) + 1);
	}

	private double calculateProfitRate(Map<Rank, Integer> rankCountMap, int totalPurchase) {
        long totalPrize = rankCountMap.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return ((double) totalPrize / totalPurchase) * 100;
    }

}
