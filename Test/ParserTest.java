import Parser.LocicParser;
import Parser.LogicSentence;
import org.junit.jupiter.api.Test;

public class ParserTest {
    @Test
    void ParseTest(){
        String testString = "(Cube(a)∧Cube(b))∧Cube(c)";
        LogicSentence logicSentence = LocicParser.parseLogic(testString);
        System.out.println("h");

    }
}
