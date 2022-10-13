package AllClass.ClasseLivraria;

import java.util.ArrayList;
import java.util.List;
import Interface.*;
import AllClass.ClasseDeExecoes.*;

public class MinhaBiblioteca implements ManagementLibrary{

    private String name;
    private String address;
    private String cnpj;
    private List<Livros> books = new ArrayList<>();
    private List<Revistas> magazines = new ArrayList<>();

    public MinhaBiblioteca(String name, String address, String cnpj, List<Livros> newBooks, List<Revistas> newMagazines) {
        this.name = name;
        this.address = address;
        this.cnpj = cnpj;
        this.books = newBooks;
        this.magazines = newMagazines;
    }

    public MinhaBiblioteca() {
        this("S.nome", "S.Endereço", "XXXX", new ArrayList<Livros>(), new ArrayList<Revistas>());
    }

    public List<Livros> getBooks() throws NaoExistente {
        if(this.books.size() == 0) {
            throw new NaoExistente("Lista vazia.");
        }
        return this.books;
    }

    public void setBooks(ArrayList<Livros> books) {
        this.books = books;
    }

    public List<Revistas> getMagazines() throws NaoExistente {
        if(this.magazines.size() == 0) {
            throw new NaoExistente("Lista vazia.");
        }
        return this.magazines;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public String getCNPJ() {
        return this.cnpj;
    }

    public void setCNPJ(String newCNPJ) {
        this.cnpj = newCNPJ;
    }

    @Override
    public List<Revistas> researchMagazines(String name) throws NaoExistente {
        List<Revistas> revistasSelected = new ArrayList<>();
        for (Revistas n : this.magazines) {
            if(n.getName().equals(name)) {
                revistasSelected.add(n);
            }
        }
        if(revistasSelected.size() == 0) {
            throw new NaoExistente("Lista vazia.");
        }
        return revistasSelected;
    }

    @Override
    public List<Livros> researchBooks(String name) throws NaoExistente {
        List<Livros> livrosSelected = new ArrayList<>();
        for (Livros n : this.books) {
            if(n.getName().equals(name)) {
                livrosSelected.add(n);
            }
        }
        if(livrosSelected.size() == 0) {
            throw new NaoExistente("Lista vazia.");
        } else {
            return livrosSelected;
        }
    }

    @Override
    public List<Livros> listTopBooks() throws NaoExistente {
        List<Livros> top = new ArrayList<>();
        for(Livros n: this.books) {
            if(n.getClassification() >=4.0) {
                top.add(n);
            }
        }
        if(top.size() == 0) {
            throw new NaoExistente("Lista vazia.");
        }
        return top;
    }

    @Override
    public List<Livros> searchBookByGenrer(String genrer) throws NaoExistente {
        List<Livros> selection = new ArrayList<>();
        for(Livros b: this.books) {
            if(b.getGenreStyle().equals(genrer)) {
                selection.add(b);
            }
        }
        if(selection.size() == 0) {
            throw new NaoExistente("Lista vazia.");
        }
        return selection;
    }

    @Override
    public List<Revistas> searchMagazinesByGenrer(String genrer) throws NaoExistente {
        ArrayList<Revistas> selection = new ArrayList<>();
        for(Revistas r: this.magazines) {
            if(r.getGenreStyle().equals(genrer)) {
                selection.add(r);
            }
        }
        if(selection.size() == 0) {
            throw new NaoExistente("Lista vazia");
        }
        return selection;
    }

    @Override
    public List<Revistas> listTopMagazines() throws NaoExistente {
        List<Revistas> top = new ArrayList<>();
        for(Revistas n: this.magazines) {
            if(n.getClassification() >=4.0) {
                top.add(n);
            }
        }
        if(top.size() == 0) {
            throw new NaoExistente("Nenhuma revista encontrada.");
        }
        return top;
    }

    @Override
    public boolean registerBook(Livros prood) throws Existentes {
        for(Livros b: this.books) {
            if(b.getName().equals(prood.getName())) {
                throw new Existentes("Já existe uma revista com esse nome.");
            }
        }
        this.books.add(prood);
        return true;
    }

    @Override
    public boolean registerMagazine(Revistas prod) throws Existentes {
        for(Revistas b: this.magazines) {
            if(b.getName().equals(prod.getName())) {
                throw new Existentes("Já existe uma revista com esse nome.");
            }
        }
        this.magazines.add(prod);
        return true;
    }
}