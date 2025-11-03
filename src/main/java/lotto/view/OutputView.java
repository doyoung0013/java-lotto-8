package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;

public class OutputView {

	public static void printIssueLottos(List<Lotto> issueLottos) {
		
		System.out.println(issueLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : issueLottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
        
	}

	public static void printResult(Result result) {
		
		System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> resultMap = result.getResultMap();

        System.out.println("3개 일치 (5,000원) - " + resultMap.getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + resultMap.getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + resultMap.getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultMap.getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultMap.getOrDefault(Rank.FIRST, 0) + "개");

        printProfitRate(result.getProfitRate());
		
	}
	
	private static void printProfitRate(double profitRate) {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("총 수익률은 " + df.format(profitRate) + "%입니다.");
    }

}
