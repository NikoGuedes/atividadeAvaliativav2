/* roboOfensivo: especializado em causar dano. */ 

public class roboOfensivo extends robo { // atributos e metodo da classe robo

    public roboOfensivo(int codigo, String nome, int ataque, int defesa) {

        super(codigo, nome, ataque, defesa);
    }

    @Override
    public String getTipo() {
        return "Ofensivo";
    }

    @Override
    public int calcularAtaque() {
        return getAtaque() + 5;
    }
}