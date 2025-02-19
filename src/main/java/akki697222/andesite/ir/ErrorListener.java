package akki697222.andesite.ir;

import akki697222.andesite.Main;
import akki697222.andesite.exceptions.CompileException;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ErrorListener extends BaseErrorListener {
    private final String sourceFileName;
    private final CommonTokenStream tokens;
    private final String[] sourceLines;

    public ErrorListener(String sourceFileName, CommonTokenStream tokens, String source) {
        this.sourceFileName = sourceFileName;
        this.tokens = tokens;
        this.sourceLines = source.split("\n");
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {

        String errorLine = (line <= sourceLines.length) ? sourceLines[line - 1] : "";
        int errorLength = 1;

        if (offendingSymbol instanceof Token token) {
            String tokenText = token.getText();
            if (tokenText != null && !tokenText.equals("<EOF>")) {
                errorLength = tokenText.length();
            }
        }

        String errorMessage = formatError(
                sourceFileName,
                line,
                charPositionInLine + 1,
                "error",
                msg,
                errorLine,
                errorLength);

        System.err.print(errorMessage);
        throw new CompileException("");
    }

    /**
     * エラーメッセージをClang形式でフォーマットして返します
     *
     * @param fileName ソースファイル名
     * @param line エラーが発生した行番号
     * @param column エラーが発生した列番号
     * @param errorType エラーの種類 (error/warning/note)
     * @param message エラーメッセージ
     * @param sourceLine エラーが発生したソースコードの行
     * @param errorLength エラー箇所の文字数
     * @return フォーマットされたエラーメッセージ
     */
    public static String formatError(
            String fileName,
            int line,
            int column,
            String errorType,
            String message,
            String sourceLine,
            int errorLength) {

        return String.format("%s:%d:%d: %s: %s%n%s%n%s%s%n",
                fileName,
                line,
                column,
                errorType,
                message,
                sourceLine,
                " ".repeat(column - 1) + "^",
                "~".repeat(Math.max(0, errorLength - 1)));
    }
}
