package teoriafilas;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author cnmoro
 */
public class Teoriafilas {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat(".##");

        System.out.println("Unidade (pessoas, clientes, carros, etc): ");
        String unidade = scan.nextLine();

        System.out.println("Tempo (hora, minuto, etc): ");
        String t = scan.nextLine();

        System.out.println("Taxa de atendimento (u ou mi): ");
        double u = scan.nextDouble();

        System.out.println("Taxa de chegada (h ou lambda): ");
        double h = scan.nextDouble();

        double p = (h / u);
        System.out.println("p = Taxa de utilização do sistema = " + p);
        System.out.println("Ocupado " + p * 100 + "% do tempo");
        System.out.println("Ocioso " + (100 - (p * 100)) + "% do tempo");

        double nf = ((h * h) / (u * (u - h)));
        System.out.println("NF = Num médio de " + unidade + " na fila = " + nf);

        double ns = (h / (u - h));
        System.out.println("NS = Num médio de " + unidade + " no sistema = " + ns);

        double tf = (h / (u * (u - h)));
        System.out.println("TF = Tempo médio na fila = " + tf + " " + t);

        double ts = (1 / (u - h));
        System.out.println("TS = Tempo médio no sistema = " + ts + " " + t);

        System.out.println("--------");
        System.out.println("Modelo de Custo\n");

        System.out.println("Custo de atendimento unitário (CA unit): ");
        double caunit = scan.nextDouble();

        System.out.println("Custo de espera unitário (CE unit): ");
        double ceunit = scan.nextDouble();

        double ce = ceunit * ns;
        System.out.println("Custo de espera: " + df.format(ce));

        double ca = caunit * u;
        System.out.println("Custo de atendimento: " + df.format(ca));

        double ctotal = ceunit * ns + caunit * u;
        System.out.println("Custo Total: " + df.format(ctotal));

        double ux = h + (Math.sqrt((h * ceunit) / caunit));
        System.out.println("Taxa de serviço ótima (u* ou mi*): " + df.format(ux) + " " + unidade + "/" + t);

        System.out.println("\nCalculando novo Custo Total com taxa ótima");
        double nsx = (h / (ux - h));
        double ctotalx = ceunit * nsx + caunit * ux;
        System.out.println("Custo Total ótimo: " + df.format(ctotalx));

        double px = h / ux;
        System.out.println("Nova taxa de ocupação ótima: " + df.format(px));
        System.out.println("Ocupado " + df.format(px * 100) + "% do tempo");
        System.out.println("Ocioso " + df.format(100 - (px * 100)) + "% do tempo");
    }

}
