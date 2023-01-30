package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {

    CompositeBlock compositeBlock = new CompositeBlock(new SingleBlock("red", "brick"),
            new SingleBlock("white", "brick"),
            new SingleBlock("black", "carbon"),
            new SingleBlock("weaved", "carbon"),
            new CompositeBlock(new SingleBlock("red", "brick"),
                    new SingleBlock("white", "brick"),
                    new SingleBlock("black", "carbon"),
                    new SingleBlock("weaved", "carbon"),
                    new CompositeBlock(new SingleBlock("red", "brick"),
                            new SingleBlock("white", "brick"),
                            new SingleBlock("black", "carbon"),
                            new SingleBlock("weaved", "carbon"),
                            new CompositeBlock(new SingleBlock("red", "brick"),
                                    new SingleBlock("white", "brick"),
                                    new SingleBlock("black", "carbon"),
                                    new SingleBlock("weaved", "carbon")))));
    private List<Block> blocks=compositeBlock.getBlocks();

    @Override
    public Optional<Block> findBlockByColor(String color) {
        Block block1 = null;
        if (blocks != null) {
            for (Block block : blocks) {
                if ((!block.getColor().equals(null))&& block.getColor().equals(color)) {
                    block1 = block;
                    break;
                }
            }
        }
        return Optional.ofNullable(block1);
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> blocksByMaterial = new ArrayList<>();
        if (blocks != null) {
            for (Block block : blocks) {
                if (block.getMaterial().equals(material)) {
                    blocksByMaterial.add(block);
                }
            }
        }
        return blocksByMaterial;
    }

    @Override
    public int count() {
        if (blocks != null) {
            int count = 0;
            for(Block b : blocks){
                count++;
            }
            return count;
        } else return 0;
    }
}