package pt.lucks.pco.tps.serie5.ex1;

import java.util.List;

/**
 * Interface que define os metodos que um concurso deve
 * fornecer
 */
public interface IContest {

    /**
     * Ainda nao passou a data limite do concurso?
     */
    boolean inTime();

    /**
     * Adiciona um candidato a este concurso se o tempo
     * limite deste concurso nao foi ultrapassado
     * Pre-condicao: inTime() && nome != null && evals != null &&
     * evals.length == Criterio.values.length
     *
     * @param c - Um candidato a este concurso
     * @requires inTime() && nome != null && evals != null &&
     * evals.length == Criterio.values.length
     */
    void addCandidate(String nome, int[] evals);

    /**
     * Lista dos nomes dos candidatos elegiveis para
     * este concurso
     */
    List<String> eligibleCandidates();

    /**
     * Lista dos nomes dos candidatos cuja avaliacao neste
     * concurso e' superior 'a avaliacao de um dado candidato
     *          Pre-condicao: c != null
     * @param c O nome do candidato em questao
     * @requires c != null
     */
    public	List<String> higherRanked(String c);

    /**
     * Valor maximo de avaliacao dos candidatos nos
     * varios criterios
     */
    int maxGrade();

    /**
     * Valor minimo de avaliacao dos candidatos nos
     * varios criterios
     */
    int minGrade();

    /**
     * Um dado candidato e' elegivel para concorrer
     * neste concurso?
     *          Pre-condicao: c != null
     * @param c O nome do candidato
     * @requires c != null
     */
    boolean isEligible(String c);

    /**
     * A avaliacao de um dado candidato neste concurso
     *     Pre-condicao: c != null && eligibleCandidates().contains(c)
     * @param c O candidato
     * @requires c != null && eligibleCandidates().contains(c)
     */
    int contestEvaluation(String c);

    /**
     * Um dado individuo esta' em concurso?
     *     Pre-condicao: c != null
     * @param c O candidato
     * @requires c != null
     */
    boolean estahEmConcurso(String c);

    /**
     * A nota que um dado candidato tem num dado criterio
     *     Pre-condicao: cand != null && c != null
     * @param cand O nome do candidato
     * @param c O Criterio em questao
     * @requires cand != null && c != null
     */
    int grade(String cand, Criterio c);


}