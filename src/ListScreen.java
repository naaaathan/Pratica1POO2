import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;


public class ListScreen extends GUIScreen {

    private final List<LibraryItem> libraryItemList;

    @Override
    public String getScreenName() {

        return "Listagem";
    }


    public ListScreen( List<LibraryItem> libraryItemList) {

        this.libraryItemList = libraryItemList;

    }


    public void listMaterialsGUI() {

        JFrame jFrame = createJFrame( getScreenName(), JFrame.HIDE_ON_CLOSE );

        jFrame.setLayout( new GridLayout() );

        String materials = getOfEachMaterialStringValue();
        JLabel jLabel = createJLabel( materials );
        TitledBorder title = BorderFactory.createTitledBorder("Listagem de itens : ");
        jLabel.setBorder(title);

        jFrame.getContentPane().add( jLabel );
        jFrame.pack();

    }
    
    private String getOfEachMaterialStringValue() {
        
        String materials = "<html> ";

        for ( LibraryItem libraryItem : libraryItemList) {

            materials = materials.concat( libraryItem.toString() + "<br>" );

        }

        materials = materials.concat( "</html>" );
        return materials;
    }

}
