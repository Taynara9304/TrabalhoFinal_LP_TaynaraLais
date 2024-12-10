package banco_de_dados.entity;

public class AnimaisMarinhos implements Comparable<AnimaisMarinhos> {
    private String nomeEspecie = null;
    private int idade = 0;
    private int qtdPatas = 0;
    private int peso = 0;
    private int profundidadeMax = 0;
    private int velocidadeMax = 0;

    public void setNomeEspecie(String nome) {
        this.nomeEspecie = nome;
    }

    public String getNomeEspecie() {
        return nomeEspecie;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setQtdPatas(int patas) {
        this.qtdPatas = patas;
    }

    public int getQtdPatas() {
        return qtdPatas;
    }

    public void setPeso(int massa) {
        this.peso = massa;
    }

    public int getPeso() {
        return peso;
    }

    public void setProfundidadeMax(int profundidade) {
        this.profundidadeMax = profundidade;
    }

    public int getProfundidadeMax() {
        return profundidadeMax;
    }

    public void setVelocidadeMax(int velocidade) {
        this.velocidadeMax = velocidade;
    }

    public int getVelocidadeMax() {
        return velocidadeMax;
    }

    @Override
    public int compareTo(AnimaisMarinhos animais) {
        return this.nomeEspecie.compareToIgnoreCase(animais.getNomeEspecie());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nomeEspecie == null) ? 0 : nomeEspecie.hashCode());
        result = prime * result + idade;
        result = prime * result + qtdPatas;
        result = prime * result + peso;
        result = prime * result + profundidadeMax;
        result = prime * result + velocidadeMax;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AnimaisMarinhos other = (AnimaisMarinhos) obj;
        if (nomeEspecie == null) {
            if (other.nomeEspecie != null)
                return false;
        } else if (!nomeEspecie.equals(other.nomeEspecie))
            return false;
        if (idade != other.idade)
            return false;
        if (qtdPatas != other.qtdPatas)
            return false;
        if (peso != other.peso)
            return false;
        if (profundidadeMax != other.profundidadeMax)
            return false;
        if (velocidadeMax != other.velocidadeMax)
            return false;
        return true;
    }

    
}
