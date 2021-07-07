package kg.socservice.parser.bootstrap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class ScriptJSOUP implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Document document = Jsoup.connect("https://register.minjust.gov.kg/register/SearchAction.seam").get();
//        Elements elements = document.select("body");
        document.select("tr").forEach(System.out::println);
    }
}
