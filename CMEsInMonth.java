import java.math.BigDecimal;
import java.math.RoundingMode;

public class CMEsInMonth {
    private final String date;
    private int CMECount;
    private BigDecimal totalCMEEnergy;
    private int Acount;
    private int Bcount;
    private int Ccount;
    private int Dcount;
    private int Ecount;

    public CMEsInMonth(String date) {
        this.date = date;
        CMECount = 0;
        totalCMEEnergy = BigDecimal.ZERO;
        Acount = 0;
        Bcount = 0;
        Ccount = 0;
        Dcount = 0;
        Ecount = 0;
    }

    public String getDate() {
        return date;
    }

    public void addCME(BigDecimal KE) {
        totalCMEEnergy = totalCMEEnergy.add(KE);
        CMECount++;
        double L = (Math.log10(KE.doubleValue()/Math.pow(10,23)));
        if (L <= 2) {
            Acount++;
        } else if (L <= 4) {
            Bcount++;
        } else if (L <= 6) {
            Ccount++;
        } else if (L <= 8) {
            Dcount++;
        } else {
            Ecount++;
        }
    }

    public BigDecimal getTotalCMEEnergy() {
        return totalCMEEnergy;
    }

    public int getAcount() {
        return Acount;
    }

    public int getBcount() {
        return Bcount;
    }

    public int getCcount() {
        return Ccount;
    }

    public int getDcount() {
        return Dcount;
    }

    public int getEcount() {
        return Ecount;
    }

    public BigDecimal getMeanCMEEnergy() {
        try {
            return totalCMEEnergy.divide(BigDecimal.valueOf(CMECount), 5, RoundingMode.HALF_DOWN);
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    public int getCMECount() {
        return CMECount;
    }
}
