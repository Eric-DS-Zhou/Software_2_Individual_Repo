package exam.Final;

import components.program.Program;
import components.program.Program1;
import components.sequence.Sequence;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public final class Compiler {

    private Compiler() {
    }

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L("C:\\Software2indi\\exam\\Final\\input.bl");
        SimpleWriter out = new SimpleWriter1L("C:\\Software2indi\\exam\\Final\\output.txt");

        Program p = new Program1();
        p.parse(in);

        Sequence<Integer> code = p.generatedCode();

        for (int x : code) {
            out.println(x);
        }

        in.close();
        out.close();
    }
}
