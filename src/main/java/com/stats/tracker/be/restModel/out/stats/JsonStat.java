package com.stats.tracker.be.restModel.out.stats;

import java.io.Serializable;

public class JsonStat implements Serializable {

    private String label;
    private int valFede;
    private int valBomber;
    private int percFede;
    private int percBomber;

    public JsonStat() {
    }

    public JsonStat(String label, int valFede, int valBomber) {
        this.label = label;
        this.valFede = valFede;
        this.valBomber = valBomber;
        int tot = valFede + valBomber;
        percFede = getPerc(valFede, tot);
        percBomber = getPerc(valBomber, tot);
    }
    private int getPerc(int val, int tot) {
        if(tot == 0) return 0;
        double perc = (double) val / tot;
        return (int) Math.round(perc * 100);
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

    public int getValBomber() {
        return valBomber;
    }

    public int getPercFede() {
        return percFede;
    }

    public int getPercBomber() {
        return percBomber;
    }

    public void setValFede(int valFede) {
        this.valFede = valFede;
    }

    public void setValBomber(int valBomber) {
        this.valBomber = valBomber;
    }

    public void setPercFede(int percFede) {
        this.percFede = percFede;
    }

    public void setPercBomber(int percBomber) {
        this.percBomber = percBomber;
    }
}
