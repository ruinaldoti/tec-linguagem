import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vaga {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String logradouro;

	public Vaga() {
	}

	public Vaga(Integer id, String logradouro) {
		super();
		this.id = id;
		this.logradouro = logradouro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
}
