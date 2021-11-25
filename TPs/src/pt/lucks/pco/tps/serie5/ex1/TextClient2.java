package pt.lucks.pco.tps.serie5.ex1;

import java.time.LocalDateTime;

public class TextClient2 {

    public static void main(String[] args) {

        FlexibleDecisionContest yourCont = new FlexibleDecisionContest(
                LocalDateTime.of(2021, 11, 2, 16, 30),
                1,5);
        yourCont.addCandidate("Rita", new int[]{3,4,3,5,3,5});
        yourCont.addCandidate("Pedro", new int[]{5,5,5,4,4,3});
        System.out.println("Leadership skills da Rita " +
                yourCont.grade("Rita",Criterio.LEADERSHIP_SKILLS));
        System.out.println("Leadership skills do Pedro " +
                yourCont.grade("Pedro",Criterio.LEADERSHIP_SKILLS));

        avaliacoes("Rita", "Pedro", yourCont);

        RankingStrategy strat = new LeaderShipStrategy();
        yourCont.chooseRankingStrategy(strat);
        avaliacoes("Rita", "Pedro", yourCont);
    }

    /*
     * Imprime informação sobre dois candidatos dados num concurso dado
     */
    private static void avaliacoes(String cand1, String cand2, Contest contes) {
        System.out.println("====================================");
        if(contes instanceof FlexibleDecisionContest) {
            System.out.println("Estrategia de ranking: " +
                    ((FlexibleDecisionContest)contes).rankingStrategy().getClass());
        }
        System.out.println("Avaliacao de " + cand1 + ": " +
                contes.contestEvaluation(cand1));
        System.out.println(cand1 + " e' elegivel? " + contes.isEligible(cand1));
        System.out.println("Avaliacao de " + cand1 + ": " +
                contes.contestEvaluation(cand2));
        System.out.println(cand2 + " e' elegivel? " + contes.isEligible(cand2));
        System.out.println("Elegiveis:");
        for(String cand : contes.eligibleCandidates()) {
            System.out.println(cand);
        }
    }
}


