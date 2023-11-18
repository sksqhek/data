package GUI.Two;

public class Staff extends Person{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String ID;
	private String dept;
	private String unique;

	public Staff() {
		super();
	}

	@Override
	public void setID(String id) {
		this.ID=id;
	}

	@Override
	public String getID() {
		return ID;
	}
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}


	@Override
	public void inputInfo() {
		
		try {
			super.inputInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("[STF]Grade : ");
		String id = InputValue.InputStr();
		setID(id);
		
		System.out.println("Dept : ");
		String Dept = InputValue.InputStr();
		setDept(Dept);
	}

	@Override
	public String getInfo() {
		String info = super.getInfo()+"\n[STF]Grade : "+ID+"\nDept : "+dept;
		
		return info;
	}

	@Override
	public void printAll() {
		System.out.println(this.getInfo());
	}

	@Override
	public String getUnique() {
		return unique;
	}

	@Override
	public void setUnique(String unique) {
		this.unique = unique;
	}

	@Override
	public String getOther()
	{
		// TODO Auto-generated method stub
		return dept;
	}
}
