package kg.socservice.parser.bootstrap;

import kg.socservice.parser.entities.Founder;
import kg.socservice.parser.entities.JurLicoOrFilial;
import kg.socservice.parser.repos.FounderRepo;
import kg.socservice.parser.repos.JurLicoOrFilialRepo;
import org.dom4j.util.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScriptJSOUP implements CommandLineRunner {
    @Autowired
    private JurLicoOrFilialRepo jurLicoOrFilialRepo;

    @Autowired
    private FounderRepo founderRepo;


    @Override
    public void run(String... args) throws Exception {
        Document document = Jsoup.connect("https://register.minjust.gov.kg/register/SearchAction.seam").get();
        Elements trs = document.select("tr.rich-table-row");
        int counter = 0;
        for(Element detailPage : trs){
            Document linkFullDocument = Jsoup.connect("https://register.minjust.gov.kg" + detailPage.select("a").attr("href")).get();

            Elements trsOfFullDocument = linkFullDocument.select("p");
            JurLicoOrFilial jurLicoOrFilial = new JurLicoOrFilial();
            for(int i = 0; i < trsOfFullDocument.size(); i++){
                Elements span = trsOfFullDocument.get(i).select("span");

                if(span.text().length() > 2 && span.text().charAt(0) == '1' && span.text().charAt(1) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_1_fullNameKg(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '2' && span.text().charAt(1) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_2_fullNameRu(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '3' && span.text().charAt(1) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_3_shortNameKg(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '4' && span.text().charAt(1) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_4_shortNameRu(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '5' && span.text().charAt(1) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_5_organisationFrom(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '6' && span.text().charAt(1) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_6_haveForeignParticipation(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '7' && span.text().charAt(1) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_7_registrationNumber(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '8' && span.text().charAt(1) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_8_codeOKPO(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '9' && span.text().charAt(1) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_9_INN(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '1' &&  span.text().charAt(1) == '0' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_10_oblast(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '1' &&  span.text().charAt(1) == '1' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_11_rayon(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '1' &&  span.text().charAt(1) == '2' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_12_gorodOrSeloOrPoselok(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '1' &&  span.text().charAt(1) == '3' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_13_mikrorayon(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '1' &&  span.text().charAt(1) == '4' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_14_street(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '1' &&  span.text().charAt(1) == '5' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_15_houseNumber(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '1' &&  span.text().charAt(1) == '6' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_16_appartmentNumber(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '1' &&  span.text().charAt(1) == '7' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_17_phoneNumber(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '1' &&  span.text().charAt(1) == '8' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_18_fax(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '1' &&  span.text().charAt(1) == '9' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_19_email(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '2' &&  span.text().charAt(1) == '0' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_20_registrationOrPereregistration(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '2' &&  span.text().charAt(1) == '1' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_21_prikazNumber(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '2' &&  span.text().charAt(1) == '2' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_22_firstRegistrationDate(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '2' &&  span.text().charAt(1) == '3' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_23_wayOfCreation(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '2' &&  span.text().charAt(1) == '4' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_24_formOfSobstvennost(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '2' &&  span.text().charAt(1) == '5' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_25_FIO(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '2' &&  span.text().charAt(1) == '6' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_26_mainActivity(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '2' &&  span.text().charAt(1) == '7' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_27_codeOfActivity(trsOfFullDocument.get(i-1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i-1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '2' &&  span.text().charAt(1) == '8' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_28_countOfPhysicPersons(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '2' &&  span.text().charAt(1) == '9' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_29_countOfJuridicalPersons(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);
                }
                if(span.text().length() > 2 && span.text().charAt(0) == '3' &&  span.text().charAt(1) == '0' && span.text().charAt(2) == '.' ){
                    boolean isNumeric = check(trsOfFullDocument.get(i+1).select("span").text());
                    jurLicoOrFilial.set_30_sumOfPersons(trsOfFullDocument.get(i+1).select("span").text().length() > 0 && !isNumeric ? trsOfFullDocument.get(i+1).select("span").text() : null);

                }
                if(span.text().length() > 2 && span.text().charAt(0) == '3' &&  span.text().charAt(1) == '1' && span.text().charAt(2) == '.' ){
                    for(int x = i; x < trsOfFullDocument.size(); x++) {
                        if(trsOfFullDocument.get(x).select("span").text().contains("Учредитель")) {
                            founderRepo.save(Founder.builder()
                                    .FIO(trsOfFullDocument.get(x+1).select("span").text())
                                    .jurLicoOrFilial(jurLicoOrFilialRepo.save(jurLicoOrFilial))
                                    .build());
//                        System.out.println(trsOfFullDocument.get(x+1).select("span").text());
                        }
                    }
                }

            }
            System.out.println(counter++);
        }
    }

    public boolean check(String str){
        if(str.length() > 0){
            if(str.charAt(0) == '1'){
                return true;
            }else if(str.charAt(0) == '2'){
                return true;
            }else if(str.charAt(0) == '3'){
                return true;
            }else if(str.charAt(0) == 'X'){
                return true;
            }else if(str.charAt(0) == 'I'){
                return true;
            }else if(str.charAt(0) == 'V'){
                return true;
            }
        }

        return false;
    }
}
