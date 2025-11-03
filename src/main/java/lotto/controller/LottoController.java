package lotto.controller;

import lotto.domain.Result;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {
	
	private final LottoService lottoService = new LottoService();
	
	public void run() {
		int purchaseAmount = InputView.inputPurchaseAmount();
		Result result = lottoService.play(purchaseAmount);
		
	}

}
