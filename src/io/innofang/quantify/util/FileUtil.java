package io.innofang.quantify.util;

import java.io.*;

/**
 * Created by Inno Fang on 2017/6/7.
 */
public class FileUtil {

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
