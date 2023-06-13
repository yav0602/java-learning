package com.yavdev.section12.map;

import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable> {
    private final List<T> mappableItems = new ArrayList<>();

    public Layer() {}

    public Layer(T... mappableItems) {
        this.mappableItems.addAll(List.of(mappableItems));
    }

    public void addMappableItem(T item) {
        mappableItems.add(item);
    }

    public void renderLayer() {
        for (var item : this.mappableItems) {
            item.render();
        }
    }

}
