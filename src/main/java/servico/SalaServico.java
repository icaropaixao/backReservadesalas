package servico;

import dao.SalaDAO;
import modelo.Sala;

import java.io.IOException;
import java.util.List;

public class SalaServico {
    private SalaDAO salaDAO;

    public SalaServico() {
        this.salaDAO = new SalaDAO();
    }

    public void cadastrarSala(String numero, int capacidade, String recursos) throws IOException {
        Sala salaExistente = salaDAO.buscarSalaPorNumero(numero);
        if (salaExistente == null) {
            Sala sala = new Sala(numero, capacidade, recursos);
            salaDAO.salvarSala(sala);
        } else {
            throw new IllegalArgumentException("Número da sala já cadastrado.");
        }
    }

    public void atualizarSala(String numero, int capacidade, String recursos) throws IOException {
        Sala salaExistente = salaDAO.buscarSalaPorNumero(numero);
        if (salaExistente != null) {
            Sala salaAtualizada = new Sala(numero, capacidade, recursos);
            salaDAO.atualizarSala(salaAtualizada);
        } else {
            throw new IllegalArgumentException("Sala não encontrada.");
        }
    }

    public void removerSala(String numero) throws IOException {
        Sala salaExistente = salaDAO.buscarSalaPorNumero(numero);
        if (salaExistente != null) {
            salaDAO.removerSala(numero);
        } else {
            throw new IllegalArgumentException("Sala não encontrada.");
        }
    }

    public List<Sala> listarSalas() throws IOException {
        return salaDAO.listarSalas();
    }

    public Sala buscarSalaPorNumero(String numero) throws IOException {
        return salaDAO.buscarSalaPorNumero(numero);
    }
}

