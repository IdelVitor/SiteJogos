package br.com.idel.site_jogos.Jogos.Service;

import br.com.idel.site_jogos.Jogos.Model.Jogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JogoService {

        @Autowired
        private RestTemplate restTemplate;

        private final String apiKey = "SUA_API_KEY_AQUI";

        public List<Jogo> buscarJogo(String nomeJogo) {
            String url = "https://api.rawg.io/api/games?key=" + apiKey + "&search=" + nomeJogo;

            Map<String, Object> resposta = restTemplate.getForObject(url, Map.class);
            List<Map<String, Object>> resultados = (List<Map<String, Object>>) resposta.get("results");

            List<Jogo> jogos = new ArrayList<>();

            for (Map<String, Object> jogo : resultados) {
                String nome = (String) jogo.get("name");
                String imagem = (String) jogo.get("background_image");
                String dataLancamento = (String) jogo.get("released");

                String plataforma = "";
                List<Map<String, Object>> plataformas = (List<Map<String, Object>>) jogo.get("platforms");
                if (plataformas != null && !plataformas.isEmpty()) {
                    Map<String, Object> plataformaObj = (Map<String, Object>) plataformas.get(0).get("platform");
                    plataforma = (String) plataformaObj.get("name");
                }

                jogos.add(new Jogo(nome, imagem, dataLancamento, plataforma));
            }
            return jogos;
        }
}
