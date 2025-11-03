package lotto.view;

import java.util.List;

import lotto.domain.Lotto;

public class OutputView {

	public static void printIssueLottos(List<Lotto> issueLottos) {
		
		System.out.println(issueLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : issueLottos) {
            System.out.println(lotto.getNumbers());
        }
        
	}

}
