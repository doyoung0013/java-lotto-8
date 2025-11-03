package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void run() {
        int purchaseAmount = inputPurchaseAmountWithRetry();
        List<Lotto> issueLottos = lottoService.issueLottos(purchaseAmount);
        OutputView.printIssueLottos(issueLottos);

        WinningNumbers winningNumbers = inputWinningNumbersWithRetry();
        Result result = lottoService.calculateWinningResult(issueLottos, winningNumbers);
        OutputView.printResult(result);
    }

    private int inputPurchaseAmountWithRetry() {
        while (true) {
            try {
                return InputView.inputPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private WinningNumbers inputWinningNumbersWithRetry() {
        while (true) {
            try {
                return InputView.inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
