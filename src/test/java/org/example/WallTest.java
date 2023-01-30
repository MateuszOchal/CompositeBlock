package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class WallTest {
    @Test
    public void test1() {
        var wall = new Wall();
        var compositeBlock = new CompositeBlock(new SingleBlock("red", "brick"),
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
        assertEquals(wall.count(), compositeBlock.getBlocks().size());
    }

    @Test
    public void test2() {
        var wall = new Wall();
        var compositeBlock = new SingleBlock("white", "brick");
        Optional<Block> optional = Optional.of(compositeBlock);
        assertTrue(optional.isPresent());
        assertTrue(!optional.isEmpty());
        assertEquals(Optional.of(compositeBlock).toString(), wall.findBlockByColor("white").toString());
    }

    @Test
    public void test3() {
        var wall = new Wall();
        List<Block> blocks = new ArrayList<>();
        Block block0 = new SingleBlock("red", "brick");
        Block block1 = new SingleBlock("white", "brick");
        blocks.addAll(List.of(block0, block1,block0, block1,block0, block1,block0, block1));

        List<Block> blocksByMaterial = wall.findBlocksByMaterial("brick");

        assertEquals(blocks.size(), blocksByMaterial.size());

        for (int i = 0; i < blocks.size(); i++) {
            assertEquals(blocks.get(i).toString(), blocksByMaterial.get(i).toString());
        }
    }
}