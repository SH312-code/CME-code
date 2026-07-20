import java.math.BigDecimal;
import java.math.RoundingMode;

public class CMEsInMonth {
    private final String date;
    private int CMECount;
    private BigDecimal totalCMEEnergy;

    public CMEsInMonth(String date) {
        this.date = date;
        CMECount = 0;
        totalCMEEnergy = BigDecimal.ZERO;
    }

    public String getDate() {
        return date;
    }

    public void addCME(BigDecimal KE) {
        totalCMEEnergy = totalCMEEnergy.add(KE);
        CMECount++;
    }

    public BigDecimal getTotalCMEEnergy() {
        return totalCMEEnergy;
    }

    public BigDecimal getMeanCMEEnergy() {
        try {
            return totalCMEEnergy.divide(BigDecimal.valueOf(CMECount), 5, RoundingMode.HALF_DOWN);
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }
}
