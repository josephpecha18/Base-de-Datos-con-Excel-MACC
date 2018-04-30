
public class DatosUsuario {
	
	String usuario1="";
	String pass1="";
	public int probarPass(){
		usuario1= ventana_usuario.txt_usuario.getText();
		pass1= ventana_usuario.pss_contrasena.getText();
		if(usuario1.equals("ANDRESITO")&&pass1.equals("123456")) {
			return 1;
			
		}
		else
			return 0;
		
	}

}
