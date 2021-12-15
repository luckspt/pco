package pt.lucks.pco.tps.serie6.ex1;

public class DefaultStrategy implements RankingStrategy {
    @Override
    public int grade(Contest cont, String cand) {
        double soma = 0;

        for (Criterio c : Criterio.values())
            soma += cont.grade(cand, c);

        return (int)Math.round(soma / Criterio.values().length);
    }

    @Override
    public boolean isEligible(Contest cont, String cand) {
        int grade = this.grade(cont, cand);
        return grade >= cont.minGrade() && grade <= cont.maxGrade();
    }

}
