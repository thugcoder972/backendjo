package com.mysycorp.Backendjo.dto;

public class EpreuveSportiveDTO {
    private Long id;
    private String nameEpreuveSportive;
    private String typeEpreuveSportive;
    private String niveauEpreuve;
    private String imageUrl;
    private String hall;
    private Integer durationInSeconds;

    // Constructeurs
    public EpreuveSportiveDTO() {
    }

    public EpreuveSportiveDTO(Long id, String nameEpreuveSportive, String typeEpreuveSportive,
                              String niveauEpreuve, String imageUrl, String hall, Integer durationInSeconds) {
        this.id = id;
        this.nameEpreuveSportive = nameEpreuveSportive;
        this.typeEpreuveSportive = typeEpreuveSportive;
        this.niveauEpreuve = niveauEpreuve;
        this.imageUrl = imageUrl;
        this.hall = hall;
        this.durationInSeconds = durationInSeconds;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEpreuveSportive() {
        return nameEpreuveSportive;
    }

    public void setNameEpreuveSportive(String nameEpreuveSportive) {
        this.nameEpreuveSportive = nameEpreuveSportive;
    }

    public String getTypeEpreuveSportive() {
        return typeEpreuveSportive;
    }

    public void setTypeEpreuveSportive(String typeEpreuveSportive) {
        this.typeEpreuveSportive = typeEpreuveSportive;
    }

    public String getNiveauEpreuve() {
        return niveauEpreuve;
    }

    public void setNiveauEpreuve(String niveauEpreuve) {
        this.niveauEpreuve = niveauEpreuve;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(Integer durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }
}

