

package servico; // a classe UsuarioServico para lidar com a lógica de negócios.

import dao.UsuarioDAO;
import modelo.Usuario;
import java.io.IOException;

public class UsuarioServico {
    private UsuarioDAO usuarioDAO;

    public UsuarioServico() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrarUsuario(String nome, String email, String senha) throws IOException {
        Usuario usuarioExistente = usuarioDAO.buscarUsuarioPorEmail(email);
        if (usuarioExistente == null) {
            Usuario usuario = new Usuario(nome, email, senha);
            usuarioDAO.salvarUsuario(usuario);
        } else {
            throw new IllegalArgumentException("E-mail já cadastrado.");
        }
    }

    public Usuario login(String email, String senha) throws IOException {
        Usuario usuario = usuarioDAO.buscarUsuarioPorEmail(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }
        return null;
    }
}
