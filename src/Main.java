import java.io.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("I:\\words\\CatchMeIfYouCan_BDRip.txt");

        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        byte[] buffer = new byte[1024];
        int len = 0;
        String s = null;
        Pattern pattern=Pattern.compile("[0-9]*");
        while ((s = br.readLine()) != null) {
            if (!"".equals(s.trim()) && !s.trim().startsWith("0") && !pattern.matcher(s).matches()) {
                s=s.replace("\"", "");
                System.out.println(s);
            }

        }
        fis.close();
        br.close();
    }
}
