package ConsultaCep.Principal;

import ConsultaCep.Modulos.Ceps;
import ConsultaCep.Modulos.ConsultaCep;
import ConsultaCep.Modulos.GeradorDeArquivo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner ler = new Scanner(System.in);
        List<Ceps> listaCeps = new ArrayList<>();



        while (true) {
            System.out.println("Digite o numero do Cep com 9 digitos (ou 'parar' para encerrar o programa: ");
            String cep = ler.nextLine();
            if (cep.equalsIgnoreCase("parar")){
                break;
            }

            try {


            ConsultaCep consultaCep = new ConsultaCep();
            Ceps novoCep = consultaCep.buscaCep(cep);
            System.out.println(novoCep);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(novoCep);

            listaCeps.add(novoCep);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando aplicação");
            }

        }
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter escrita = new FileWriter("listaCepsProcurados.json");
        escrita.write(gson.toJson(listaCeps));
        escrita.close();

        System.out.println("Programa finalizou corretamente!");

    }
}
