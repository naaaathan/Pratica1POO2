import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BookScreen extends GUIScreen {

    private JTextField authorField;

    private JTextField titleField;

    private JTextField yearField;

    private MagazineScreen magazineScreen;

    private ListScreen listScreen;

    private List<LibraryItem> listMaterials;

    private JFrame jFrame;

    public BookScreen(MagazineScreen magazineScreen, ListScreen listScreen, List<LibraryItem> listMaterials ) {

        this.magazineScreen = magazineScreen;
        this.listScreen = listScreen;
        this.listMaterials = listMaterials;
    }

    public BookScreen() {

    }

    public void createLivroGUI() {

        if ( jFrame != null ) {
            jFrame.toFront();
        }
        else {
            jFrame = createJFrame( getScreenName(), JFrame.EXIT_ON_CLOSE );

            JPanel mainPanel = createJPanel( new BorderLayout() );
            JPanel fieldsPanel = createFieldsJPanel();
            JPanel jButtonsPanel = createPanelAndSetButtons();

            mainPanel.add( jButtonsPanel, BorderLayout.SOUTH );
            mainPanel.add( fieldsPanel, BorderLayout.LINE_START );

            jFrame.getContentPane().add( mainPanel );
            jFrame.pack();
        }
    }

    private JPanel createPanelAndSetButtons() {

        JPanel jPanel = createJPanel( new FlowLayout( FlowLayout.CENTER ) );

        JButton listButton = createButton( "Listar" );
        JButton magazineButton = createButton( "Revistas" );
        JButton includeButton = createButton( "Incluir" );

        setListActionButton( listButton );
        setMagazineActionButton( magazineButton );
        setIncludeActionButton( includeButton );

        jPanel.add( listButton );
        jPanel.add( magazineButton );
        jPanel.add( includeButton );

        return jPanel;
    }

    private JPanel createFieldsJPanel() {

        Map<String,JTextField> fields = new LinkedHashMap<>();
        titleField = createJTextField(null,400,20);
        authorField = createJTextField(null,400,20);
        yearField = createJTextField(null,400,20);

        fields.put("Título:",titleField);
        fields.put("Autor:",authorField);
        fields.put("Ano:",yearField);

        return createJPanelWithJTextFieldsVertically(fields);
    }

    private void setIncludeActionButton( JButton includeButton ) {
        includeButton.addActionListener( actionEvent -> {
            Book book = new Book();
            book.setAuthor( authorField.getText() );
            book.setTitle( titleField.getText() );
            book.setYear( yearField.getText() );

            book.includeMaterial( listMaterials, book);

            authorField.setText( null );
            titleField.setText( null );
            yearField.setText( null );
        } );
    }

    private void setMagazineActionButton( JButton magazineButton ) {
        magazineButton.addActionListener( actionEvent -> {
            magazineScreen.createRevistaGui();
        } );
    }

    private void setListActionButton( JButton listButton ) {

        listButton.addActionListener( actionEvent -> {
            listScreen.listMaterialsGUI();
        } );
    }

    public void setRevistaScreen( MagazineScreen magazineScreen) {
        this.magazineScreen = magazineScreen;
    }

    public void setListScreen( ListScreen listScreen ) {
        this.listScreen = listScreen;
    }

    public void setListMaterials( List<LibraryItem> listMaterials ) {
        this.listMaterials = listMaterials;
    }

    @Override
    public String getScreenName() {
        return "Livros";
    }
}