package pt.lucks.pco.tps.serie4.ex1;

import java.util.List;

/**
 * Esta classe testa a classe LigaDeHerois
 */
public class TestaLigaDeHerois {

    /**
     * Cria uma instancia de LigaDeHerois, adiciona varios super-herois e
     * invoca varios outros metodos
     * @param args - nao eh usado
     */
    public static void main(String[] args) {
        LigaDeHerois liga = new LigaDeHerois();
        Poder[] hyperPoderes = {Poder.VOO,Poder.RAIOX,Poder.FORCA};
        liga.maisUmHeroi("Hyperman", hyperPoderes);
        Poder[] rulkPoderes = {Poder.FORCA,Poder.INVULNERABILIDADE};
        liga.maisUmHeroi("Rulk", rulkPoderes);
        Poder[] phorPoderes = {Poder.FORCA,Poder.VOO,Poder.INVULNERABILIDADE};
        liga.maisUmHeroi("Phor", phorPoderes);
        System.out.println("Herois disponiveis com voo e forca:");
        Poder[] procura = {Poder.VOO,Poder.FORCA};
        List<String> herois = liga.disponiveisComPoderes(procura);
        for(String nome : herois){
            System.out.println(nome);
        }
        if(liga.estahDisponivel("Hyperman")){
            System.out.println("Hyperman estah disponivel");
            liga.contrataHeroi("Hyperman");
        }
        if(!liga.estahDisponivel("Hyperman")){
            System.out.println("Hyperman jah nao estah disponivel");
        }
        System.out.println("O heroi mais requisitado eh: " + liga.heroiMaisRequisitado());
        Poder[] novaProcura = {Poder.FORCA};
        herois = liga.disponiveisComPoderes(novaProcura);
        System.out.println("Herois disponiveis com forca:");
        for(String nome : herois){
            System.out.println(nome);
        }
        System.out.println("Quantos herois existem na Liga, com cada Poder?");
        int[] quantosCada = liga.quantosPorPoder();
        for(int i = 0 ; i < quantosCada.length ; i++){
            System.out.println(Poder.values()[i].name() + ": " + quantosCada[i]);
        }
    }
}
