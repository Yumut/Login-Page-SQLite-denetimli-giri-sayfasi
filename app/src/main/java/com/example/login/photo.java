package com.example.login;

public class photo  {
    private int logo;
    private String aciklama,baslik;

    public photo(int logo, String aciklama, String baslik) {
        this.logo = logo;
        this.aciklama = aciklama;
        this.baslik = baslik;
    }

    public int getLogo() {
        return logo;
    }

    public String getAciklama() {
        return aciklama;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }
}
