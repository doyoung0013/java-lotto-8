package lotto.domain;

import java.util.Map;

public class Result {

	private final Map<Rank, Integer> resultMap;
    private final double profitRate;

    public Result(Map<Rank, Integer> resultMap, double profitRate) {
        this.resultMap = resultMap;
        this.profitRate = profitRate;
    }

    public double getProfitRate() {
        return profitRate;
    }

	public Map<Rank, Integer> getResultMap() {
		return resultMap;
	}
    
    
}
