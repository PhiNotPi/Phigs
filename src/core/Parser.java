package core;

import tokens.*;

public class Parser {

	public static TokenList parseString(TokenList parent, String s) {
		TokenList res = new TokenList(parent);
		String numLit = "";
		while (s.length() > 0) {
			char c = s.charAt(0);
			s = s.substring(1);
			Integer intVal = null;
			try {
				intVal = Integer.parseInt(Character.toString(c));
			} catch (Exception e) {
			}
			if (c == '.' || intVal != null) {
				numLit += Character.toString(c);
				continue;
			}
			if (!numLit.equals("")) {
				res.shift(new NumLit(numLit));
				numLit = "";
			}
			switch (c){
			case '+':res.shift(new Add());break;
			case '-':res.shift(new Subtract());break;
			case '*':res.shift(new Multiply());break;
			case '/':res.shift(new Divide());break;
			case '^':res.shift(new Exponentiate());break;
			case '\\':res.shift(new StackSwap());break;
			default:break;
			}
		}
		if (!numLit.equals("")) {
			res.shift(new NumLit(numLit));
			numLit = "";
		}
		return res;
	}

}
