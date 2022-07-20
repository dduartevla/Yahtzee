package ufjf.dcc.debora.yahtzee;


import java.util.Arrays;
import java.util.List;


public class CalculaJogadas {

    int[] dados = new int[5];

    public CalculaJogadas(List<Integer> Ldados){
        for (int i=0; i<Ldados.size();i++){
            this.dados[i] = Ldados.get(i);
        }

    }

    public int jogadaNum(int num){

        int resultado = 0;

        for (int i=0; i<dados.length; i++){
            if (dados[i] == num){
                resultado+=num;
            }
        }

        return resultado;
    }

    public int trinca(){

        for (int num=1; num<7;num++){
            int cont = 0;
            for (int i=0; i<dados.length; i++){
                if (dados[i] == num){
                    cont++;
                }
            }
            if (cont ==3){ //faz a soma dos valores dos dados se existe uma trina
                int soma =0;

                for (int j=0;j< dados.length;j++){
                    soma+= dados[j];
                }
                return soma;
            }
        }

        return 0;
    }

    public int quadra(){

        for (int num=1; num<7;num++){
            int cont = 0;
            for (int i=0; i<dados.length; i++){
                if (dados[i] == num){
                    cont++;
                }
            }
            if (cont ==4){ //faz a soma dos valores dos dados se existe uma trinca
                int soma =0;

                for (int j=0;j< dados.length;j++){
                    soma+= dados[j];
                }
                return soma;
            }
        }

        return 0;
    }

    public int fullHouse(){

        if (trinca() != 0){

            //os dois numeros diferentes do número da trinca
            int primeiro = -1;
            int segundo = -1;


            for (int num=1; num<7;num++){
                int cont = 0;
                for (int i=0; i<dados.length; i++){
                    if (dados[i] == num){
                        cont++;
                    }
                }
                if (cont ==3){ //faz a soma dos valores dos dados se existe uma trina

                    for (int i=0; i<dados.length; i++){
                        if (dados[i] != num){
                            if (primeiro ==-1){
                                primeiro = dados[i];
                            }
                            else if (segundo == -1){
                                segundo = dados[i];
                            }
                        }
                    }
                }
            }

            if (primeiro == segundo){ return 25;}
            else  return 0; // e uma trinca mas não tem um par


        } else { return 0; }

    }

    public int sequenciaBaixa(){

        int[] auxdados = dados;
        Arrays.sort(auxdados);

        int prox;
        for (int i=0; i< auxdados.length; i++){
            System.out.println(auxdados[i]);
            prox = i;
            if (auxdados[i] != prox+1){
                return 0;
            }
        }
        return 40;
    }

    public int sequenciaAlta(){
        int[] auxdados = dados;
        Arrays.sort(auxdados);

        int prox;
        for (int i=0; i< auxdados.length; i++){
            //System.out.println(auxdados[i]);
            prox = i;
            if (auxdados[i] != prox+2){
                return 0;
            }
        }
        return 40;
    }

    public int general(){
        int num = dados[0];
        //System.out.println(dados[0] + "dados[0]");
        for (int i=0; i<dados.length;i++){
            //System.out.println(dados[i] + "dados["+i+"]");
            if (dados[i] != num){
                return 0;
            }
        }
        return 50;
    }

}
