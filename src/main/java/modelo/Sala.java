package modelo;

public class Sala {
    private String numero;
    private int capacidade;
    private String recursos;

    public Sala(String numero, int capacidade, String recursos) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.recursos = recursos;
    }
    // Getters e Setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getRecursos() {
        return recursos;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }
}
