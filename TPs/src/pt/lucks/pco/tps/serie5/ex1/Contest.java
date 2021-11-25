package pt.lucks.pco.tps.serie5.ex1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Contest implements IContest {
    private LocalDateTime dayLimit;
    private int minGrade;
    private int maxGrade;
    private Map<String, Candidate> candidates;

    public Contest(LocalDateTime dayLimit, int minGrade, int maxGrade) {
        this.dayLimit = dayLimit;
        this.minGrade = minGrade;
        this.maxGrade = maxGrade;
        this.candidates = new HashMap();
    }

    public void addCandidate(String c, int[] notas) {
        this.candidates.put(c, new Candidate(c, notas));
    }

    public boolean estahEmConcurso(String cand) {
        return this.candidates.get(cand) != null;
    }

    public List<String> eligibleCandidates() {
        List<String> eligibles = new ArrayList();

        for (Candidate c : this.candidates.values()) {
            if (this.isEligible(c.name()))
                eligibles.add(c.name());
        }

        return eligibles;
    }

    public List<String> higherRanked(String cand) {
        List<String> highers = new ArrayList();
        int candidateEvaluation = this.contestEvaluation(cand);

        for (Candidate c : this.candidates.values()) {
            if (this.contestEvaluation(c.name()) > candidateEvaluation)
                highers.add(c.name());
        }

        return highers;
    }

    public boolean inTime() {
        return this.dayLimit.isAfter(LocalDateTime.now());
    }

    public int maxGrade() {
        return this.maxGrade;
    }

    public int minGrade() {
        return this.minGrade;
    }

    /**
     *
     * @param nome
     * @param c O Criterio em questao
     * @requires estahEmConcurso(nome)
     * @return
     */
    public int grade(String nome, Criterio c) {
        return this.candidates.get(nome).grade(c);
    }

    public abstract boolean isEligible(String candidate);
    public abstract int contestEvaluation(String candidate);
}
