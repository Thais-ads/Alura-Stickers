import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {



        //fazer uma conexão http e buscar os top 250 filmes.

        String url ="https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        // Pegando o endpoint e salvando em uma variavel url.
        //fazendo a identificaçao do nosso endpoint;
        URI endereco = URI.create(url);
        var client =HttpClient.newHttpClient();
        //construindo o request e associando a URL que esta no endereco e em seguida adicionar o argumento get.
        HttpRequest request= HttpRequest.newBuilder(endereco).GET().build();
        //executando o request
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);



        //pegar só os dados que interessam (titulo, poster, classificacao).
        var parser= new JsonParse();
        List<Map<String, String>> ListDeFilmes = parser.parse(body);

        //lista quantos filmes tem no json
        System.out.println(ListDeFilmes.size());




        // exibir e manipular os dados.

        for ( Map<String,String>filmes: ListDeFilmes) {
            System.out.println(filmes.get("title"));
            System.out.println(filmes.get("image"));
            System.out.println(filmes.get("imDbRating"));
        }
        }
    }
