package main;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class AnaliseRisco {

    public static void main(String[] args) {
        //Carrega arquivo fcl
        FIS fis = FIS.load("src/resource/analise.fcl", true);

        if (fis == null) {
            System.err.println("Can't load file");
            System.exit(1);
        }


        // Mostra todas as varivais linguisticas em grafico
        JFuzzyChart.get().chart(fis.getFunctionBlock("analise"));

        //Seta as entradas para cada variavel linguistica
        fis.setVariable("dinheiro", 35);
        fis.setVariable("pessoal", 60);

        //Avalia as regras
        fis.evaluate();

        //Mostra saída em grafico
        Variable analise = fis.getFunctionBlock("analise").getVariable("risco");
        JFuzzyChart.get().chart(analise, analise.getDefuzzifier(), true);
        System.out.println(analise.getValue());
    }

}
