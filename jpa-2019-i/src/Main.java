import java.util.List;

public class Main {
	public static void main(String[] args) {
		DAO<Usuario> d = new DAO<Usuario>(Usuario.class);
		
		Usuario usuario = new Usuario(null, "andre", "andre-123456");
		usuario = d.inserir(usuario);
		System.out.println("Usuario inserido!!!");
		
		List<Usuario> usuarios = d.buscarTodos();
		for (Usuario u : usuarios){
			System.out.println(u.getId() + " : " + u.getUsername());
		}
		
		DAO<Vaga> d2 = new DAO<>(Vaga.class);
		Vaga v1 = new Vaga(null, "A-123");
		d2.inserir(v1);
		System.out.println("Vaga inserida!!!");
		
		List<Vaga> vagas = d2.buscarTodos();
		for (Vaga v : vagas){
			System.out.println(v.getId() + " : " + v.getLogradouro());
		}
	}
}
