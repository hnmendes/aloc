package util;

import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;


/**
	@Author: rique
*/

public class Imprimir{

	public static void printPdf (File filePath) throws IOException, PrinterException {
		
		Desktop desktop = Desktop.getDesktop();
		desktop.print(filePath);
		filePath.delete();
		
	}
	
}
