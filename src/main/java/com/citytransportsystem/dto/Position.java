package com.citytransportsystem.dto;

public class Position {

    private Stop stop;

    public Position(Stop stop) {
        this.stop = stop;
    }

    public Stop getStop() {
        return stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
    }


}
