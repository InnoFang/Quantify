package io.innofang.quantify.util;

import java.io.*;

/**
 * Created by Inno Fang on 2017/6/7.
 */
public class FileUtil {

    public static final String TEMP_FILE_NAME = "temp_file.txt";

    public static String getFileContent(File file) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            StringBuilder sb = new StringBuilder();
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
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


    public static void writeFileContent(String content) {
        System.out.println(content);
        File file = new File(TEMP_FILE_NAME);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(content);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(bw);
            closeQuietly(fw);
        }


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
