package lotto.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumbers;

public class InputView {

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputLine = Console.readLine();
        return validatePurchaseAmount(inputLine);
    }

    public static WinningNumbers inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String line = Console.readLine();
        List<Integer> numbers = parseNumbers(line);
        validateWinningNumbers(numbers);
        
        int bonus = inputBonusNumber();
        return new WinningNumbers(numbers, bonus);
    }

    private static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String line = Console.readLine();
        int bonus = parsePositiveInt(line);
        validateNumberRange(bonus);
        return bonus;
    }

    private static int validatePurchaseAmount(String input) {
        int amount = parsePositiveInt(input);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }

    private static int parsePositiveInt(String input) {
        try {
            int value = Integer.parseInt(input.trim());
            if (value <= 0) {
                throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해 주세요.");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 정확히 입력해 주세요.");
        }
    }

    private static List<Integer> parseNumbers(String csv) {
        try {
            return parseTokensToNumbers(csv.split(","));
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 정수여야 합니다.");
        }
    }

    private static List<Integer> parseTokensToNumbers(String[] tokens) {
        List<Integer> result = new ArrayList<>(tokens.length);
        for (String token : tokens) {
            result.add(Integer.parseInt(token.trim()));
        }
        return result;
    }

    private static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
        validateAllNumbersInRange(numbers);
    }

    private static void validateAllNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    private static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}