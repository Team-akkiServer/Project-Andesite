package akki697222.andesite;

import akki697222.andesite.compiler.AndesiteLexer;
import akki697222.andesite.compiler.AndesiteParser;
import akki697222.andesite.interpreter.AndesiteIRParser;
import akki697222.andesite.interpreter.AndesiteInterpreter;
import akki697222.andesite.ir.nodes.FunctionDeclaration;
import akki697222.andesite.ir.nodes.VariableDeclaration;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            CharStream charStream = CharStreams.fromFileName("test.andesite");
            //showTree(charStream);
            AndesiteInterpreter interpreter = new AndesiteInterpreter(charStream.toString());
            long startTime = System.currentTimeMillis();
            interpreter.run();
            long endTime = System.currentTimeMillis();
            System.out.println("実行時間: " + (endTime - startTime) + " ミリ秒");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showTree(CharStream charStream) {
        AndesiteLexer lexer = new AndesiteLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        AndesiteParser parser = new AndesiteParser(tokenStream);

        ParseTree tree = parser.program();

        TreeViewer viewer = new TreeViewer(
                Arrays.asList(parser.getRuleNames()),
                tree
        );
        viewer.open();
    }
}