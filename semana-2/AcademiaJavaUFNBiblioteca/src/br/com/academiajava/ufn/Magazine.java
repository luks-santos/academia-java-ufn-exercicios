package br.com.academiajava.ufn;

public class Magazine implements Imprimivel {

    private String title;
    private String company;
    private int edition;
    private boolean borrowed;
    private int numberOfCopies;

    public Magazine(String title, String company, int edition, int numberOfCopies) {
        this.title = title;
        this.company = company;
        this.edition = edition;
        this.numberOfCopies = numberOfCopies;
        this.borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public boolean reserve() {
        if (borrowed) {
            return false;
        }
        setBorrowed(true);
        return true;
    }

    public boolean returnMagazine() {
        if (!borrowed) {
            return false;
        }
        setBorrowed(false);
        return true;
    }

    @Override
    public boolean imprimir() {
        if (!borrowed) {
            this.numberOfCopies++;
        }
        return false;
    }

    @Override
    public String toString() {
        String info = "Magazine:" +
                ", Title: " + title +
                ", Company: '" + company +
                ", Edition: " + edition +
                ", Number of Copies: " + numberOfCopies;
        if (borrowed) {
            info += ", (Borrowed)";
        } else {
            info += ",(Available)";
        }
        return info;
    }
}
