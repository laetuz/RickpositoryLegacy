package id.neotica.rickpositorylegacy.domain;

public class InfoModel {
    private final int count;
    private final int pages;
    private final String next;
    private final String prev; // Can be null

    public InfoModel(int count, int pages, String next, String prev) {
        this.count = count;
        this.pages = pages;
        this.next = next;
        this.prev = prev;
    }
}
