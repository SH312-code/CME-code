import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class MakeCSV {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner s = new Scanner(new File("SN_m_tot_V2.0.csv"));
        ArrayList<String> dates = new ArrayList<String>();
        FileWriter fw = new FileWriter("Sunspots.csv",false);
        fw.write("Date, Mean Sunspot count\n");
        while (s.hasNext()) {
            String temp = s.nextLine();
            fw.write(temp.split(";")[0] + "/" + temp.split(";")[1] + "," + temp.split(";")[3]+"\n");
        }
        fw.close();
        s.close();
    }
}
//for(String date: dates) System.out.println(date);

//System.out.println();

//    s = new Scanner(new File("data.txt"));
//    ArrayList<String> energy = new ArrayList<String>();
//    while(s.hasNext()){
//        String temp = s.nextLine();
//        energy.add(temp.substring(87,94));
//    }
//    s.close();
//    //for(String e: energy) System.out.println(e);
//    //System.out.println(energy.size());
//    //System.out.println(dates.size());
//
//    FileWriter fw = new FileWriter("CME_Date_KE.csv",true);
//
//    for(int i = 0; i<dates.size(); i++){
//        fw.write(dates.get(i) + "," + energy.get(i)+"\n");
//    }
//    fw.close();
//  }

