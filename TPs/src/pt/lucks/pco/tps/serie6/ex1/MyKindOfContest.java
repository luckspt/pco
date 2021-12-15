package pt.lucks.pco.tps.serie6.ex1;

import java.time.LocalDateTime;

public class MyKindOfContest extends Contest {
    public MyKindOfContest(LocalDateTime dayLimit, int minGrade, int maxGrade) {
        super(dayLimit, minGrade, maxGrade);
    }

    @Override
    public boolean isEligible(String candidate) {
        return super.isEligible(candidate)
                && this.contestEvaluation(candidate) >= this.maxGrade() - 1;
    }

    @Override
    public int contestEvaluation(String candidate) {
        return (int)Math.round((double)(this.grade(candidate, Criterio.ACADEMIC_GRADE)
                + this.grade(candidate, Criterio.PROFESSIONAL_EXPERIENCE)
                + this.grade(candidate, Criterio.COURSE_RANKING)
        ) / 3);
    }
}
