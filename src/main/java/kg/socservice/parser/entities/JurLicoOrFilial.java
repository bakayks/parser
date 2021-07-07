package kg.socservice.parser.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jurlico_or_filial")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class JurLicoOrFilial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "full_name_kg", columnDefinition = "TEXT")
    String _1_fullNameKg;

    @Column(name = "full_name_ru", columnDefinition = "TEXT")
    String _2_fullNameRu;

    @Column(name = "short_name_kg", columnDefinition = "TEXT")
    String _3_shortNameKg;

    @Column(name = "short_name_ru", columnDefinition = "TEXT")
    String _4_shortNameRu;

    @Column(name = "organisation_from", columnDefinition = "TEXT")
    String _5_organisationFrom;

    @Column(name = "have_foreign_participation", columnDefinition = "TEXT")
    String _6_haveForeignParticipation;

    @Column(name = "registration_number", columnDefinition = "TEXT")
    String _7_registrationNumber;

    @Column(name = "code_OKPO", columnDefinition = "TEXT")
    String _8_codeOKPO;

    @Column(name = "INN", columnDefinition = "TEXT")
    String _9_INN;

    @Column(name = "oblast", columnDefinition = "TEXT")
    String _10_oblast;

    @Column(name = "rayon", columnDefinition = "TEXT")
    String _11_rayon;

    @Column(name = "gorod_or_selo_or_poselok", columnDefinition = "TEXT")
    String _12_gorodOrSeloOrPoselok;

    @Column(name = "mikrorayon", columnDefinition = "TEXT")
    String _13_mikrorayon;

    @Column(name = "street", columnDefinition = "TEXT")
    String _14_street;

    @Column(name = "house_number", columnDefinition = "TEXT")
    String _15_houseNumber;

    @Column(name = "appartment_number", columnDefinition = "TEXT")
    String _16_appartmentNumber;

    @Column(name = "phone_number", columnDefinition = "TEXT")
    String _17_phoneNumber;

    @Column(name = "fax", columnDefinition = "TEXT")
    String _18_fax;

    @Column(name = "email", columnDefinition = "TEXT")
    String _19_email;

    @Column(name = "registration_or_pereregistration", columnDefinition = "TEXT")
    String _20_registrationOrPereregistration;

    @Column(name = "prikaz_number", columnDefinition = "TEXT")
    String _21_prikazNumber;

    @Column(name = "first_registration_date", columnDefinition = "TEXT")
    String _22_firstRegistrationDate;

    @Column(name = "way_of_creation", columnDefinition = "TEXT")
    String _23_wayOfCreation;

    @Column(name = "form_of_sobstvennost", columnDefinition = "TEXT")
    String _24_formOfSobstvennost;

    @Column(name = "FIO", columnDefinition = "TEXT")
    String _25_FIO;

    @Column(name = "main_activity", columnDefinition = "TEXT")
    String _26_mainActivity;

    @Column(name = "code_of_activity", columnDefinition = "TEXT")
    String _27_codeOfActivity;

    @Column(name = "count_of_physic_persons", columnDefinition = "TEXT")
    String _28_countOfPhysicPersons;

    @Column(name = "count_of_juridical_persons", columnDefinition = "TEXT")
    String _29_countOfJuridicalPersons;

    @Column(name = "sum_of_persons", columnDefinition = "TEXT")
    String _30_sumOfPersons;

    @Override
    public String toString() {
        return "JurLicoOrFilial{" +
                "id=" + id +
                ", _1_fullNameKg='" + _1_fullNameKg + '\'' +
                ", _2_fullNameRu='" + _2_fullNameRu + '\'' +
                ", _3_shortNameKg='" + _3_shortNameKg + '\'' +
                ", _4_shortNameRu='" + _4_shortNameRu + '\'' +
                ", _5_organisationFrom='" + _5_organisationFrom + '\'' +
                ", _6_haveForeignParticipation='" + _6_haveForeignParticipation + '\'' +
                ", _7_registrationNumber='" + _7_registrationNumber + '\'' +
                ", _8_codeOKPO='" + _8_codeOKPO + '\'' +
                ", _9_INN='" + _9_INN + '\'' +
                ", _10_oblast='" + _10_oblast + '\'' +
                ", _11_rayon='" + _11_rayon + '\'' +
                ", _12_gorodOrSeloOrPoselok='" + _12_gorodOrSeloOrPoselok + '\'' +
                ", _13_mikrorayon='" + _13_mikrorayon + '\'' +
                ", _14_street='" + _14_street + '\'' +
                ", _15_houseNumber='" + _15_houseNumber + '\'' +
                ", _16_appartmentNumber='" + _16_appartmentNumber + '\'' +
                ", _17_phoneNumber='" + _17_phoneNumber + '\'' +
                ", _18_fax='" + _18_fax + '\'' +
                ", _19_email='" + _19_email + '\'' +
                ", _20_registrationOrPereregistration='" + _20_registrationOrPereregistration + '\'' +
                ", _21_prikazNumber='" + _21_prikazNumber + '\'' +
                ", _22_firstRegistrationDate='" + _22_firstRegistrationDate + '\'' +
                ", _23_wayOfCreation='" + _23_wayOfCreation + '\'' +
                ", _24_formOfSobstvennost='" + _24_formOfSobstvennost + '\'' +
                ", _25_FIO='" + _25_FIO + '\'' +
                ", _26_mainActivity='" + _26_mainActivity + '\'' +
                ", _27_codeOfActivity='" + _27_codeOfActivity + '\'' +
                ", _28_countOfPhysicPersons='" + _28_countOfPhysicPersons + '\'' +
                ", _29_countOfJuridicalPersons='" + _29_countOfJuridicalPersons + '\'' +
                ", _30_sumOfPersons='" + _30_sumOfPersons + '\'' +
                '}';
    }
}
