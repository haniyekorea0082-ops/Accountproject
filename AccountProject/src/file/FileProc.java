package file;

import dto.AccountDto;
import single.Singleton;
import java.io.*;

public class FileProc {
    private java.io.File file;

    public FileProc(String name) {
        file = new java.io.File("c:/tmp/" + name + ".txt");
        try {
            file.getParentFile().mkdirs();
            if (!file.exists()) file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fileSave() {
        try (java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.FileWriter(file)))) {
            for (AccountDto d : Singleton.getInstance().list) {
                pw.println(d.getDataLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fileLoad() {
        if (!file.exists()) return;
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split("-");
                if (p.length < 6) continue;
                AccountDto dto = new AccountDto(p[0],
                        Integer.parseInt(p[1]), p[2], p[3], p[4], p[5]);
                Singleton.getInstance().list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}