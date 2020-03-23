package thies.Prisoners_Dilemma.InternalTournamentV2;

public class Utility {
	
	public static String removeLastXCharacter(String str, int i) {
		   String result = null;
		   if ((str != null) && (str.length() > 0)) {
		      result = str.substring(0, str.length() - i);
		   }
		   return result;
	}
	
	public static String removeFirstXCharacters(String str, int amount) {
		String result = str.substring(amount);
		return result;
	}
	
	public static String checkMemory(String history, int movesMemory) {
		if (history.length() > movesMemory) {
			int x = history.length() - movesMemory;
			history = removeLastXCharacter(history, x);
		}
		return history;
		
	}
	
	public static double randomPercent() {
		return Math.random()*100;
	}
	public static int tournamentParticipants = 38;
	
	public static Strategy[] fillTournament() {
		Strategy[] strats = new Strategy[tournamentParticipants];
		strats[0] = new Strategy_all_c();
		strats[1] = new Strategy_all_d();
		strats[2] = new Strategy_equalizer_F();
		strats[3] = new Strategy_gradual();
		strats[4] = new Strategy_majo_hard();
		strats[5] = new Strategy_majo_soft();
		strats[6] = new Strategy_mem2();
		strats[7] = new Strategy_mistrust();
		strats[8] = new Strategy_pavlov();
		strats[9] = new Strategy_per_ccd();
		strats[10] = new Strategy_per_cd();
		strats[11] = new Strategy_per_cdd();
		strats[12] = new Strategy_prober_cdd();
		strats[13] = new Strategy_prober_dcc();
		strats[14] = new Strategy_spiteful();
		strats[15] = new Strategy_spiteful_cc();
		strats[16] = new Strategy_tf2t();
		strats[17] = new Strategy_tft();
		strats[18] = new Strategy_tft_hard();
		strats[19] = new Strategy_tft_slow();
		strats[20] = new Strategy_Winner_12();
		strats[21] = new Strategy_Winner_21();
		strats[22] = new Strategy_Winner_21_soft();
		strats[23] = new Strategy_tft_spiteful();
		strats[24] = new Strategy_tft_Omega();
		strats[25] = new Strategy_gradual_Omega();
		strats[26] = new Strategy_gradual_Omega2();
		strats[27] = new Strategy_tft_forgiveness();
		strats[28] = new Strategy_pavlov_Adaptive();
		strats[29] = new Strategy_tft_Adaptive();
		strats[30] = new Strategy_random();
		strats[31] = new Strategy_Lucifer();
		strats[32] = new Strategy_Lucifer_V2();
		strats[33] = new Strategy_Lucifer_V3();
		strats[34] = new Strategy_Lucifer_V4();
		strats[35] = new Strategy_Lucifer_V5();
		strats[36] = new Strategy_LucifersMinion();
		strats[37] = new Strategy_LucifersMinion_V2();

		return strats;
		
	}
	
}
