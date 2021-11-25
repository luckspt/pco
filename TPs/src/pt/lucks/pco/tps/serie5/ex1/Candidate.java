package pt.lucks.pco.tps.serie5.ex1;

/**
 * Um candidato a concurso
 */
public class Candidate {
    private String name;
    private int[] evals;

    /**
     * Construtor   Pre-condicao: name != null && evaluations != null
     * @param name O nome do candidato
     * @param evaluations A avaliacao para cada criterio
     * @requires name != null && evaluations != null
     */
    public Candidate(String name, int[] evaluations) {
        this.name = name;
        evals = new int[evaluations.length];
        for(int i = 0 ; i < evals.length ; i++)
            evals[i] = evaluations[i];
    }

    /**
     * A classificacao deste candidato em relacao a um determinado
     * criterio de avaliacao     Pre-condicao: cri != null
     * @param cri O criterio
     * @requires cri != null
     */
    public int grade(Criterio cri) {
        return evals[cri.ordinal()];
    }

    /** O nome deste candidato */
    public String name() {
        return name;
    }

}
