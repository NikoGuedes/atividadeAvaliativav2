/* Equilibrado: não recebe modificadores adicionais. */


public class roboEquilibrado extends robo {

    public roboEquilibrado(int codigo, String nome, int ataque, int defesa) {
        super(codigo, nome, ataque, defesa);
    }

    @Override
    public String getTipo() {
        return "equilibrado";
    }

}