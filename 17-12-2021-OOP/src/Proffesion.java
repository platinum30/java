public class Proffesion {
	public enum Proffesions {
		MATH, CHEMISTRY, GEOGRAPHY, LITERATHURE, PHYSICS, SPORTS
	}

	public static String getRandProffesion() {
		String proffesion;
		int rand = (int) (Math.random() * 6);
		switch (rand) {
		case 0:
			proffesion = Proffesions.MATH.toString();
			break;
		case 1:
			proffesion = Proffesions.CHEMISTRY.toString();
			break;
		case 2:
			proffesion = Proffesions.GEOGRAPHY.toString();
			break;
		case 3:
			proffesion = Proffesions.LITERATHURE.toString();
			break;
		case 4:
			proffesion = Proffesions.PHYSICS.toString();
			break;
		case 5:
			proffesion = Proffesions.SPORTS.toString();
			break;
		default:
			proffesion = Proffesions.MATH.toString();
		}

		return proffesion;

	}
}
