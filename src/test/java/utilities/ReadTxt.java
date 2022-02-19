package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadTxt {


    public static List<String> petStatusData(String filename){
        List<String> ssnList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line  = br.readLine();
            while (line != null){
                // String ssn = line.split(",")[0]; sadece ssn veriyor
                ssnList.add(line.split(",")[4]);

                line=br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ssnList;

    }
    public static List<String> petStatusId(String filename){
        List<String> idList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line  = br.readLine();
            while (line != null){
                // String ssn = line.split(",")[0]; sadece ssn veriyor
                idList.add(line.split(",")[0]);
                line=br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return idList;
    }
    public static List<String> returnUserUserName(String fileName02){
        List<String> userName = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName02))) {
            String line  = br.readLine();
            while (line != null){
                // String userName = line.split(",")[4]; sadece username veriyor
                userName.add(line.split(",")[0]);
                line = br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return userName;
    }
    public static List<String> returnUserEmail(String fileName02){
        List<String> email = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName02))) {
            String line  = br.readLine();
            while (line != null){
                // String email = line.split(",")[5]; sadece email veriyor
                email.add(line.split(",")[1]);
                line = br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return email;
    }
    public static List<String> returnUserSsn (String fileName){
        List<String> email = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line  = br.readLine();
            while (line != null){
                // String email = line.split(",")[5]; sadece email veriyor
                email.add(line.split(",")[0]);
                line = br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return email;
    }
}