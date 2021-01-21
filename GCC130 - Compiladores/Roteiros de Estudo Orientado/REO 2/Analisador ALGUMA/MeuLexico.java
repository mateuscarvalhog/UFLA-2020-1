import java.io.*;

public class MeuLexico {
    public static void main (String[] args) throws IOException {
        InputStream is = new FileInputStream("C:\\Users\\mateu\\OneDrive\\Documentos\\Acadêmico\\Disciplinas\\2020-1\\Compiladores\\Roteiros de Estudo Orientado\\REO 2\\Analisador ALGUMA\\Algoritmos\\soma_de_fibonacci_ate_n.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader programa =  new BufferedReader(isr);

        Lexico lexico = new Lexico();
        lexico.setInput(programa);

        try {
            Token t = null;
            while ((t = lexico.nextToken()) != null) {
                System.out.println(t.toString());
            }
        }
        catch(LexicalError e){
                System.err.println(e.getMessage() + " em " + e.getPosition());
        }

    }

}

