import org.apache.commons.cli.CommandLine;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Wc {
    private static String readFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        char[] content = new char[(int) file.length()];
        fr.read(content);
        fr.close();
        return new String(content);
    }

    private static HashMap<String, int[]> getWcOf(String[] files) throws Exception {
        int[] total = {0, 0, 0}; // order is line,word,byte
        WcLib wc = new WcLib();
        HashMap<String, int[]> hm = new HashMap<>();
        for (String file : files) {
            String content = readFile(file);
            int[] counts = wc.countAll(content); // order is line,word,byte
            for (int i = 0; i < 3; i++)
                total[i] += counts[i];
            hm.put(file, counts);
        }
        hm.put("Total", total);
        return hm;
    }

    private static void present(HashMap<String, int[]> i) {
        for (Map.Entry<String, int[]> entry : i.entrySet()) {
            System.out.println("entry = " + entry);
        }
    }

    public static void main(String[] args) throws Exception {
        // getting command line options and files...
        Cli cli = new Cli(args);
        CommandLine cmds = cli.parse();
        String[] files = cmds.getArgs();

        // getting word count for all files...
        HashMap<String, int[]> wcOfAll = getWcOf(files);
        present(wcOfAll);
    }
}
