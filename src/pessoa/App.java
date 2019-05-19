package pessoa;

import java.util.UUID;

public class App {
    public static void main(String[] args) {
        Jurídica jurídica = new Jurídica(UUID.randomUUID(), "Test", "12382384823", 50000D);
        Física física = new Física(UUID.randomUUID(), "TestP", "239743292377", "q79834872373");
        jurídica.adicionarSócio(física, 4000D);
        jurídica.adicionarSócio(física, 400D);
    }
}
