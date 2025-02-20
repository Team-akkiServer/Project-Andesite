package akki697222.andesite;

import akki697222.andesite.compiler.AndesiteLexer;
import akki697222.andesite.compiler.AndesiteParser;
import akki697222.andesite.exceptions.CompileException;
import akki697222.andesite.ir.ErrorListener;
import akki697222.andesite.ir.IRParser;
import akki697222.andesite.ir.nodes.Program;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static Logger logger = LoggerFactory.getLogger(Main.class);
    public static String fileName = "";

    public static void main(String[] args) {
        try {
            String sourceFileName = "test.andesite";
            Program parsedProgram = compileToIR(sourceFileName);
            if (parsedProgram != null) {
                logger.info(parsedProgram.toString());
            }

            long startTime = System.currentTimeMillis();
            long endTime = System.currentTimeMillis();
            System.out.println("実行時間: " + (endTime - startTime) + " ミリ秒");
        } catch (IOException e) {
            logger.error("", e);
        }
    }

    private static Program compileToIR(String sourceFileName) throws IOException {
        CharStream charStream = CharStreams.fromFileName(sourceFileName);
        Path path = Paths.get(sourceFileName);
        String source = Files.readString(path, StandardCharsets.UTF_8);

        fileName = charStream.getSourceName();

        AndesiteLexer lexer = new AndesiteLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        AndesiteParser parser = new AndesiteParser(tokenStream);

        ParseTreeWalker walker = new ParseTreeWalker();
        IRParser irParser = new IRParser(parser, new ErrorListener(fileName, tokenStream, source));

        ParseTree tree = parser.program();

        TreeViewer viewer = new TreeViewer(
                Arrays.asList(parser.getRuleNames()),
                tree
        );
        viewer.open();

        boolean exitWithError = false;
        try {
            walker.walk(irParser, tree);
        } catch (CompileException e) {
            exitWithError = true;
            logger.error("Compilation Failed");
        }
        if (!exitWithError) {
            return irParser.getProgram();
        } else {
            return null;
        }
    }
}