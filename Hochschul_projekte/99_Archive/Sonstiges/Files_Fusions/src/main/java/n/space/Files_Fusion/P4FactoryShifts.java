package n.space.Files_Fusion;

class P4FactoryShifts {
	public static void main(String[] args) {
		int currentTime24 = 1630;  // in der Form hhmm

		int remainingHours, remainingMins;
		int shift;

// hier kommt Ihre Rechnung rein:
			int hour = currentTime24 / 100;    //16 h
            int minutes = currentTime24 % 100;   //00 min
            
		     shift = (currentTime24 / 800) + 1;
// Zuweisungen sind drin, damit keine Syntaxfehler in dem Programm sind!)
		//shift = 1;
		remainingHours = 0;
		remainingMins = 0;
		
		

		System.out.println("At " + currentTime24 + " there are "
				+ remainingHours + " hours and " + remainingMins
				+ " minutes remaining in shift number " + shift + ".");
				System.out.println(shift);

	}
}