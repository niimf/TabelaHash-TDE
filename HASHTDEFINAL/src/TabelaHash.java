public abstract class TabelaHash {
    protected String[] tabela;
    protected int colisoes;
    protected int tamanhoAtual;

    public TabelaHash(int tamanho) {
        this.tabela = new String[tamanho];
        this.colisoes = 0;
        this.tamanhoAtual = 0;
    }

    public void inserir(String valor) {
        if (getFatorDeCarga() >= 0.7) {
            redimensionarTabela();
        }

        int index = calcularHash(valor);
        while (tabela[index] != null) {
            colisoes++;
            index = (index + 1) % tabela.length;
        }
        tabela[index] = valor;
        tamanhoAtual++;
    }

    private void redimensionarTabela() {
        System.out.println("Redimensionando a tabela de tamanho " + tabela.length + " para " + tabela.length * 2);
        String[] antigaTabela = tabela;
        tabela = new String[antigaTabela.length * 2];
        tamanhoAtual = 0;
        colisoes = 0;

        for (String valor : antigaTabela) {
            if (valor != null) {
                inserir(valor);
            }
        }
    }

    public boolean buscar(String valor) {
        int index = calcularHash(valor);
        int inicio = index;

        while (tabela[index] != null) {
            if (tabela[index].equals(valor)) {
                return true;
            }
            index = (index + 1) % tabela.length;
            if (index == inicio) {
                break;
            }
        }
        return false;
    }

    public double getFatorDeCarga() {
        return (double) tamanhoAtual / tabela.length;
    }

    public abstract int calcularHash(String valor);

    public int getColisoes() {
        return colisoes;
    }

    public void exibirDistribuicao() {
        int[] distribuicao = new int[tabela.length];
        for (String elemento : tabela) {
            if (elemento != null) {
                int index = calcularHash(elemento);
                distribuicao[index]++;
            }
        }
        System.out.println("Distribuição das chaves na tabela:");
        for (int i = 0; i < distribuicao.length; i++) {
            if (distribuicao[i] > 0) {
                System.out.println("Posição " + i + ": " + distribuicao[i] + " elementos");
            }
        }
    }
}
