import java.time.LocalDate;

public abstract class TopEntity {
	
	protected String name;
	protected int id;
	protected LocalDate DOB;
	
	public TopEntity(String name, int id) {
		
		this.name=name;
		this.id=id;
		
	}
	
	public abstract LocalDate genDOB();

}
