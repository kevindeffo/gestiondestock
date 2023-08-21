package com.desktech.gestiondestock.dto;


import com.desktech.gestiondestock.model.Adresse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdresseDto {

    private String adresse1;

    private String adresse2;

    private String ville;

    private String codePostale;

    private String pays;

    public AdresseDto fromEntity(Adresse adresse){
        if(adresse == null){
            return null;
//            TODO: throw an exception
        }

       return AdresseDto.builder()
                .adresse1(getAdresse1())
                .adresse2(getAdresse2())
                .pays(getPays())
                .ville(getCodePostale())
                .codePostale(getCodePostale())
               .build();
    }

    public Adresse toEntity(AdresseDto adresseDto){
        if(adresseDto == null){
            return null;
//            TODO: throw an exception
        }

        Adresse adresse = new Adresse();

        adresse.setAdresse1(adresseDto.getAdresse1());
        adresse.setAdresse2(adresseDto.getAdresse2());
        adresse.setPays(adresseDto.getPays());
        adresse.setVille(adresseDto.getVille());
        adresse.setCodePostale(adresseDto.getCodePostale());
        return adresse;
    }
}
