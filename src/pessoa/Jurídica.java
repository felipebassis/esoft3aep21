package pessoa;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Jurídica extends Pessoa {
    private String cnpj;

    private Double capitalSocial;

    private Set<CotaSociedade> cotasSociedade = new HashSet<>();

    public Jurídica(String nome, String cnpj, Double capitalSocial) {
        super(nome);
        this.cnpj = cnpj;
        this.capitalSocial = capitalSocial;
    }

    public Jurídica(UUID id, String nome, String cnpj, Double capitalSocial) {
        super(id, nome);
        this.cnpj = cnpj;
        this.capitalSocial = capitalSocial;
    }

    public void adicionarSócio(Pessoa sócio, Double percentualDeParticipação){
        if (super.equals(sócio)){
            throw new RuntimeException("Não pode ser sócio dela mesma.");
        }
        CotaSociedade cotaSociedade = new CotaSociedade();
        cotaSociedade.sócio = sócio;
        if (percentualDeParticipação < 0){
            throw new RuntimeException("percentual não pode ser negativo");
        }
        if (percentualDeParticipação + this.cotasSociedade
                .stream()
                .mapToDouble(cotaSociedade1 -> cotaSociedade1.percentualDeParticipação)
                .sum() > this.capitalSocial){
            throw new RuntimeException("Participação maior que capital social");
        }
        cotaSociedade.percentualDeParticipação = percentualDeParticipação;

       this.cotasSociedade.add(cotaSociedade);
    }

    public void removerSócio(Pessoa sócio){
        if (!this.cotasSociedade.remove(sócio)){
            throw new RuntimeException("Não foi possivel excluir socio");
        }
    }


    private class CotaSociedade {

        private Pessoa sócio;

        private Double percentualDeParticipação;
    }
}
