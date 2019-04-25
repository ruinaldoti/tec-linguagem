import javax.persistence.Entity;

@Entity
public class Professor extends Usuario {
	private String curso;
	private String titulo;

	public Professor() {
		super();
	}

	public Professor(Integer id, String username, 
			String password, String curso, String titulo) {
		super(id, username, password);
		this.curso = curso;
		this.titulo = titulo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
