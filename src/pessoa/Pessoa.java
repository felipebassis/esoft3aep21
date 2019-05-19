package pessoa;

import java.util.Objects;
import java.util.UUID;

public abstract class Pessoa {
    private UUID id;
    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(UUID id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return id.equals(pessoa.id) &&
                nome.equals(pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
