import java.util.ArrayList;
import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    private String data;
    //public CoinbaseTransaction coinbaseTransaction;
    private ArrayList transactions;
    private long timestamp;
    private int nonce;

    /**
     * @param data         - input source for encryption
     * @param previousHash - previous encrypted hash
     * @field hash - encrypts all data going into the block
     * @field timestamp - stamps a date
     * @field transactions - all the transactions within the block
     */
    public Block(String data, String previousHash) {
        this.transactions = new ArrayList();
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
        //this.coinbaseTransaction = new CoinbaseTransaction();
        this.hash = calculateHash(); // To be added after all fields
    }

    public String getHash() {
        return hash;
    }


    /**
     * Calculate hash
     *
     * @return encrypted hash for blocks
     */
    public String calculateHash() {
        String calculatedhash = StringEncrypt.applySHA256(
                previousHash +
                        Long.toString(timestamp) +
                        data
        );
        return calculatedhash;
    }

    /**
     * mineBlock
     *
     * @param difficulty 1. Takes hash and generates a target value
     *                   2. Any null values will be replaced with zeros
     *                   3. The algorithm will begin counting number of nonces
     */
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }


    /**
     public String toString() {
     String store = "";
     store += "Transactions: " + this.transactions + "\n";
     store += "Input data: " + this.data + "\n";
     store += "Hash output: " + this.hash + "\n";
     store += "Previous Hash: " + this.previousHash + "\n";
     store += "Generation time: " + this.timestamp;
     return store;
     }
     */
}
