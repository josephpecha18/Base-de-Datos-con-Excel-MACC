package leer;

public class run {

	public static void main(String[] args) {
		String ruta = LeerExcel.chooseFile();
		LeerExcel.leer(ruta);
	}
}
