package com.yavdev.section8;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = tonerLevel > -1 && tonerLevel <= 100 ? tonerLevel : -1;
        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int addToner(int tonerAmount) {
        int newTonerLevel = tonerAmount + this.tonerLevel;

        if(tonerAmount > 0 && tonerAmount <= 100 && newTonerLevel > 0 && newTonerLevel <= 100) {
            this.tonerLevel = newTonerLevel;

            return this.tonerLevel;
        }

        return -1;
    }

    public int printPages(int pages) {
        int pagesToPrint = duplex ? ((pages / 2) + (pages % 2)) : pages;

        this.pagesPrinted += pagesToPrint;

        return pagesToPrint;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
