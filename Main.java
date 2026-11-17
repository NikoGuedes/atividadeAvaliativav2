/* Requisitos técnicos
- A classe `Robo` deverá possuir construtor e métodos que representem suas ações, protegendo as regras de alteração de energia e indicadores. 
- A classe `Main` será responsável pelo menu, pelas buscas, pela organização dos confrontos e pela interação com o usuário.
- Não utilize métodos prontos de ordenação. Implemente buscas e ordenação utilizando repetições e condicionais. É permitido utilizar listas auxiliares.
- O programa deverá tratar entradas inválidas, códigos inexistentes e listas vazias, apresentando mensagens claras e mantendo os dados consistentes. */


import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        ArrayList<robo> robos = new ArrayList<>();

    int option = 0;
    int codigoRobo = 1;
    int quantidadeRobos = 0;
    
    do { 
        
        System.out.println("ATIVIDADE AVALIATIVA Campeonato de robôs de combate\n");

        System.out.println("1. Cadastrar robôs");
        System.out.println("2. Consultar robô pelo código:");
        System.out.println("3. Listar todos os robôs:");
        System.out.println("4. Realizar um combate");
        System.out.println("5. Recuperar energia");
        System.out.println("6. Rodada Geral");
        System.out.println("7. Exibir Classificação");
        System.out.println("8. Excluir Participante");
        option = s.nextInt();

        switch (option) {

            case 1: 
                
                int codigo = codigoRobo; /* Professor, eu estava pedindo pro usuário informar o código, mas eu coloquei um contador
                gera o codigo automaticamente */
                codigoRobo++;


                System.out.print("Informe o nome do robô: \n");
                String nome = s.next();
                System.out.print("Informe o ataque do robô: \n");
                int ataque = s.nextInt();

            while (ataque < 10 || ataque > 30) {
                System.out.println("Ataque invalido! Informe novamente: \n");
                ataque = s.nextInt(); 
            }

                System.out.print("Informe a defesa do robô: \n");
                int defesa = s.nextInt();
            while (defesa < 0 || defesa > 20) {
                System.out.println("Defesa invalida! Informe novamente: \n");
                defesa = s.nextInt();
            }
            
                System.out.println("Seu código foi gerado: " + codigo + "\n");

                /*robo robo = new robo(
                    codigo, 
                    nome, 
                    ataque, 
                    defesa
                );
                robos.add(robo); */ 

                System.out.println("Escolha o tipo de robo:");
                System.out.println("1. Ofensivo");
                System.out.println("2. Defensivo");
                System.out.println("3. Equilibrado");
                int tipo = s.nextInt();
            while (tipo < 1 || tipo > 3) {
                System.out.println("Tipo invalido! Escolha novamente:");
                tipo = s.nextInt();
            }

            robo robo;

                if (tipo == 1) {
                robo = new roboOfensivo(codigo, nome, ataque, defesa);
                } 
                else if (tipo == 2) {
                robo = new roboDefensivo(codigo, nome, ataque, defesa);
                } 
                else {
                robo = new roboEquilibrado(codigo, nome, ataque, defesa);
                }

                robos.add(robo);
            
                quantidadeRobos++; // aumenta a qtdade de robo cadastrado 

                System.out.println("Robô cadastrado com sucesso!");
                break;
            
            case 2:
            
                System.out.print("Informe o codigo do robo: ");
                int codigoBusca = s.nextInt();
                
                int encontrou = 0;
    
                for (robo r : robos) {

                if (r.getCodigo() == codigoBusca) /* procura pelo codigo */ {

                System.out.println("Codigo: " + r.getCodigo());
                System.out.println("Nome: " + r.getNome());
                System.out.println("Ataque: " + r.getAtaque());
                System.out.println("Defesa: " + r.getDefesa());
                System.out.println("Energia: " + r.getEnergiaAtual());
                System.out.println("Vitorias: " + r.getVitorias());
                System.out.println("Derrotas: " + r.getDerrotas());
                System.out.println("Pontos: " + r.getPontos());

                if (r.getEnergiaAtual() >= 30) {
                System.out.println("disponivel");
                } else {
                System.out.println("em recuperacao");
                }

                System.out.println("Tipo: " + r.getTipo());
                encontrou = 1;

                if (encontrou == 0) {
                System.out.println("Codigo nao encontrado!");
                }

                } //if
                }
            break;
            
            case 3: 
                
            for (robo r : robos) {

                if (quantidadeRobos == 0) {
                System.out.println("Nenhum robo cadastrado!");
                break;
                }

                System.out.println("Codigo: " + r.getCodigo());
                System.out.println("Nome: " + r.getNome());
                System.out.println("Ataque: " + r.getAtaque());
                System.out.println("Defesa: " + r.getDefesa());
                System.out.println("Energia: " + r.getEnergiaAtual());
                System.out.println("Vitorias: " + r.getVitorias());
                System.out.println("Derrotas: " + r.getDerrotas());
                System.out.println("Pontos: " + r.getPontos());

                if (r.getEnergiaAtual() >= 30) {
                System.out.println("disponivel");
                } else {
                System.out.println("em recuperacao");
                }

                }
            break;

            case 4:
            
                if (quantidadeRobos < 2){
                System.out.print("É necessario ter pelo menos dois robos cadastrados!");
                break;
                }

            int encontrouRobo1 = 0;
            int codigoRobo1 = 0;
            
            int encontrouRobo2 = 0;
            int codigoRobo2 = 0;

            while (encontrouRobo1 == 0 || encontrouRobo2 == 0 || codigoRobo1 == codigoRobo2){

                encontrouRobo1 = 0;
                encontrouRobo2 = 0;

                System.out.print("Informe o codigo do primeiro robo: ");
                codigoRobo1 = s.nextInt();

                System.out.print("Informe o codigo do segundo robo: ");
                codigoRobo2 = s.nextInt();

                if (codigoRobo1 == codigoRobo2) {

                System.out.println("Os robos precisam ser diferentes!");

            } else {

            for (robo r : robos) {

                if (r.getCodigo() == codigoRobo1) {
                    encontrouRobo1 = 1;
                }
                if (r.getCodigo() == codigoRobo2) {
                    encontrouRobo2 = 1;
                }

            }

                if (encontrouRobo1 == 0 || encontrouRobo2 == 0) {
                System.out.println("Um dos robos nao existe! Informe novamente.\n");
                }
            }
            } //while

            robo atacante; // para o robo que for atacar
            robo defensor; // para o robo que for defnder

            for (robo robo1 : robos) {
                if (robo1.getCodigo() == codigoRobo1) {
            
            for (robo robo2 : robos) {
                
                
                if (robo2.getCodigo() == codigoRobo2){
                if (robo1.getEnergiaAtual() < 30 || robo2.getEnergiaAtual() < 30){
                    System.out.print("Um dos robos estão em recuperação!");
                } 
                else{
                    System.out.print("Estão disponiveis para combate!");
                } 
                if (robo1.getPontos() < robo2.getPontos()) {
                    atacante = robo1;
                    defensor = robo2;
                }
                else if (robo2.getPontos() < robo1.getPontos()) {
                    atacante = robo2;
                    defensor = robo1;
                }
                else {
                    
                    if(robo1.getCodigo() < robo2.getCodigo()) {
                        atacante = robo1;
                        defensor = robo2;   
                    }
                    else {
                        atacante  = robo2;
                        defensor = robo1;   
                    }
                }
                for (int rodada = 1; rodada <= 5; rodada++) {
                    
                    System.out.println("Rodada " + rodada);
                    int dano = atacante.calcularAtaque() - defensor.getDefesa();
                    
                    if (dano < 5){
                        dano = 5;
                    }
                    if (rodada % 2 == 0){ // *Nas rodadas pares, o dano calculado receberá um bônus de 5.
                        dano = dano + 5;
                    }
                    dano = defensor.reduzirDanoRecebido(dano);
                    defensor.perderEnergia(dano);
                    System.out.println(atacante.getNome() + " atacou " + defensor.getNome());
                    System.out.println("Dano causado: " + dano);
                    System.out.println("Energia restante " + defensor.getEnergiaAtual());
                }
            } 
            }   
            }
            }
            break;

            case 5:

                if (quantidadeRobos == 0) {
                System.out.println("Nenhum robo cadastrado!");
                break;
                 }

            System.out.print("Informe o codigo do robo que deseja recuperar: ");
            int codigoRecuperar = s.nextInt();

            int encontrouRecuperar = 0;

            for (robo r : robos) {

            if (r.getCodigo() == codigoRecuperar) {

            r.recuperarEnergia(30);

            System.out.println("Energia recuperada com sucesso!");
            System.out.println("Energia atual: " + r.getEnergiaAtual());

            encontrouRecuperar = 1;
            }
            }

            if (encontrouRecuperar == 0) {
            System.out.println("Codigo nao encontrado!");
            }
            break;

            case 6: 
            
            ArrayList<robo> participantes = new ArrayList<>();

            int quantidadeDisponiveis = 0;

            for (robo r : robos) {
                if (r.getEnergiaAtual() >= 30) {
                participantes.add(r);
                quantidadeDisponiveis++;
            }
            }

            if (quantidadeDisponiveis < 2) {
                System.out.println("Nao existem robos suficientes!");
            break;
            }

                
            } // SWITCH

    } while (option !=0);


    } // static

} // class

