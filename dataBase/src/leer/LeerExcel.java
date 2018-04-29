package leer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeerExcel{

	public static void leer(String ruta) {
		/*lee e imprime lo escrito en la primera hoja
		 * del documento de Excel (solo numeros)
		 */
		try {
			File file = new File(ruta);
			FileInputStream excel = new FileInputStream(file);
			try {
				XSSFWorkbook workbook = new XSSFWorkbook(excel); // abre el archivo
				XSSFSheet hoja = workbook.getSheetAt(0); // abre la primera hoja
				
				int numFilas = hoja.getLastRowNum(); //lee el numero de filas
				
				for(int i = 0; i < numFilas; i++) {
					Row fila = hoja.getRow(i);
					int numceldas = fila.getLastCellNum(); //lee el numero de celdas en la fila i
					
					for (int x = 0; x < numceldas; x++) {
						Cell celda = fila.getCell(x);
						switch (celda.getCellTypeEnum().toString()) {
						case "NUMERIC":
							System.out.print(celda.getNumericCellValue() + " ");
							break;
						case "STRING":
							System.out.print(celda.getStringCellValue() + " ");
							break;
						}
					}
					System.out.println(" "); //para hacer salto de linea
				} 
				workbook.close();// cierra el archivo
				
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static String chooseFile() {
		FileNameExtensionFilter filtro_arc = new FileNameExtensionFilter("Archivo Excel", "xlsx");
		JFileChooser buscador = new JFileChooser();
		buscador.setFileFilter(filtro_arc);
		buscador.showOpenDialog(buscador);
		String ruta = buscador.getSelectedFile().getAbsolutePath();
		return ruta;
	}
}
