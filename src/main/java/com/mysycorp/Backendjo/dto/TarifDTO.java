package com.mysycorp.Backendjo.dto;

public class TarifDTO {
    private Long id;
    private String nameTarif;
    private String offreTarif;
    private Double tarif;

    // Constructeurs
    public TarifDTO() {
    }

    public TarifDTO(Long id, String nameTarif, String offreTarif, Double tarif) {
        this.id = id;
        this.nameTarif = nameTarif;
        this.offreTarif = offreTarif;
        this.tarif = tarif;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTarif() {
        return nameTarif;
    }

    public void setNameTarif(String nameTarif) {
        this.nameTarif = nameTarif;
    }

    public String getOffreTarif() {
        return offreTarif;
    }

    public void setOffreTarif(String offreTarif) {
        this.offreTarif = offreTarif;
    }

    public Double getTarif() {
        return tarif;
    }

    public void setTarif(Double tarif) {
        this.tarif = tarif;
    }
}

