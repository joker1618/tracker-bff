package com.stats.tracker.be.restModel;

import java.io.Serializable;

public class JsonStat implements Serializable {

    private String label;
    private int valFede;
    private int valBomber;

    public JsonStat() {
    }

    public JsonStat(String label, int valFede, int valBomber) {
        this.label = label;
        this.valFede = valFede;
        this.valBomber = valBomber;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getValFede() {
        return valFede;
    }

    public void setValFede(int valFede) {
        this.valFede = valFede;
    }

    public int getValBomber() {
        return valBomber;
    }

    public void setValBomber(int valBomber) {
        this.valBomber = valBomber;
    }
}
