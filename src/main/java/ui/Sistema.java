


// classe Sistema que conterá a interface
// de usuário simples para interagir com o sistema.
package ui;

import servico.SalaServico;
import servico.UsuarioServico;
import modelo.Sala;
import modelo.Usuario;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private static UsuarioServico usuarioServico = new UsuarioServico();
    private static SalaServico salaServico = new SalaServico();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Cadastro de Usuário");
            System.out.println("2. Login");
            System.out.println("3. Gerenciamento de Salas");
            System.out.println("4. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Senha: ");
                String senha = scanner.nextLine();
                try {
                    usuarioServico.cadastrarUsuario(nome, email, senha);
                    System.out.println("Usuário cadastrado com sucesso!");
                } catch (IOException e) {
                    System.out.println("Erro ao salvar usuário.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (opcao == 2) {
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Senha: ");
                String senha = scanner.nextLine();
                try {
                    Usuario usuario = usuarioServico.login(email, senha);
                    if (usuario != null) {
                        System.out.println("Login bem-sucedido! Bem-vindo, " + usuario.getNome() + "!");
                    } else {
                        System.out.println("Email ou senha inválidos.");
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao realizar login.");
                }
            } else if (opcao == 3) {
                System.out.println("1. Cadastro de Sala");
                System.out.println("2. Atualizar Sala");
                System.out.println("3. Remover Sala");
                System.out.println("4. Listar Salas");
                int opcaoSala = scanner.nextInt();
                scanner.nextLine();  // Consumir a nova linha

                if (opcaoSala == 1) {
                    System.out.print("Número da Sala: ");
                    String numero = scanner.nextLine();
                    System.out.print("Capacidade: ");
                    int capacidade = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha
                    System.out.print("Recursos: ");
                    String recursos = scanner.nextLine();
                    try {
                        salaServico.cadastrarSala(numero, capacidade, recursos);
                        System.out.println("Sala cadastrada com sucesso!");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar sala.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (opcaoSala == 1) {
                    System.out.print("Número da Sala: ");
                    String numero = scanner.nextLine();
                    System.out.print("Capacidade: ");
                    int capacidade = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha
                    System.out.print("Recursos: ");
                    String recursos = scanner.nextLine();
                    try {
                        salaServico.cadastrarSala(numero, capacidade, recursos);
                        System.out.println("Sala cadastrada com sucesso!");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar sala.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    } else if (opcaoSala == 2) {
                    System.out.print("Número da Sala a ser atualizada: ");
                    String numero = scanner.nextLine();
                    System.out.print("Nova Capacidade: ");
                    int capacidade = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha
                    System.out.print("Novos Recursos: ");
                    String recursos = scanner.nextLine();
                    try {
                        salaServico.atualizarSala(numero, capacidade, recursos);
                        System.out.println("Sala atualizada com sucesso!");
                    } catch (IOException e) {
                        System.out.println("Erro ao atualizar sala.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (opcaoSala == 3) {
                    System.out.print("Número da Sala a ser removida: ");
                    String numero = scanner.nextLine();
                    try {
                        salaServico.removerSala(numero);
                        System.out.println("Sala removida com sucesso!");
                    } catch (IOException e) {
                        System.out.println("Erro ao remover sala.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (opcaoSala == 4) {
                    try {
                        List<Sala> salas = salaServico.listarSalas();
                        if (salas.isEmpty()) {
                            System.out.println("Não há salas cadastradas.");
                        } else {
                            System.out.println("Salas cadastradas:");
                            for (Sala sala : salas) {
                                System.out.println("Número: " + sala.getNumero() + ", Capacidade: " + sala.getCapacidade() + ", Recursos: " + sala.getRecursos());
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Erro ao listar salas.");
                    }
                } else {
                    System.out.println("Opção inválida.");
                }
            } else if (opcao == 4) {
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}

