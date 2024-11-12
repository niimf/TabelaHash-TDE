import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RCSV {
    private final String caminhoArquivo;

    public RCSV(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public List<String> lerArquivo() {
        List<String> nomes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    nomes.add(linha.trim());
                }
            }
            System.out.println("Arquivo lido com sucesso. Total de nomes: " + nomes.size());
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return nomes;
    }

    public void gerarRelatorio(String nomeTabela, TabelaHash tabela, long tempoInsercao, long tempoBusca) {
        System.out.println("\n" + nomeTabela + ":");
        System.out.println("Tempo de inserção: " + tempoInsercao + " ns");
        System.out.println("Tempo de busca: " + tempoBusca + " ns");
        System.out.println("Número de colisões: " + tabela.getColisoes());
        tabela.exibirDistribuicao();
    }
}
