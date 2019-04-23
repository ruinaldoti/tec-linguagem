import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Veiculo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String modelo;
	private String fabricante;
	private String placa;

	@OneToOne(cascade=CascadeType.PERSIST)
	private Vaga vaga = new Vaga();
	
	@ManyToOne()
	@JoinColumn(name="usr_id", referencedColumnName="CD_USR")
	private Usuario usuario;
	
	public Veiculo(){
	}

	public Veiculo(Integer id, String modelo, String fabricante, String placa) {
		this.id = id;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.placa = placa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Vaga getVaga() {
		return vaga;
	}
	
	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
}
