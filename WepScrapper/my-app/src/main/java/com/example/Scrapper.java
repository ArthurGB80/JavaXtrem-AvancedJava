package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Scrapper {

    public static class Main {
        public static void main(String[] args) throws IOException {
            List<String> links = createLinksList();

            downloadWebContent(links);

            String link = "https://www.rtve.es/";
            String result = getWebContent(link);

            System.out.println(result);
        }

        private static List<String> createLinksList() {
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
            return links;
        }

        private static void downloadWebContent(List<String> links) {
            links.stream().parallel().forEach(link -> getWebContent(link));
        }

        private static String getWebContent(String link) {
            // Implementation to download the web content goes here
            return "";
        }
    }

    private static String getWebContent(String link) {
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            try (InputStream input = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {

                return reader.lines().collect(Collectors.joining());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
