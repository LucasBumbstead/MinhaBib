package Interface;

import java.util.List;
import AllClass.ClasseLivraria.Livros;
import AllClass.ClasseLivraria.Revistas;
import AllClass.ClasseDeExecoes.*;

public interface ManagementLibrary {

    boolean registerBook(Livros prood) throws Existentes;
    List<Livros> researchBooks(String name) throws NaoExistente;
    List<Livros> listTopBooks() throws NaoExistente;
    List<Revistas> listTopMagazines() throws NaoExistente;
    boolean registerMagazine(Revistas prod) throws Existentes;
    List<Revistas> researchMagazines(String name) throws NaoExistente;
    List<Revistas> searchMagazinesByGenrer(String genrer) throws NaoExistente;
    List<Livros> searchBookByGenrer(String genrer) throws NaoExistente;
}
