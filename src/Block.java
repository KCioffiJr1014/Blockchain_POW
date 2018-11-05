import java.util.ArrayList;
import java.util.Date;

public class Block {
    private String hash;
    private String input;
    private String previousHash;
    private ArrayList transactions;
    //private blockHeader headerData;
    private long timestamp;
    private int noonce;

    public Block(String data, String previousHash) {
        this.transactions = new ArrayList();
        //this.headerData = headerData;
        this.hash = calculateHash();
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
    }

    public String calculateHash() {
        String calculatedhash = StringEncrypt.applySHA256(
                previousHash +
                        Long.toString(timestamp) +
                        input
        );
        return calculatedhash;
    }

}
