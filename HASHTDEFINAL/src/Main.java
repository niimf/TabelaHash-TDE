import java.util.List;

public class Main {
    public static void main(String[] args) {
        String caminhoArquivo = "female_names.txt"; // ou PATH FROM CONTENT ROOT
        RCSV rcsv = new RCSV(caminhoArquivo);

        List<String> nomes = rcsv.lerArquivo();
        if (nomes.isEmpty()) {
            System.out.println("Erro: Arquivo vazio ou não encontrado.");
            return;
        }

        int tamanhoTabela = 8000;
        TabelaHash tabelaSimples = new Hash1(tamanhoTabela);
        TabelaHash tabelaAvancada = new Hash2(tamanhoTabela);

        long inicio, fim;

        // Inserção - Tabela Simples
        System.out.println("Iniciando inserção na tabela simples...");
        inicio = System.nanoTime();
        for (String nome : nomes) {
            tabelaSimples.inserir(nome);
        }
        fim = System.nanoTime();
        long tempoInsercaoSimples = fim - inicio;

        // Inserção - Tabela Avançada
        System.out.println("Iniciando inserção na tabela avançada...");
        inicio = System.nanoTime();
        for (String nome : nomes) {
            tabelaAvancada.inserir(nome);
        }
        fim = System.nanoTime();
        long tempoInsercaoAvancada = fim - inicio;

        // Busca - Tabela Simples
        System.out.println("Iniciando busca na tabela simples...");
        inicio = System.nanoTime();
        for (String nome : nomes) {
            tabelaSimples.buscar(nome);
        }
        fim = System.nanoTime();
        long tempoBuscaSimples = fim - inicio;

        // Busca - Tabela Avançada
        System.out.println("Iniciando busca na tabela avançada...");
        inicio = System.nanoTime();
        for (String nome : nomes) {
            tabelaAvancada.buscar(nome);
        }
        fim = System.nanoTime();
        long tempoBuscaAvancada = fim - inicio;

        // Geração do Relatório
        System.out.println("\nRelatório de Desempenho:");
        rcsv.gerarRelatorio("Tabela Simples", tabelaSimples, tempoInsercaoSimples, tempoBuscaSimples);
        rcsv.gerarRelatorio("Tabela Avançada", tabelaAvancada, tempoInsercaoAvancada, tempoBuscaAvancada);
    }
}
