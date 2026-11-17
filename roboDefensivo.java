/* RoboDefensivo: especializado em reduzir o dano recebido. */

public class roboDefensivo extends robo {

    public roboDefensivo(int codigo, String nome, int ataque, int defesa) {

        super(codigo, nome, ataque, defesa); 
    }

    @Override
    public String getTipo() {
        return "Defensivo";
    }

    @Override
    public int reduzirDanoRecebido(int dano) {

        dano = dano - 3;

        if (dano < 2) {
            return 2;
        }

        return dano;
    }
}

