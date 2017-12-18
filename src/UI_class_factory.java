/**
 * Created by Peter on 17.12.2017.
 */
public class UI_class_factory {
	private UI program;
	public UI createUiProgram(String wanted_program, IBusiness_logic business_logic) {
		switch (wanted_program) {
			case "GUI":
				program = new GUI(business_logic);
				break;
			case "TUI":
				program = new TUI(business_logic);
				break;
			default:
				program = null;
				break;
		}
		return program;
	}
}
