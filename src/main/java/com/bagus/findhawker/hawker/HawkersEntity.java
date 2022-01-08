package com.bagus.findhawker.hawker;

import java.util.List;

public class HawkersEntity {
    private final List<HawkerEntity> results;

    public HawkersEntity(List<HawkerEntity> results) {
        this.results = results;
    }

    public List<HawkerEntity> getResults() {
        return results;
    }
}
