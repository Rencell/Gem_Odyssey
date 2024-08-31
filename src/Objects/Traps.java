package Objects;

import static Utils.Constant.OBJECT.*;
public class Traps extends GameObjects{

	public Traps(int x, int y) {
		super(x, y, LAVA);
		initHitbox(32, 32);
	}

}
