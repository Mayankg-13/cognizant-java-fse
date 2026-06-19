public class FactoryMethodTest {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   Testing Factory Method Design Pattern ");
        System.out.println("=================================================");

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        System.out.println("Created: Word Document");
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();
        System.out.println();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        System.out.println("Created: PDF Document");
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();
        System.out.println();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        System.out.println("Created: Excel Document");
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
        System.out.println("=================================================");
    }
}
