import java.util.List;


public class Magazine implements LibraryItem {

    private int volume;

    private int number;

    private String title;

    private String org;

    private String year;

    @Override
    public String getMaterialName() {

        return "Revista";
    }


    public void includeMaterial(List<LibraryItem> list, LibraryItem libraryItem) {

        list.add(libraryItem);

    }


    public int getVolume() {

        return volume;
    }


    public void setVolume( int volume ) {

        this.volume = volume;
    }


    public int getNumber() {

        return number;
    }


    public void setNumber( int number ) {

        this.number = number;
    }


    public String getTitle() {

        return title;
    }


    public void setTitle( String title ) {

        this.title = title;
    }


    public String getOrg() {

        return org;
    }


    public void setOrg( String org ) {

        this.org = org;
    }


    public String getYear() {

        return year;
    }


    public void setYear( String year ) {

        this.year = year;
    }


    @Override
    public String toString() {

        return "Revista : " + "Título :" + title + ", Org.:" + org + ", Volume :" + volume + ", Ano :" + year + ", Número : " + number;
    }
}