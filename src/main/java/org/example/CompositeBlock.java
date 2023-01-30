package org.example;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CompositeBlock implements Block {
     List<Block> allBlocks = new ArrayList<>();
    String color;
    String material;

    public CompositeBlock(Block... blocks) {
        allBlocks.addAll(Arrays.asList(blocks));
    }

List<Block>getBlocks(){
    return allBlocks.stream().flatMap(Block::singleBlocks).collect(Collectors.toList());

}
    @Override
    public String getColor() {
        return "0";
    }

    @Override
    public String getMaterial() {
        return "0";
    }

    @Override
    public Stream<Block> singleBlocks() {
        return allBlocks.stream().flatMap(Block::singleBlocks);
    }

    @Override
    public String toString() {
        return "CompositeBlock{" +
                "allBlocks=" + allBlocks +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}