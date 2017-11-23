package blueground.test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;

public class FileGenerator {

    public static void createFile(String TableData) throws Exception {
        File file = new File("test.txt");
        FileUtils.writeStringToFile(file, TableData, Charset.forName("UTF-8"));

    }
}
