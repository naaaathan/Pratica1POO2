import java.util.List;


public class Book implements LibraryItem {

    private String title;

    private String author;

    private String year;

    @Override
    public String getMaterialName() {

        return "Livro";
    }


    public void includeMaterial(List<LibraryItem> list, LibraryItem libraryItem) {

        list.add(libraryItem);

    }


    public String getTitle() {

        return title;
    }


    public void setTitle( String title ) {

        this.title = title;
    }


    public String getAuthor() {

        return author;
    }


    public void setAuthor( String author ) {

        this.author = author;
    }


    public String getYear() {

        return year;
    }


    public void setYear( String year ) {

        this.year = year;
    }


    @Override
    public String toString() {

        return "Livro : " + "Título :" + title + ", Autor : " + author + ", Ano : " + year;
    }
}
