package com.biblioteca.cli;




public enum MenuOpcao {
    AUTOR(1),
    LIVRO(2),
    USUARIO(3),
    LISTA_LIVROS(4),
    EMPRESTIMO(5),
    SAIR(0);

    private final int codigo;


    MenuOpcao(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
    public static MenuOpcao fromInt(int valor){
        for (MenuOpcao op : values()) {
            if (op.codigo == valor) return op;
        }
        return null;
    }








}
