import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrocaDeProdutos {

    public static void abrirJanelaTrocaProduto() {
        JFrame frame = new JFrame("Troca de Produtos");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 550);
        frame.setLayout(new BorderLayout());

        // Título com estilo
        JLabel titulo = new JLabel("Troca de Produto", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setForeground(new Color(0, 102, 204)); // Cor do título
        frame.add(titulo, BorderLayout.NORTH);

        // Painel de campos (usando GridBagLayout para centralizar)
        JPanel painelCampos = new JPanel();
        painelCampos.setLayout(new GridBagLayout());
        painelCampos.setBackground(new Color(245, 245, 245)); // Cor de fundo dos campos
        frame.add(painelCampos, BorderLayout.CENTER);

        // Definindo o GridBagConstraints para centralização
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes

        // Labels e campos de entrada
        JLabel labelMotivo = new JLabel("Motivo da Troca:");
        labelMotivo.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.anchor = GridBagConstraints.EAST;  // Alinha o texto à direita
        painelCampos.add(labelMotivo, gbc);

        JTextField campoMotivo = new JTextField();
        campoMotivo.setFont(new Font("Arial", Font.PLAIN, 18));
        campoMotivo.setPreferredSize(new Dimension(300, 50)); // Ajusta a largura
        gbc.gridx = 1; // Move para a próxima coluna
        gbc.anchor = GridBagConstraints.WEST; // Alinha o texto à esquerda
        painelCampos.add(campoMotivo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel labelData = new JLabel("Data da Troca:");
        labelData.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.anchor = GridBagConstraints.EAST;
        painelCampos.add(labelData, gbc);

        JTextField campoData = new JTextField();
        campoData.setFont(new Font("Arial", Font.PLAIN, 18));
        campoData.setPreferredSize(new Dimension(300, 50));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        painelCampos.add(campoData, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel labelCodigo = new JLabel("Código do Produto:");
        labelCodigo.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.anchor = GridBagConstraints.EAST;
        painelCampos.add(labelCodigo, gbc);

        JTextField campoCodigo = new JTextField();
        campoCodigo.setFont(new Font("Arial", Font.PLAIN, 18));
        campoCodigo.setPreferredSize(new Dimension(300, 50));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        painelCampos.add(campoCodigo, gbc);

        // Painel de botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        frame.add(painelBotoes, BorderLayout.SOUTH);

        // Botões com cores e fontes modificadas
        JButton botaoSalvar = new JButton("Registrar");
        botaoSalvar.setFont(new Font("Arial", Font.BOLD, 16));
        botaoSalvar.setBackground(new Color(34, 139, 34)); // Cor verde
        botaoSalvar.setForeground(Color.WHITE);
        botaoSalvar.setFocusPainted(false);
        botaoSalvar.setPreferredSize(new Dimension(120, 40));

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setFont(new Font("Arial", Font.BOLD, 16));
        botaoCancelar.setBackground(new Color(220, 20, 60)); // Cor vermelha
        botaoCancelar.setForeground(Color.WHITE);
        botaoCancelar.setFocusPainted(false);
        botaoCancelar.setPreferredSize(new Dimension(120, 40));

        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoCancelar);

        // Ação ao clicar no botão "Salvar"
        botaoSalvar.addActionListener(e -> {
            String motivo = campoMotivo.getText();
            String data = campoData.getText();
            String codigo = campoCodigo.getText();

            if (motivo.isEmpty() || data.isEmpty() || codigo.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(frame, 
                "Troca registrada com sucesso!\n" +
                "Motivo: " + motivo + "\n" +
                "Data: " + data + "\n" +
                "Código do Produto: " + codigo,
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            // Limpar os campos
            campoMotivo.setText("");
            campoData.setText("");
            campoCodigo.setText("");
        });

        // Ação ao clicar no botão "Cancelar"
        botaoCancelar.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }
}
