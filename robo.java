
// classe Robo
public abstract class robo {

    // caracteristicas do robo
    private int codigo;
    private String nome;
    private int ataque;
    private int defesa;
    private int energiaAtual;
    private int vitorias;
    private int derrotas;
    private int pontos;

    public robo(int codigo, String nome, int ataque, int defesa) {

        this.codigo = codigo;
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.energiaAtual = 100;
        this.vitorias = 0;
        this.derrotas = 0;
        this.pontos = 0;
    }

    // consultar os atributos
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getEnergiaAtual() {
        return energiaAtual;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getPontos() {
        return pontos;
    }

    // identificar o tipo de robo
    public abstract String getTipo();

    // calcular ataque
    public int calcularAtaque() {
        return ataque;
    }

    // reduzir dano recebido
    public int reduzirDanoRecebido(int dano) {
        return dano;
    }

    public void perderEnergia(int valor) {

        energiaAtual = energiaAtual - valor;

        if (energiaAtual < 0) {
            energiaAtual = 0;
        }
    }

    public void recuperarEnergia(int valor) {

        energiaAtual = energiaAtual + valor;

        if (energiaAtual > 100) {
            energiaAtual = 100;
        }
    }

    public void registrarVitoria() {
        vitorias++;
    }

    public void registrarDerrota() {
        derrotas++;
    }

    public void adicionarPontos(int valor) {
        pontos = pontos + valor;
    }
}
