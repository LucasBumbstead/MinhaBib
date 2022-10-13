package AllClass.ClasseLivraria;

public class LivrosSimples extends Livros {

    public LivrosSimples(String name, String dateEdition, String author, String description, String genre, int numberPags, double clas) {
        super(name, dateEdition, author, description, genre, numberPags, clas);
    }

    public LivrosSimples() {
        super("Sem nome", "dd/mm/aaaa", "Desconhecido", "Sem descrição", "Sem gênero", 0, 0.0);
    }    
}
