package utilities;

import pojos.petStatusOut;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class WriteToTxt {




    public static void saveDBUserData(String fileName, List<Object> actualData) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (int i = 0; i < actualData.size(); i++) {
                writer.append(actualData.get(i) + ",\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveDBUsernameAndEmailDBData(String fileName, List<Object> emails, List<Object> logins) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, false);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            int loginSize = logins.size();
            //System.out.println(loginSize);
            int emailsSize = emails.size();
            //System.out.println(emailsSize);

            if (loginSize >= emailsSize) {
                for (int i = 0; i < loginSize; i++) {
                    writer.append(logins.get(i) + ",");

                    if (emailsSize <= loginSize + 1) {
                        writer.append(emails.get(i) + ",\n");
                    }

                }
            } else {

                for (int i = 0; i < emailsSize; i++) {
                    writer.append(emails.get(i) + ",");

                    if (loginSize <= emailsSize + 1) {
                        writer.append(logins.get(i) + ",\n");
                    }
                }
            }

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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




