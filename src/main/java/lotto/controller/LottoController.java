package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	
	private final LottoService lottoService = new LottoService();
	
	public void run() {
		int purchaseAmount = InputView.inputPurchaseAmount();
		List<Lotto> issueLottos = lottoService.issueLottos(purchaseAmount);
		OutputView.printIssueLottos(issueLottos);
		
	}

}
