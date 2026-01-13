package com.biblioteca.cli;

import com.biblioteca.services.AutorService;
import com.biblioteca.services.EmprestimoService;
import com.biblioteca.services.LivroService;
import com.biblioteca.services.UsuarioService;

import java.util.Scanner;

import static com.biblioteca.cli.MenuEmprestimo.mostrar;
import static com.biblioteca.cli.MenuOpcao.SAIR;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    private static final LivroService livroService = new LivroService();
    private static final UsuarioService usuarioService = new UsuarioService();
    private static final EmprestimoService emprestimoService = new EmprestimoService();
    private static final AutorService autorService = new AutorService();
    static Menu EmprestimoMenu;

    public static void main(String[] args) {

        while (true) {
            Menu.mostrar();
            MenuOpcao opcao = MenuOpcao.fromInt(lerInt());

            if (opcao == null) {
                System.out.println("Opção Inválida!");
                continue;
            }

            switch (opcao) {

                case AUTOR -> {
                    try {
                        System.out.println("Nome do autor:");
                        String nome = sc.nextLine();

                        autorService.cadastrar(nome);
                        autorService.listar();
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    }
                }

                case LIVRO -> {
                    try {
                        System.out.println("Título do livro:");
                        String titulo = sc.nextLine();

                        System.out.println("Ano do livro:");
                        int ano = lerInt();

                        System.out.println("ID do autor:");
                        int autorId = lerInt();

                        livroService.cadastrar(titulo, ano, autorId);
                        livroService.listar();
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    }
                }

                case USUARIO -> {
                    System.out.println("Nome:");
                    String nome = sc.nextLine();

                    System.out.println("Email:");
                    String email = sc.nextLine();

                    if (nome.isBlank() || email.isBlank()) {
                        System.err.println("Nome e email são obrigatórios!");
                        break;
                    }

                    usuarioService.cadastrar(nome, email);
                    usuarioService.listar();
                }

                case LISTA_LIVROS -> {
                        livroService.listar();
                }

                case EMPRESTIMO ->{
                        menuEmprestimo();

                }

                case SAIR -> {
                    System.out.println("Encerrando sistema...");
                    System.exit(0);
                }

                default -> System.err.println("Função em construção!");
            }
        }
    }


    public static void menuEmprestimo() {
        while (true) {
            MenuEmprestimo.mostrar();
            int op = lerInt();

            switch (op) {
                case 1 -> {
                    try {
                        System.out.println("ID do Livro:");
                        int livroId = lerInt();

                        System.out.println("ID do Usuário:");
                        int usuarioId = lerInt();

                        emprestimoService.emprestar(livroId, usuarioId);
                        System.out.println("Empréstimo realizado com sucesso!");
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    }
                }
                case 2 -> System.err.println("Devolução em construção...");
                case 0 -> { return; }
                default -> System.out.println("Opção inválida");
            }
        }
    }

    static int lerInt() {
        while (true) {
            try {
                System.out.print("> ");
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Digite um número válido!");
            }
        }
    }
}
