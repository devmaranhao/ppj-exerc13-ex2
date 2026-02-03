public class Main {
    public static void main(String[] args) {

        Produto produto = new Produto.Builder(
                1L,
                "7891234567890",
                "Notebook",
                3500.00
        )
                .marca("Dell")
                .modelo("Inspiron")
                .estoque(10)
                .categoria("Informática")
                .urlFoto("http://imagem.com/notebook.jpg")
                .build();

        System.out.println("Produto criado com sucesso!");
    }
}