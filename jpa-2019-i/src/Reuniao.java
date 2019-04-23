import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reuniao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String sala;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@ManyToMany
	@JoinTable(name="REUNIAO_CONVIDADO",
			joinColumns=@JoinColumn(
					name="reuniao_id", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(
					name="convidado_id", referencedColumnName="cd_usr"))
	private List<Usuario> convidados = new ArrayList<>();
	
	public Reuniao(){
	}

	public Reuniao(Integer id, String sala, Calendar data) {
		this.id = id;
		this.sala = sala;
		this.data = data;
	}
	
	public void addConvidado(Usuario usuario){
		convidados.add(usuario);
		usuario.addReuniao(this);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public List<Usuario> getConvidados() {
		return convidados;
	}

	public void setConvidados(List<Usuario> convidados) {
		this.convidados = convidados;
		
	}
}
