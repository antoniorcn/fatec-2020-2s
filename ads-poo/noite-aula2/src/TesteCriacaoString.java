
public class TesteCriacaoString {
	public static void main(String[] args) {
//		String texto = "";
//		for (int i = 0; i < 10; i++) { 
//			texto = texto + i;
//		}
//		System.out.println(texto);
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < 10; i++) {
			sb.append(i);
		}
		System.out.println(sb);
	}
}
