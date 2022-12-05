package passwordCracker;


public class passwordCrackerRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dictionCracker a = new dictionCracker();
		String hashed = "";
		
		
		hashed = args[0];
		String bFOrD = "";
		if(args.length> 1) {
			bFOrD = args[1];
		}
		if(bFOrD.equals("D")) {
			String b = a.checkPass(hashed);
			System.out.println(b);
		}else if(bFOrD.equals("bF")) {
			bruteForceCracker c = new bruteForceCracker();
			boolean d = false;
			for(int i = 1; i<=7 && d== false; i++) {
				d= c.findPassword(hashed,"",i);
				
			}

		}
				
	}

}
