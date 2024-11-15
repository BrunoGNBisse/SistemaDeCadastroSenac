package view;

import controller.*;
import model.TelaDeRemocaoModel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TelaDeRemocaoView extends JFrame {
    public static JLabel lblId;
    public static JComboBox<String> cbxId;

    public static JLabel lblNome;
    public static JTextField txtNome;

    public static JLabel lblEmail;
    public static JTextField txtEmail;

    public static JButton btnRemover;
    public static JButton btnCancelar;

    public static JLabel lblNotificacoes;

    public static GridBagLayout gbLayout;
    public static GridBagConstraints gbConstraints;

    public TelaDeRemocaoView() {
        super("Tela de Remover");

        gbLayout = new GridBagLayout();
        setLayout(gbLayout);
        gbConstraints = new GridBagConstraints();

        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        addComponent(lblId, 0, 0, 1, 1);

        cbxId = new JComboBox<String>();
        TelaDeRemocaoController.popularCbxIdController();
        addComponent(cbxId, 0, 1, 1, 1);

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        addComponent(lblNome, 1, 0, 1, 1);

        txtNome = new JTextField(10);
        txtNome.setEditable(false);
        addComponent(txtNome, 1, 1, 1, 1);

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        addComponent(lblEmail, 2, 0, 1, 1);

        txtEmail = new JTextField(10);
        txtEmail.setEditable(false);
        addComponent(txtEmail, 2, 1, 1, 1);

        TelaDeRemocaoController.atualizarCamposController();

        btnRemover = new JButton("Remover");
        addComponent(btnRemover, 4, 0, 1, 1);

        btnCancelar = new JButton("Cancelar");
        addComponent(btnCancelar, 4, 1, 1, 1);

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        addComponent(lblNotificacoes, 5, 0, 2, 1);

        cbxId.addItemListener(
            new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent event) {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        TelaDeRemocaoController.atualizarCamposController();
                    }
                }
            }
        );

        btnRemover.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeRemocaoController.removerController();
                    try {
                        cbxId.setSelectedIndex(cbxId.getSelectedIndex() + 1);
                        cbxId.removeItemAt(cbxId.getSelectedIndex() - 1);
                    } catch (Exception e) {
                        cbxId.setSelectedIndex(cbxId.getSelectedIndex() - 1);
                        cbxId.removeItemAt(cbxId.getSelectedIndex() + 1);
                    }
                    TelaDeRemocaoController.atualizarCamposController();
                }
            }
        );

        btnCancelar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (JOptionPane.showConfirmDialog(null, "Deseja cancelar e sair da Tela de Remover") == 0) {
                        System.exit(1);
                    }
                }
            }
        );

        setSize(206,154);
        setVisible(true);
    }

    public void addComponent(Component component, int row, int column, int width, int height) {
        if (height > 1 && width > 1) {
            gbConstraints.fill = GridBagConstraints.BOTH;
        } else if (height > 1) {
            gbConstraints.fill = GridBagConstraints.VERTICAL;
        } else {
            gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        }
        gbConstraints.gridy = row;
        gbConstraints.gridx = column;
        gbConstraints.gridwidth = width;
        gbConstraints.gridheight = height;
        gbLayout.setConstraints(component, gbConstraints);
        add(component);
    }

    public static void notificarUsuario(String str) {
        lblNotificacoes.setText(setHtmlFormat(str));
    }

    public static String setHtmlFormat(String str) {
        return "<html><body>" + str + "</body></html>";
    }

    public static void verificarLarguraEAltura() { // checkFrameWidthHeight()
        appTelaDeRemocaoView.getRootPane().addComponentListener(
            new ComponentAdapter() {
                public void componentResized(ComponentEvent e) {
                    int larguraTela = appTelaDeRemocaoView.getWidth();
                    int alturaTela = appTelaDeRemocaoView.getHeight();
                    notificarUsuario(String.format("Largura: %s, Altura: %s", larguraTela, alturaTela));
                }
            }
        );
    }

    public static TelaDeRemocaoView appTelaDeRemocaoView;
    public static void main(String[] args) {
        appTelaDeRemocaoView = new TelaDeRemocaoView();
        appTelaDeRemocaoView.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // verificarLarguraEAltura();
    }
}