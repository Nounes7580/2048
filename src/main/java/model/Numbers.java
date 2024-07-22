package model;

/**
 *
 * @author younes
 */
public class Numbers {

    private static final int[] valeurs = {0, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};
    private int rank;
    private String str;

    public Numbers() {
        this.rank = 0;
        str = "    ";
    }

    /**
     *
     * @return str;
     */
    @Override
    public String toString() {
        return str;
    }

    /**
     * method that allows to multiply by 2 the value that merges
     */
    public void split() {
        rank++;

        switch (rank) {
            case 0:
            case 1:
            case 2:
            case 3:
                str = "   " + valeurs[rank];
                break;
            case 4:
            case 5:
            case 6:
                str = "  " + valeurs[rank];
                break;
            case 7:
            case 8:
            case 9:
                str = " " + valeurs[rank];
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                str = "" + valeurs[rank];
                break;
        }
    }

    public int getRank() {
        return this.rank;
    }

    /**
     * method that allows you to change the value manually
     *
     * @param rankOther
     */
    public void setValeur(int rankOther) {
        this.rank = rankOther;

        switch (rank) {
            case 0:
            case 1:
            case 2:
            case 3:
                str = "   " + valeurs[rank];
                break;
            case 4:
            case 5:
            case 6:
                str = "  " + valeurs[rank];
                break;
            case 7:
            case 8:
            case 9:
                str = " " + valeurs[rank];
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                str = "" + valeurs[rank];
                break;
        }
    }

    public int getValeur() {
        return valeurs[rank];
    }
}
