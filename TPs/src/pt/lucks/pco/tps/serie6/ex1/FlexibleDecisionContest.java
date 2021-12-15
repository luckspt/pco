package pt.lucks.pco.tps.serie6.ex1;

import java.time.LocalDateTime;

public class FlexibleDecisionContest extends Contest {
    private RankingStrategy strategy;

    public FlexibleDecisionContest (LocalDateTime dayLimit, int minGrade, int maxGrade) {
        super(dayLimit, minGrade, maxGrade);
        this.strategy = new DefaultStrategy();
    }

    @Override
    public boolean isEligible(String candidate) {
        return this.strategy.isEligible(this, candidate);
    }

    @Override
    public int contestEvaluation(String candidate) {
        return this.strategy.grade(this, candidate);
    }

    public RankingStrategy rankingStrategy() {
        return this.strategy;
    }

    public void chooseRankingStrategy(RankingStrategy strategy) {
        this.strategy = strategy;
    }
}
