package GUI.Two;

public class Student extends Person{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String ID;
	private String className;
	private String unique;
	
	public Student() {}

	public Student(String className) {
		super();
		this.className = className;
	}

	@Override
	public void setID(String id) {
		this.ID=id;
	}

	@Override
	public String getID() {
		return ID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	

	@Override
	public void inputInfo() {
		
		try {
			super.inputInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("[ST]Grade : ");
		String id = InputValue.InputStr();
		
		setID(id);
		
		System.out.println("Class : ");
		String classname = InputValue.InputStr();
		
		setClassName(classname);
		
	}

	@Override
	public String getInfo() {
		 String info = super.getInfo()+"\nGrade : "+ID+"\nClass : "+className;
		 
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
		return className;
	}
}
