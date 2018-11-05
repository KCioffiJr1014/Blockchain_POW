//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Date;

public class blockHeader {
    public long timeStamp;
    private int targetDifficulty;
    private String previousHash = "0";

    public blockHeader() {
        this.targetDifficulty = this.targetDifficulty * (int) System.currentTimeMillis() / 2016 * 10;
        this.timeStamp = (new Date()).getTime();
    }

    public String toString() {
        String store = "Block generated on ";
        store += this.timeStamp;
        return store;
    }
}
