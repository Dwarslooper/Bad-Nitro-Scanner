package expert.kiwi.code.nitro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    // write your code here

        int delay;
        int maxURLs;
        boolean shouldOpenOnSuccess;
        boolean checkAll;
        File fileLocation;

        try {
            delay = Integer.parseInt(args[0]);
            maxURLs = Integer.parseInt(args[1]);
            shouldOpenOnSuccess = Boolean.parseBoolean(args[2]);
            checkAll = Boolean.parseBoolean(args[3]);
            fileLocation = new File(args[4]);
        } catch (Exception e) {
            System.out.println("Error: Arguments incorrent! <Delay (Integer)> <MaxScans (Integer)> <ShouldOpenOnSuccess (Boolean)>");
            return;
        }

        if(!fileLocation.exists()) {
            fileLocation = new File("C:\\Nitro");
            fileLocation.mkdirs();
        }

        PrintWriter writer = new PrintWriter(fileLocation + "/matches.txt");

        Thread t = new Thread(() -> {
            for(int i = 0; i < maxURLs; i++) {
                String code = new RandomString(16, ThreadLocalRandom.current(), RandomString.alphanum).nextString();
                String url = "https://discord.gift/" + code;
                System.out.println(checkAll ? "Scanning " : "Generated " + url);
                if(checkAll) {
                    try {
                        InputStream is = new URL(url).openStream();
                        String b = new String(is.readAllBytes());

                        if(!b.contains("endsection")) {
                            System.out.println("-----------------------");
                            System.out.println("Working Code: " + url);
                            System.out.println("-----------------------");
                            //if(shouldOpenOnSuccess) openWebpage(new URL(url));
                        } else {

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Damn, i guess we've been ratelimited. ");
                        return;
                    }
                }
                writer.println(url);
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            writer.close();
        });
        t.start();

    }
}
