package pt.lucks.pco.tps.serie6.ex1;



import java.time.LocalDateTime;

public class TextClient {

    public static void main(String[] args) {

        IContest myCont = new MyKindOfContest(
                LocalDateTime.of(2021, 11, 2, 16, 30),1,5);
        if(myCont.inTime()) {
            myCont.addCandidate("Rita", new int[]{3,4,3,5,3,5});
            myCont.addCandidate("Pedro", new int[]{5,5,5,4,4,3});
        }
        System.out.println("Avaliacao da Rita: " +
                myCont.contestEvaluation("Rita"));
        System.out.println("Rita eh elegivel? " +
                myCont.isEligible("Rita"));
        System.out.println("Avaliacao do Pedro: " +
                myCont.contestEvaluation("Pedro"));
        System.out.println("Pedro eh elegivel? " +
                myCont.isEligible("Pedro"));

        System.out.println("Elegiveis:");
        for(String cand : myCont.eligibleCandidates()) {
            System.out.println(cand);
        }

        System.out.println("Candidatos melhores que a Rita:");
        for(String cand : myCont.higherRanked("Rita")) {
            System.out.println(cand);
        }

        System.out.println("Candidatos melhores que o Pedro:");
        for(String cand : myCont.higherRanked("Pedro")) {
            System.out.println(cand);
        }

        System.out.println("===  BYE  ===");
    }
}
