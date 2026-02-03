import java.time.LocalDate;

public class Produto {
    private long id;
    private String codigoEan;
    private String descricao;
    private String marca;
    private String modelo;
    private double preco;
    private LocalDate dataCadastro;
    private LocalDate dataUltimaAtualizacao;
    private int estoque;
    private String categoria;
    private String urlFoto;

    private Produto (Builder builder) {
        this.id = builder.id;
        this.codigoEan = builder.codigoEan;
        this.descricao = builder.descricao;
        this.marca = builder.marca;
        this.modelo = builder.modelo;
        this.preco = builder.preco;
        this.estoque = builder.estoque;
        this.categoria = builder.categoria;
        this.urlFoto = builder.urlFoto;
        this.dataCadastro = builder.dataCadastro;
        this.dataUltimaAtualizacao = builder.dataUltimaAtualizacao;
    }

    public static class Builder {
        // obrigatórios
        private long id;
        private String codigoEan;
        private String descricao;
        private double preco;

        // opcionais
        private String marca = "";
        private String modelo = "";
        private int estoque = 0;
        private String categoria = "";
        private String urlFoto = "";
        private LocalDate dataCadastro = LocalDate.now();
        private LocalDate dataUltimaAtualizacao = LocalDate.now();

        public Builder(long id, String codigoEan, String descricao, double preco) {

            if (codigoEan == null || descricao == null) {
                throw new IllegalArgumentException("Strings não podem ser null");
            }

            if (preco <= 0) {
                throw new IllegalArgumentException("Preço deve ser maior que zero");
            }

            this.id = id;
            this.codigoEan = codigoEan;
            this.descricao = descricao;
            this.preco = preco;
        }

        public Builder marca(String marca) {
            if (marca == null) {
                throw new IllegalArgumentException("Marca não pode ser null");
            }
            this.marca = marca;
            return this;
        }

        public Builder modelo(String modelo) {
            if (this.marca == null || this.marca.isEmpty()) {
                throw new IllegalStateException("Não é permitido informar modelo sem marca");
            }
            if (modelo == null) {
                throw new IllegalArgumentException("Modelo não pode ser null");
            }
            this.modelo = modelo;
            return this;
        }

        public Builder estoque(int estoque) {
            if (estoque < 0) {
                throw new IllegalArgumentException("Estoque não pode ser negativo");
            }
            this.estoque = estoque;
            return this;
        }

        public Builder categoria(String categoria) {
            if (categoria == null) {
                throw new IllegalArgumentException("Categoria não pode ser null");
            }
            this.categoria = categoria;
            return this;
        }

        public Builder urlFoto(String urlFoto) {
            if (urlFoto == null) {
                throw new IllegalArgumentException("URL da foto não pode ser null");
            }
            this.urlFoto = urlFoto;
            return this;
        }

        public Produto build() {
            this.dataUltimaAtualizacao = LocalDate.now();
            return new Produto(this);
        }
    }
}
