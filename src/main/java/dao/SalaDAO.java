

//  classe SalaDAO para gerenciar a persistência dos dados das salas.
//Usaremos um arquivo de texto (salas.txt) para armazenar os dados.
package dao;

import modelo.Sala;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SalaDAO {
    private static final String FILE_PATH = "src/main/resources/salas.txt";

    public void salvarSala(Sala sala) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(sala.getNumero() + "," + sala.getCapacidade() + "," + sala.getRecursos());
            writer.newLine();
        }
    }

    public List<Sala> listarSalas() throws IOException {
        List<Sala> salas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                Sala sala = new Sala(dados[0], Integer.parseInt(dados[1]), dados[2]);
                salas.add(sala);
            }
        }
        return salas;
    }

    public Sala buscarSalaPorNumero(String numero) throws IOException {
        List<Sala> salas = listarSalas();
        for (Sala sala : salas) {
            if (sala.getNumero().equals(numero)) {
                return sala;
            }
        }
        return null;
    }

    public void atualizarSala(Sala salaAtualizada) throws IOException {
        List<Sala> salas = listarSalas();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Sala sala : salas) {
                if (sala.getNumero().equals(salaAtualizada.getNumero())) {
                    writer.write(salaAtualizada.getNumero() + "," + salaAtualizada.getCapacidade() + "," + salaAtualizada.getRecursos());
                } else {
                    writer.write(sala.getNumero() + "," + sala.getCapacidade() + "," + sala.getRecursos());
                }
                writer.newLine();
            }
        }
    }

    public void removerSala(String numero) throws IOException {
        List<Sala> salas = listarSalas();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Sala sala : salas) {
                if (!sala.getNumero().equals(numero)) {
                    writer.write(sala.getNumero() + "," + sala.getCapacidade() + "," + sala.getRecursos());
                    writer.newLine();
                }
            }
        }
    }
}
