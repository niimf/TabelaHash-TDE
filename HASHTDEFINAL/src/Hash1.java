public class Hash1 extends TabelaHash {

    public Hash1(int tamanho) {
        super(tamanho);
    }

    @Override
    public int calcularHash(String valor) {
        int hash = 0;
        for (int i = 0; i < valor.length(); i++) {
            hash += valor.charAt(i);
        }
        return hash % tabela.length;
    }
}
