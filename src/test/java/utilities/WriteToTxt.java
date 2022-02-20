package utilities;

import pojos.petStatusOut;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToTxt {
    public static void PetApiData(String fileName, petStatusOut[] petStatusOuts) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (int i = 0; i < petStatusOuts.length; i++) {
                if (petStatusOuts[i] != null) {
                    writer.append(petStatusOuts[i].getId() + ",\n");
                            if(petStatusOuts[i].getPetStatusInner() !=null) {
                                writer.append(  petStatusOuts[i].getPetStatusInner().getId()
                                        + "," + petStatusOuts[i].getPetStatusInner().getName() + ",\n");
                }else{
                        writer.append("\n");
                    }
                }
            }
            writer.close();
            petStatusOut petStatusOut1 = new petStatusOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void PetPendingData(String fileName, petStatusOut[] petStatusOuts) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (int i = 0; i < petStatusOuts.length; i++) {
                if (petStatusOuts[i] != null) {
                    writer.append(petStatusOuts[i].getId() + ",\n");
                    if(petStatusOuts[i].getPetStatusInner() !=null) {
                        writer.append(  petStatusOuts[i].getPetStatusInner().getId()
                                + "," + petStatusOuts[i].getPetStatusInner().getName() + ",\n");
                    }else{
                        writer.append("\n");
                    }
                }
            }
            writer.close();
            petStatusOut petStatusOut1 = new petStatusOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




