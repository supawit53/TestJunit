public class RangeClass {
	int max, min;
	public static final char OPEN_RIGHT = ')';
	public static final char OPEN_LEFT = '(';
	public static final String COMMA = ",";
	public static final String BRACLET_RIGHT = "}";
	public static final String BRACLET_LEFT = "{";
	
	public String getInput(String inputRange) throws InvalidRangeException {
		validate(splitComma(inputRange));
		checkSymbol(inputRange);
		return buildResult();
	}

	private void checkSymbol(String string) {
		if (string.charAt(0) == OPEN_LEFT) {
			min++;
		}
		if (string.charAt(string.length() - 1) == OPEN_RIGHT) {
			max--;
		}
	}

	private String buildResult() {
		String expected = BRACLET_LEFT;
		int current = min;
		int lastPosition = max - min;
		for (int position = 0; position <= lastPosition; position++) {
			expected += current++;
			if (position != lastPosition) {
				expected += COMMA;
			}
		}
		return expected += BRACLET_RIGHT;
	}

	private void validate(String[] arrString) throws InvalidRangeException {
		try {
			min = Integer.parseInt(arrString[0]);
			max = Integer.parseInt(arrString[1]);
		} catch (Exception e) {
			throw new InvalidRangeException("Invalid Range Exception");
		}
		if (max < min) {
			throw new InvalidRangeException("Invalid Range Exception");
		}
	}

	private String[] splitComma(String string) throws InvalidRangeException {
		return string.substring(1, string.length() - 1).split(COMMA);
	}

}
