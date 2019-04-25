import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "TB_USR")
@Inheritance(strategy=InheritanceType.JOINED)
@Data
public class Usuario {
	public static enum StatusType {
		Ativo, Pendente, Bloqueado, Removido
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_USR")
	private Integer id;
	@Column(name = "LOGIN")
	private String username;
	@Column(name = "SENHA")
	private String password;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_ADMS")
	private Calendar dataAdmissao;
	
	@Enumerated(EnumType.ORDINAL)
	private StatusType status;

	@OneToMany(mappedBy="usuario", 
			cascade={CascadeType.PERSIST, CascadeType.REMOVE}, 
			fetch=FetchType.LAZY)
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	@ManyToMany(mappedBy="convidados")
	private List<Reuniao> reunioes = new ArrayList<>();

	public Usuario() {
		this(null, "", "");
	}

	public Usuario(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.dataAdmissao = new GregorianCalendar();
		this.status = StatusType.Pendente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	public StatusType getStatus() {
		return status;
	}
	
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	
	public void addVeiculo(Veiculo veiculo) {
		veiculos.add(veiculo);
		veiculo.setUsuario(this);
	}
	
	public List<Reuniao> getReunioes() {
		return reunioes;
	}
	
	public void setReunioes(List<Reuniao> reunioes) {
		this.reunioes = reunioes;
	}
	
	public void addReuniao(Reuniao reuniao) {
		reunioes.add(reuniao);
	}
}
