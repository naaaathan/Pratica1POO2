import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main( String[] args ) {

        initializeDependenciesAndRunApp();

    }

    public static void initializeDependenciesAndRunApp(){

        List<LibraryItem> listMaterials = new ArrayList<>();
        BookScreen bookScreen = new BookScreen();
        ListScreen listScreen = new ListScreen( listMaterials );
        MagazineScreen magazineScreen = new MagazineScreen(bookScreen, listScreen, listMaterials );

        bookScreen.setListScreen(listScreen);
        bookScreen.setRevistaScreen(magazineScreen);
        bookScreen.setListMaterials(listMaterials);

        magazineScreen.createRevistaGui();


    }
}
