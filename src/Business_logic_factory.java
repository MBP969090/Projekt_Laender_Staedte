/**
 * Created by Peter on 17.12.2017.
 */
public class Business_logic_factory {
	IBusiness_logic program;
	public IBusiness_logic createBusinessLogicProgram(String wanted_program, IDatarepository datarepository) {
		switch(wanted_program) {
			case "business_logic_sorted":
				program = new Business_logic_sorted(datarepository);
				break;
			case "business_logic_not_sorted":
				program = new Business_logic_not_sorted(datarepository);
				break;
			default:
				program = null;
				break;
		}
		return program;
	}
}
