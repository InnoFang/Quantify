package io.innofang.quantify.util;

import java.io.*;

/**
 * Created by Inno Fang on 2017/6/7.
 */
public class FileUtil {

    public static final String TEMP_FILE_NAME = "temp.txt";

    public static String getFileContent(File file) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            StringBuilder sb = new StringBuilder();
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = null;
            if ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeQuietly(fr);
            closeQuietly(br);
        }
        return "";
    }


    public static void writeFileContent(String content) throws IOException {
        File file = new File(TEMP_FILE_NAME);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.flush();
        bw.close();
        fw.close();
    }



    public static void closeQuietly(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
