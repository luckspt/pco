package pt.lucks.pco.tps.serie4.ex1;

/**
 * Classe que define um super-heroi
 */
public class SuperHeroi {
    private String nome;
    private Poder[] poderes;
    private Estado estado;
    private int usado;

    /**
     * Inicializa um novo super-heroi com um dado nome e poderes; Fica disponivel para a acao
     * @param nome - O nome do novo super-heroi
     * @param poderes - Os poderes que o novo super-heroi tem
     */
    public SuperHeroi(String nome, Poder[] poderes){
        this.nome = nome;
        this.poderes = poderes;
        estado = Estado.DISPONIVEL;
    }

    /**
     * O nome deste super-heroi
     */
    public String nome() {
        return nome;
    }

    /**
     * O estado deste super-heroi
     */
    public Estado estado() {
        return estado;
    }

    /**
     * Este super-heroi tem um dado poder?
     * @param p - O poder
     * @return true se este heroi tem o poder p; false cc
     */
    public boolean temPoder(Poder p){
        for(Poder po : poderes){
            if(p == po){
                return true;
            }
        }
        return false;
    }

    /**
     * Mudar o estado deste super-heroi
     * @param e - O novo estado
     */
    public void mudaEstado(Estado e){
        if(estado == Estado.DISPONIVEL && e == Estado.EM_MISSAO){
            usado++;
        }
        estado = e;
    }

    /**
     * Em quantas missoes jah participou este super-heroi
     */
    public int quantasMissoes(){
        return usado;
    }

    /**
     * Este super-heroi estah disponivel?
     * @return
     */
    public boolean estahDisponivel(){
        return estado == Estado.DISPONIVEL;
    }
}
