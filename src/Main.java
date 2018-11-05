import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Block> blockchain = new ArrayList<>();
    public static int difficulty = 0;

    public static void main(String[] args) {
        blockchain.add(new Block("Genesis", "0"));
        System.out.println("Attempting to mine genesis block... ");
        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block("Mining block 2", blockchain.get(blockchain.size() - 1).hash));
        System.out.println("Mining block 2... ");
        blockchain.get(1).mineBlock(++difficulty);

        blockchain.add(new Block("Mining block 3", blockchain.get(blockchain.size() - 1).hash));
        System.out.println("Mining block 3... ");
        blockchain.get(2).mineBlock(++difficulty);


        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nBlockchain: ");
        System.out.println(blockchainJson);


    }
}
