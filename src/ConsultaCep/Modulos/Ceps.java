package ConsultaCep.Modulos;

public record Ceps(String cep, String logradouro,
                   String complemento, String bairro,
                   String localidade, String uf, int ddd) {

    @Override
    public String toString() {
        return "Ceps{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", ddd=" + ddd +
                '}';
    }
}
