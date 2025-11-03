package lotto.view;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Result;

public class OutputView {

	public static void printIssueLottos(List<Lotto> issueLottos) {
		
		System.out.println(issueLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : issueLottos) {
            System.out.println(lotto.getNumbers());
        }
        
	}

	public static void printResult(Result result) {
		// TODO Auto-generated method stub
		
	}

}
