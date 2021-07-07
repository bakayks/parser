package kg.socservice.parser.bootstrap;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import kg.socservice.parser.entities.JurLicoOrFilial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Script  implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

        try {
            String searchUrl = "https://register.minjust.gov.kg/register/SearchAction.seam";
            HtmlPage page = client.getPage(searchUrl);
            while(page.getByXPath("//*[@id=\"searchActionForm:searchAction:tb\"]").size() > 0){
                HtmlElement body = (HtmlElement) page.getByXPath("//*[@id=\"searchActionForm:searchAction:tb\"]").get(0);
                List<HtmlElement> trList = body.getElementsByTagName("tr");
                for(HtmlElement trElement : trList){

                    List<HtmlElement> tdList = trElement.getElementsByTagName("td");

                    JurLicoOrFilial jurLicoOrFilial = JurLicoOrFilial.builder()
                            .id(Long.valueOf(tdList.get(0).asText()))
                            .name(tdList.get(1).asText())
                            .regNumber(tdList.get(2).asText())
                            .status(tdList.get(3).asText())
                            .INN(tdList.get(4).asText())
                            .codeOkpo(tdList.get(5).asText())
                            .date(tdList.get(6).asText())
                            .build();
                    jurLicoOrFilialRepo.save(jurLicoOrFilial);
                }
                page = page.getElementById("nextPage").click();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
