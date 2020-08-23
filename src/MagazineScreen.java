import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class MagazineScreen extends GUIScreen {

    private JTextField volumeField;

    private JTextField numberField;

    private JTextField titleField;

    private JTextField orgField;

    private JTextField yearField;

    private ListScreen listScreen;

    private BookScreen bookScreen;

    private List<LibraryItem> listMaterials;

    private JFrame jFrame;

    public MagazineScreen(BookScreen bookScreen, ListScreen listScreen, List<LibraryItem> listMaterials ) {

        this.bookScreen = bookScreen;
        this.listScreen = listScreen;
        this.listMaterials = listMaterials;
    }


    public void createRevistaGui() {

        if (jFrame != null) {
            jFrame.toFront();
        } else {
            jFrame = createJFrame(getScreenName(), JFrame.EXIT_ON_CLOSE);

            JPanel mainPanel = createJPanel(new BorderLayout());
            JPanel fieldsPanel = createFieldsJPanel();
            JPanel jButtonsPanel = createPanelAndSetButtons();

            mainPanel.add(jButtonsPanel, BorderLayout.SOUTH);
            mainPanel.add(fieldsPanel, BorderLayout.LINE_START);

            jFrame.getContentPane().add(mainPanel);
            jFrame.pack();
        }
    }

    private JPanel createFieldsJPanel() {

        Map< String, JTextField > map = new LinkedHashMap<>();

        titleField = createJTextField( null, 400, 20 );
        orgField = createJTextField( null, 400, 20 );
        yearField = createJTextField( null, 400, 20 );
        numberField = createJTextField( null, 400, 20 );
        volumeField = createJTextField( null, 400, 20 );
        map.put( "Título: ", titleField );
        map.put( "Org.: ", orgField );
        map.put( "Volume: ", volumeField );
        map.put( "Ano: ", yearField );
        map.put( "Número: ", numberField );

        return createJPanelWithJTextFieldsVertically( map );
    }

    private JPanel createPanelAndSetButtons() {

        JPanel jPanel = createJPanel( new FlowLayout( FlowLayout.CENTER ) );

        JButton listButton = createButton( "Listar" );
        JButton booksButton = createButton( "Livros" );
        JButton includeButton = createButton( "Incluir" );

        setListActionButton( listButton );
        setBooksActionButton( booksButton );
        setIncludeActionButton( includeButton );

        jPanel.add( listButton );
        jPanel.add( booksButton );
        jPanel.add( includeButton );

        return jPanel;
    }


    private void setIncludeActionButton( JButton includeButton ) {
        includeButton.addActionListener( actionEvent -> {
            try {
                if ( isFieldEmpty() ) {
                    createWarningScreen( jFrame, "Favor preencha todos os campos!" );
                } else {
                    Magazine magazine = new Magazine();
                    magazine.setTitle( this.titleField.getText() );
                    magazine.setNumber( Integer.parseInt( this.numberField.getText() ) );
                    magazine.setOrg( this.orgField.getText() );
                    magazine.setVolume( Integer.parseInt( this.volumeField.getText() ) );
                    magazine.setYear( this.yearField.getText() );

                    magazine.includeMaterial( listMaterials, magazine );

                    titleField.setText( null );
                    numberField.setText( null );
                    orgField.setText( null );
                    yearField.setText( null );
                    volumeField.setText( null );
                }
            } catch ( NumberFormatException e ) {
                createWarningScreen( jFrame, "Favor preencha os campos Volume e Numero com valores numéricos" );
            }
        } );
    }


    private boolean isFieldEmpty() {

        return titleField.getText().equals( "" ) || numberField.getText().equals( "" ) || volumeField.getText().equals( "" ) || orgField.getText().equals( "" )
            || yearField.getText().equals( "" );
    }


    private void setBooksActionButton( JButton booksButton ) {
        booksButton.addActionListener( actionEvent -> {
            bookScreen.createLivroGUI();
        } );
    }

    private void setListActionButton( JButton listButton ) {
        listButton.addActionListener( actionEvent -> {
            listScreen.listMaterialsGUI();
        } );
    }

    public void setListScreen( ListScreen listScreen ) {
        this.listScreen = listScreen;
    }

    public void setLivroScreen( BookScreen bookScreen) {
        this.bookScreen = bookScreen;
    }

    public void setListMaterials( List<LibraryItem> listMaterials ) {
        this.listMaterials = listMaterials;
    }

    @Override
    public String getScreenName() {
        return "Revistas";
    }
}