package pt.lucks.pco.tps.serie6.ex1;

public class LeaderShipStrategy implements RankingStrategy {
    @Override
    public int grade(Contest cont, String cand) {
        return cont.grade(cand, Criterio.LEADERSHIP_SKILLS) == cont.maxGrade()
                ? 1
                : 0;
    }

    @Override
    public boolean isEligible(Contest cont, String cand) {
        return this.grade(cont, cand) == 1;
    }
}
