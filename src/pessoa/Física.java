package pessoa;

import java.util.UUID;

public class Física extends Pessoa {
    private String cpf;

    private String rg;

    public Física(String nome, String rg, String cpf) {
        super(nome);
        this.cpf = cpf;
        this.rg = rg;
    }

    public Física(UUID id, String nome, String rg, String cpf) {
        super(id, nome);
        this.rg = rg;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }
}
