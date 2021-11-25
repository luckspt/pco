package pt.lucks.pco.tps.serie5.ex1;

public class DefaultStrategy implements RankingStrategy {
    @Override
    public int grade(Contest cont, String cand) {
        return (int)Math.round(this.media(cont, cand));
    }

    @Override
    public boolean isEligible(Contest cont, String cand) {
        int grade = this.grade(cont, cand);
        return grade >= cont.minGrade() && grade <= cont.maxGrade();
    }

    private double media(Contest cont, String cand) {
        double soma = 0;

        for (Criterio c : Criterio.values())
            soma += cont.grade(cand, c);

        return soma / Criterio.values().length;
    }
}
