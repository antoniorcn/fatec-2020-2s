
public class TesteImutavel {
	public static void main(String[] args) { 
//		String texto = "";
//		for (int i = 0; i <= 10; i++) { 
//			texto = texto + i;
//		}
//		System.out.println("Resultado: " + texto);
		System.currentTimeMillis();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i <= 10; i++) { 
			sb.append(i);
		}
		System.currentTimeMillis();
		System.out.println("Resultado: " + sb);
	}
}
