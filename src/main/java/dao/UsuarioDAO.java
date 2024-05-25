
package dao; // classe UsuarioDAO para gerenciar a persistência dos dados dos usuários

import modelo.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private static final String FILE_PATH = "src/main/resources/usuarios.txt";

    public void salvarUsuario(Usuario usuario) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(usuario.getNome() + "," + usuario.getEmail() + "," + usuario.getSenha());
            writer.newLine();
        }
    }

    public List<Usuario> listarUsuarios() throws IOException {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                Usuario usuario = new Usuario(dados[0], dados[1], dados[2]);
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    public Usuario buscarUsuarioPorEmail(String email) throws IOException {
        List<Usuario> usuarios = listarUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }
}
