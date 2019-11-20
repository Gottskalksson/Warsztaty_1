package pl.coderslab.warsztaty1.zad5;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SearchOnWeb {
    public static void main(String[] args) {
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        try {
            PrintWriter file1 = new PrintWriter("popular_words.txt");
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                String s = elem.text();
                String[] tab = s.split(" ");
                for (int i = 0; i < tab.length; i++) {
                    if (tab[i].length() > 2) {
                        file1.println(tab[i]);
                    }
                }
            }
            file1.close();

            Path path = Paths.get("popular_words.txt");
            PrintWriter file2 = new PrintWriter("filtered_popular_words.txt");
            Scanner scan = new Scanner(path);
            String[] forbiddenWords = new String[]{"oraz", "ponieważ", "gdyż", "proF", "TRWA"};
            while (scan.hasNextLine()) {
                int index = 0;
                String s = scan.nextLine();
                s = s.replaceAll("[^0-9\\p{L}*\\-]+", ""); //with this line polish letters still alive
                for (int i = 0; i < forbiddenWords.length; i++) {
                    if (s.equalsIgnoreCase(forbiddenWords[i])) {
                        index++;
                        break;
                    }
                }
                if (index == 0) {
                    file2.println(s);
                }
            }
            file2.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
