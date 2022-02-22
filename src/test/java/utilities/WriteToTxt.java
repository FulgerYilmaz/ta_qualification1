package utilities;

import pojos.petStatusOut;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToTxt {

    public static void petApiData(String fileName, petStatusOut[] petStatusOuts) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (int i = 0; i < petStatusOuts.length; i++) {
                if (petStatusOuts[i] != null) {
                    writer.append(petStatusOuts[i].getId() + ",");
                } else {
                    writer.append("\n");
                }
            }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




