package mc322.lab06;

import mc322.lab06.componentes.*;
import java.util.List;
import java.util.ArrayList;


public class Sala {
    boolean explorada = false;
    List<Componente> listaComponentes;
    Sala(){
        listaComponentes = new ArrayList<>();
    }


    Componente[] getComponentes(){
        Componente componentes[] = new Componente[listaComponentes.size()];
        for (int i=0;i<listaComponentes.size();i++){
            componentes[i]=listaComponentes.get(i);
        }
        return componentes;
    }

    Componente componenteMaiorPrioridade(){
        int maiorP = -10;
        Componente componente = null;
        for(int i = 0;i<listaComponentes.size();i++){
            if(Caverna.dicionarioPrioridades.get(listaComponentes.get(i).getIdentificador())>maiorP){
				maiorP = Caverna.dicionarioPrioridades.get(listaComponentes.get(i).getIdentificador());
				componente = listaComponentes.get(i);
			}
        }
		return componente;
    }

    String String(){
        if(explorada){
            if(listaComponentes.size()>0){
                return componenteMaiorPrioridade().toString();
            }else{
                return "#";
            }
        }else{
            return "-";
        }
    }

    void adicionarComponente(Componente componente){
        listaComponentes.add(componente);
    }
    void setExplorada(boolean b){
        this.explorada = b;
    }
    boolean isExplorada(){
        return this.explorada;
    }
    
}
