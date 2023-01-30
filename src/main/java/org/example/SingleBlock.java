package org.example;

import java.util.stream.Stream;

public class SingleBlock implements Block{
    String color;
    String material;

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public Stream<Block> singleBlocks() {
        return Stream.of(this);
    }

    public SingleBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String toString() {
        return "SingleBlock{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
