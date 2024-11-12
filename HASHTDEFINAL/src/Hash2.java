public class Hash2 extends TabelaHash {

    public Hash2(int tamanho) {
        super(tamanho);
    }

    @Override
    public int calcularHash(String valor) {
        int hash = 0;
        int peso = 31;

        for (int i = 0; i < valor.length(); i++) {
            hash = peso * hash + valor.charAt(i);
        }
        return Math.abs(hash) % tabela.length;
    }
}
