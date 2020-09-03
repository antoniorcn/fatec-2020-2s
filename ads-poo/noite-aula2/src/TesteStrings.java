public class TesteStrings {
	public static void main(String[] args) {
		String s1 = "A";
		String s2 = "A";
		s2 = s2 + "";
		String s3 = "A";
		s3 = s3 + "";
		
		System.out.println("(" + s1 + ")");
		System.out.println("(" + s2 + ")");
		System.out.println("(" + s3 + ")");
		
		if (s2.equals(s3)) { 
			System.out.println("Iguais");
		} else { 
			System.out.println("Diferentes");
		}
	}
}
