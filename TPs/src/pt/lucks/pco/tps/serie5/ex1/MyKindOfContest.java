package pt.lucks.pco.tps.serie5.ex1;

import java.time.LocalDateTime;

public class MyKindOfContest extends Contest {
    public MyKindOfContest(LocalDateTime dayLimit, int minGrade, int maxGrade) {
        super(dayLimit, minGrade, maxGrade);
    }

    private double media(String candidate) {
        return (double)(this.grade(candidate, Criterio.ACADEMIC_GRADE)
                        + this.grade(candidate, Criterio.PROFESSIONAL_EXPERIENCE)
                        + this.grade(candidate, Criterio.COURSE_RANKING)
                ) / 3;
    }

    @Override
    public boolean isEligible(String candidate) {
        return this.media(candidate) >= this.maxGrade() - 1;
    }

    @Override
    public int contestEvaluation(String candidate) {
        return (int)Math.round(this.media(candidate));
    }
}
