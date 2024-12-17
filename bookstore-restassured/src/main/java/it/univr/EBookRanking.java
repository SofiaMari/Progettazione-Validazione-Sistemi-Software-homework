package it.univr;

public class EBookRanking {
    private String bookTitle;
    private int monthlyReaders;

    public EBookRanking(String bookTitle, int monthlyReaders) {
        this.bookTitle = bookTitle;
        this.monthlyReaders = monthlyReaders;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getMonthlyReaders() {
        return monthlyReaders;
    }

    public void setMonthlyReaders(int monthlyReaders) {
        this.monthlyReaders = monthlyReaders;
    }
}