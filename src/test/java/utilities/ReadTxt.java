package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
public class ReadTxt {

    public static List<String> petStatusData(String filename) {
        List<String> ssnList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            while (line != null) {
                ssnList.add(line.split(",")[1]);

                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ssnList;
    }
    public static List<String> petStatusId(String fileNameSold) {
        List<String> idList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileNameSold))) {
            String line = br.readLine();
            while (line != null) {
                idList.add(line.split(",")[0]);
                idList.add(line.split(",")[1]);
                idList.add(line.split(",")[2]);
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idList;
    }
}