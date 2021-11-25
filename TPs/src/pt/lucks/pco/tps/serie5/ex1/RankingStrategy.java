package pt.lucks.pco.tps.serie5.ex1;

public interface RankingStrategy {

    /**
     * A avaliacao que um dado candidato tem num dado concurso
     * @param cont O concurso
     * @param cand O nome do candidato
     * @requires cont != null && cont.eligibleCandidates().contains(cand)
     * @return A avaliacao que o candidato de nome cand tem no
     *         concurso cont
     */
    public int grade(Contest cont, String cand);

    /**
     * Um dado candidato e' elegivel num dado concurso?
     * @param cont O concurso
     * @param cand O nome do candidato
     * @requires cont != null && cand != null
     * @return O candidato de nome cand e' elegivel no
     *         concurso cont?
     */
    public boolean isEligible(Contest cont, String cand);

}
