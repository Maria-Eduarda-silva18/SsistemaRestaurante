package cardapio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LancheTest {

    @Test
    public void deveRejeitarPrecoNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Lanche("X-Burger", -10.00));
    }

    @Test
    public void deveCalcularXBaconComCheddar() {
        ItemCardapio lanche = LancheFactory.criarLanche("x-bacon");

        lanche = new ComCheddar(lanche);

        assertEquals(26.00, lanche.getPreco(), 0.001);
    }
}

