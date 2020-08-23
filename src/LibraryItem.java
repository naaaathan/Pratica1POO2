import java.util.List;


interface LibraryItem {

    public String getMaterialName();

    public void includeMaterial(List<LibraryItem> list, LibraryItem libraryItem);

    public String toString();



}
