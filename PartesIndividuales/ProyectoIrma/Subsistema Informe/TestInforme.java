/*  Programa que Genera Reporte Financiero      *
 *  y lo visualiza.                             *
 *  Subsistema Informes                         *
 *  Irma Wendolin Domínguez Morales             */
   


public class TestInforme {
    public static void main(String[] args) {
        InformeFinanciero informeFinanciero = new InformeFinanciero(1, "15/02/2025", 5000, 8000);
        informeFinanciero.generar();
        informeFinanciero.visualizar();
    }
}

