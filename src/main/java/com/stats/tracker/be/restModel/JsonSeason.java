package com.stats.tracker.be.restModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JsonSeason implements Serializable {

    private String str;
    private List<JsonRally> rallies = new ArrayList<>();

    public List<JsonRally> getRallies() {
        return rallies;
    }

    public void setRallies(List<JsonRally> rallies) {
        this.rallies = rallies;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public static class JsonRally {
        private String country;
        private Integer winFede;
        private Integer winBomber;

        public JsonRally() {
        }

        public JsonRally(String country, Integer winFede, Integer winBomber) {
            this.country = country;
            this.winFede = winFede;
            this.winBomber = winBomber;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Integer getWinFede() {
            return winFede;
        }

        public void setWinFede(Integer winFede) {
            this.winFede = winFede;
        }

        public Integer getWinBomber() {
            return winBomber;
        }

        public void setWinBomber(Integer winBomber) {
            this.winBomber = winBomber;
        }
    }
}
