package ConsultaCep.Modulos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {

    public void salvaJson (Ceps ceps) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter escrita = new FileWriter(ceps.cep() + ".json");
        escrita.write(gson.toJson(ceps));
        escrita.close();
    }
}
