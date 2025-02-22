package akki697222.andesite;

import akki697222.andesite.compiler.AndesiteLexer;
import akki697222.andesite.compiler.AndesiteParser;
import akki697222.andesite.exceptions.CompileException;
import akki697222.andesite.ir.ErrorListener;
import akki697222.andesite.ir.IRParser;
import akki697222.andesite.ir.nodes.type.Program;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static Logger logger = LoggerFactory.getLogger(Main.class);
    public static String fileName = "";
    public static Map<String, Program> sources = new HashMap<>();

    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            processSources("src/andesite");
            long endTime = System.currentTimeMillis();
            logger.info("パースにかかった時間: {}ms", endTime - startTime);
            StringBuilder parsedSources = new StringBuilder();
            sources.forEach(((packagePath, program) -> parsedSources.append("Package: ").append(packagePath).append(" ").append(program).append("\n")));
            logger.info("パースされたプログラム:\n{}", parsedSources);

            startTime = System.currentTimeMillis();

            

            endTime = System.currentTimeMillis();
            logger.info("実行にかかった時間: {}ms", endTime - startTime);
        } catch (IOException e) {
            logger.error("", e);
        }
    }

    private static void processSources(String sourceFolder) throws IOException {
        File source = new File(sourceFolder);
        File[] files = source.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    processSources(file.getPath());
                } else if (file.isFile() && file.getName().endsWith(".andesite")) {
                    Program parsed = compileToIR(file.getPath(), false);
                    if (parsed != null) {
                        sources.put(file.getPath().replace("\\", "/"), parsed);
                    }
                }
            }
        }
    }

    private static Program compileToIR(String sourceFileName, boolean openTreeViewer) throws IOException {
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

        if (openTreeViewer) {
            TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
            viewer.open();
        }

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