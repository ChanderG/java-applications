import java.util.Comparator;

//compares pw based on values

public class PWvalueComparator implements Comparator<PossibleWinner> {
	@Override
	public int compare(PossibleWinner pw1, PossibleWinner pw2){
		return ((int) pw1.returnValue() - (int)pw2.returnValue());
	}
}
