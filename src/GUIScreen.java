import javax.swing.*;
import java.awt.*;
import java.util.Map;


public abstract class GUIScreen {

    public abstract String getScreenName();


    public JPanel createJPanel( LayoutManager layoutManager ) {

        return new JPanel( layoutManager );

    }

    public JFrame createJFrame( String nameFrame, int closeOperation ) {

        JFrame frame = new JFrame( nameFrame );
        frame.setDefaultCloseOperation( closeOperation );
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible( true );

        return frame;

    }

    public void createWarningScreen(JFrame frame,String message){

        JOptionPane.showMessageDialog(frame,message);

    }


    public JTextField createJTextField( String text, int s1, int s2 ) {

        JTextField jTextField = new JTextField();

        jTextField.setPreferredSize( new Dimension( s1, s2 ) );
        jTextField.setText( text );

        return jTextField;

    }


    public JLabel createJLabel( String text ) {

        return new JLabel( text );

    }


    public JPanel createJPanelWithJTextFieldsVertically( Map< String, JTextField > fields ) {

        JPanel jPanel = createJPanel( new GridLayout( 0, 1, 2, 3 ) );

        for ( Map.Entry< String, JTextField > field : fields.entrySet() ) {

            JPanel subPanel = createJPanel( new FlowLayout() );
            JLabel label = createJLabel( field.getKey() );
            subPanel.add( label );
            subPanel.add( field.getValue() );
            jPanel.add( subPanel );
        }
        return jPanel;
    }


    public JButton createButton( String buttonMessage ) {

        JButton button = new JButton( buttonMessage );

        button.setPreferredSize( new Dimension( 100, 70 ) );

        return button;

    }
}
