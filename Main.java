import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("CME_Date_KE.csv"));
        ArrayList<CMEsInMonth> CMEs= new ArrayList<>();
        while(s.hasNextLine()){
            String[] temp = s.nextLine().split(",");
            String KE = temp[1];
            String date = temp[0].split("/")[0] +"/"+ temp[0].split("/")[1];
            CMEsInMonth monthData = null;
            for(CMEsInMonth a : CMEs){
                if (a.getDate().equals(date)){
                    monthData = a;
                    break;
                }
            }
            if (monthData == null){
                monthData = new CMEsInMonth(date);
                CMEs.add(monthData);
            }
            if (!KE.equals("-------")){
                monthData.addCME(new BigDecimal(KE));
            }
        }

        System.out.println("Date       Total CME Energy             Mean CME Energy");
        for(CMEsInMonth a: CMEs){
            System.out.println(a.getDate() + "\t" + a.getTotalCMEEnergy() + "\t"+a.getMeanCMEEnergy());
        }

//        FileWriter fw = new FileWriter("CME_Data_Month_TotalKE_MeanKE_Count.csv",true);
//        for(CMEsInMonth a: CMEs){
//            fw.write(a.getDate() + "," + a.getTotalCMEEnergy() + ","+a.getMeanCMEEnergy() +","+ a.getCMECount() + "\n");
//        }
//        fw.close();

        FileWriter fw = new FileWriter("CME_Data_Month_A-E_scale.csv",true);
        fw.write("Date,Type A count,Type B count,Type C count,Type D count,Type E count\n");
        for(CMEsInMonth a: CMEs){
            fw.write(a.getDate() + "," + a.getAcount() + ","+a.getBcount() +","+ a.getCcount()+","+a.getDcount() + ","+a.getEcount() + "\n");
        }
        fw.close();
    }
}
