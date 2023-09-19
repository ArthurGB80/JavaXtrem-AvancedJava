package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class ScrapperSkacth {
    /**
     * This function is the entry point of the Java program. It executes the following tasks:
     * 
     * 1. Create a list of URLs to download web content from.
     * 2. Download web content from each URL in parallel.
     * 3. Download web content from a specific URL.
     * 4. Print the downloaded web content.
     *
     * @param  args   the command line arguments
     * @throws IOException   if an I/O error occurs
     */
    
    public static void main(String[] args) throws IOException {
        // Create a list of URLs to download web content from
        List<String> links = new ArrayList<>();
        links.add("https://www.rtve.es/");
        links.add("https://www.rtve.es/noticias/20230916/podemos-bases-montero/2456127.shtml");
        links.add(
                "https://www.rtve.es/noticias/20230916/feijoo-convoca-agentes-sociales-antes-su-investidura-junts-erc-mantienen-exigencias-sanchez/2456099.shtml");
        links.add(
                "https://www.rtve.es/noticias/20230916/disparos-ojos-para-frenar-protesta-iranies-sabemos-tarde-temprano-llegara-libertad/2455856.shtml");
        links.add("https://www.rtve.es/deportes/");
        links.add("https://www.rtve.es/infantil/");
        links.add("https://www.rtve.es/eltiempo/");
        links.add("https://www.rtve.es/television/");
        links.add("https://www.rtve.es/noticias/");

        /*
         * Long timeStart = System.nanoTime();
         * links.stream().forEach(link -> getWebContent(link));
         * Long timeEnd = System.nanoTime();
         * System.out.println("Difference: " + (timeEnd - timeStart));
         */

        // timeStart = System.nanoTime();
        // Download web content from each URL in parallel
        links.stream().parallel().forEach(link -> getWebContent(link));
        // timeEnd = System.nanoTime();
        // System.out.println("Difference: " + (timeEnd - timeStart));

        // Download web content from a specific URL
        String link = "https://www.rtve.es/";
        String result = getWebContent(link);

        // Print the downloaded web content
        System.out.println(result);
    }

    private static String getWebContent(String link) {
        try {
            // Create a URL object with the given link
            URL url = new URL(link);

            // Open a connection to the URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Get the input stream from the connection
            InputStream input = conn.getInputStream();
            /*
             * String result = new BufferedReader(new InputStreamReader(input))
             * .lines().collect(Collectors.joining());
             */

            // Create a buffered reader to read the input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Read all the lines from the buffered reader and join them into a single
            // string
            String content = reader.lines().collect(Collectors.joining());

            // Return the content
            return content;

        } catch (IOException e) {
            // Print the error message if an exception occurs
            System.out.print(e.getMessage());
        }

        // Return an empty string if an exception occurs
        return "";
    }
}
