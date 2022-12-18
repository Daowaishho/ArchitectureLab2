package question13.code;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Color color1 = new Blue();
        Color color2 = new Red();

        Block block1 = new Block();
        Block block2 = new Block();
        Block block3 = new Block();

        block1.setColor(color1);
        block2.setColor(color2);
        block3.setColor(color1);

        block1.add(block2);
        block1.add(block3);

        block1.dyeing();
    }
}

class Block {
    private Color blockColor;
    private ArrayList<Block> blockArrayList = new ArrayList<>();

    public void setColor(Color color) {
        this.blockColor = color;
    }

    public void add(Block block) {
        this.blockArrayList.add(block);
    }

    public void remove(Block block) {
        this.blockArrayList.remove(block);
    }

    public Block getChild(int i) {
        return this.blockArrayList.get(i);
    }

    public void dyeing() {
        this.blockColor.paint();
        if (this.blockArrayList.size() != 0) {
            for (Block block : blockArrayList) {
                block.dyeing();
            }
        }
    }
}

abstract class Color {
    public abstract void paint();
}

class Blue extends Color{
    public void paint() {
        System.out.println("用Blue染色");
    }
}

class Red extends Color{
    public void paint() {
        System.out.println("用Red染色");
    }
}
