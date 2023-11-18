package GUI.Two;

public class Teacher extends Person{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String ID;
	private String subject;
	private String unique;

	public Teacher() {
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public void inputInfo() {
		
		try {
			super.inputInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("[TC]Grade : ");
		String id = InputValue.InputStr();
		setID(id);
		
		System.out.println("Subject : ");
		String Subject = InputValue.InputStr();
		setSubject(Subject);
	}

	@Override
	public String getInfo() {
		String info = super.getInfo()+"\n[T]Grade : "+ID+"\nSubject : "+subject;
		
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
		return subject;
	}
}
