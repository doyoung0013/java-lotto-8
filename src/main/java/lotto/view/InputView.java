package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	
	public static int inputPurchaseAmount() {
		
		System.out.println("구입금액을 입력해 주세요.");
		String inputLine = Console.readLine();
		int amount = validatePurchaseAmount(inputLine);
        return amount;
        
	}
	
	public static int validatePurchaseAmount(String inputLine){
		try {
            int amount = Integer.parseInt(inputLine.trim());
            if (amount <= 0) {
                throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해 주세요.");
            }
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 정확히 입력해 주세요.");
        }
	}

}
