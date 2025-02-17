package akki697222.andesite.ir.nodes;

import akki697222.andesite.ir.Node;
import akki697222.andesite.ir.Visitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static akki697222.andesite.interpreter.AndesiteInterpreter.logger;

public class Block extends Node {
    private final List<Node> nodes;

    public Block(List<Node> nodes) {
        this.nodes = nodes;
        nodes.forEach(node -> node.setParent(this));
    }

    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        return nodes.toString();
    }

    @Override
    public void accept(@NotNull Visitor visitor) {
        for (Node node : nodes) {
            node.accept(visitor);
        }
    }
}
