package pt.lucks.pco.tps.serie4.ex1;

import java.util.ArrayList;
import java.util.List;

public class LigaDeHerois {
    private List<SuperHeroi> herois;

    public LigaDeHerois() {
        this.herois = new ArrayList();
    }

    public int quantosHerois() {
        return this.herois.size();
    }

    private SuperHeroi obterHeroi(String nome) {
        for (SuperHeroi sh : this.herois) {
            if (sh.nome().equals(nome))
                return sh;
        }

        return null;
    }

    public boolean heroiPertence(String nome) {
        return this.obterHeroi(nome) != null;
    }

    public void maisUmHeroi(String nome, Poder[] poderes) {
        this.herois.add(new SuperHeroi(nome, poderes));
    }

    public boolean estahDisponivel(String nome) {
        return this.obterHeroi(nome).estahDisponivel();
    }

    public Estado estadoHeroi(String nome) {
        return this.obterHeroi(nome).estado();
    }

    public void contrataHeroi(String nome) {
        this.obterHeroi(nome).mudaEstado(Estado.EM_MISSAO);
    }

    public void libertaHeroi(String nome) {
        this.obterHeroi(nome).mudaEstado(Estado.DISPONIVEL);
    }

    public String heroiMaisRequisitado() {
        SuperHeroi result = this.herois.get(0);
        for (SuperHeroi sh : this.herois) {
            if (sh.quantasMissoes() > result.quantasMissoes())
                result = sh;
        }

        return result.nome();
    }

    public List<String> disponiveisComPoderes(Poder[] poderes) {
        List<String> result = new ArrayList();
        for (SuperHeroi sh : this.herois) {
            boolean valido = sh.estahDisponivel();
            for (int i=0; valido && i<Poder.values().length; i++) {
                if (!sh.temPoder(Poder.values()[i])) {
                    valido = false;
                    break;
                }
            }

            if (valido)
                result.add(sh.nome());
        }

        return result;
    }

    public int[] quantosPorPoder() {
        int[] quantos = new int[Poder.values().length];
        for (SuperHeroi sh : this.herois) {
            for (Poder p : Poder.values()) {
                if (sh.temPoder(p))
                    quantos[p.ordinal()]++;
            }
        }

        return quantos;
    }
}
