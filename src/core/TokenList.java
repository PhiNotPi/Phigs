package core;
import java.util.ArrayList;

public class TokenList {

	public ArrayList<Token> tokens;
	public ArrayList<Token> used;
	public TokenList parent;

	public TokenList(TokenList parent) {
		this.tokens = new ArrayList<Token>();
		this.used = new ArrayList<Token>();
		this.parent = parent;
	}

	public boolean isUsed(Token t) {
		if (used.contains(t)) {
			return true;
		}
		// else if (parent != null){
		// return parent.isUsed(t);
		// }
		return false;
	}

	public void addUsed(Token t) {
		used.add(t);
		if (parent != null) {
			parent.addUsed(t);
		}
	}

	public void removeUsed(Token t) {
		used.remove(t);
		if (parent != null) {
			parent.removeUsed(t);
		}
	}

	public void push(Token t) {
		tokens.add(t);
	}

	public void shift(Token t) {
		tokens.add(0, t);
	}

	public void pop() {
		if (tokens.size() > 0) {
			tokens.remove(tokens.size() - 1);
		}
	}

	public ArrayList<Prim> eval() {
		if (tokens.size() == 0) {
			return new ArrayList<Prim>();
		}
		// ArrayList<Token> used = new ArrayList<Token>();
		Token op = tokens.remove(0);
		this.addUsed(op);
		ArrayList<Prim> args = new ArrayList<Prim>();
		while (true) {
			if (op.canEval(args)) {
				break;
			}
			int next = 0;
			while (next < tokens.size() && isUsed(tokens.get(next))) {
				next++;
			}
			if (next == tokens.size()) {
				break;
			}
			TokenList child = new TokenList(this);
			for (int i = next; i < tokens.size(); i++) {
				child.push(tokens.get(i));
			}
			args.addAll(child.eval());

		}
		op.eval(args);
		return args;
	}

}
