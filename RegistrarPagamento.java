import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarPagamento {

    public static void abrirJanelaRegistrarPagamento() {
        // Cria o frame da janela
        JFrame frame = new JFrame("Registrar Pagamento");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 550);
        frame.setLayout(new BorderLayout());

        // Título da janela
        JLabel titulo = new JLabel("Registrar Pagamento", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));  // Aumentando a fonte do título
        titulo.setForeground(new Color(60, 60, 60));  // Cor suave para o título
        frame.add(titulo, BorderLayout.NORTH);

        // Painel para os campos de input (usando GridBagLayout para centralizar)
        JPanel painelCampos = new JPanel();
        painelCampos.setLayout(new GridBagLayout());
        painelCampos.setBackground(new Color(245, 245, 245));  // Cor de fundo suave
        frame.add(painelCampos, BorderLayout.CENTER);

        // Definindo o GridBagConstraints para centralização
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes

        // Campos para o pagamento
        JLabel labelFormaPagamento = new JLabel("Forma de Pagamento:");
        labelFormaPagamento.setFont(new Font("Arial", Font.PLAIN, 18));  // Fonte maior
        gbc.anchor = GridBagConstraints.EAST;  // Alinha o texto à direita
        painelCampos.add(labelFormaPagamento, gbc);

        String[] formasPagamento = {"Dinheiro", "Cartão de Crédito", "Cartão de Débito"};
        JComboBox<String> comboFormaPagamento = new JComboBox<>(formasPagamento);
        comboFormaPagamento.setFont(new Font("Arial", Font.PLAIN, 18));  // Fonte maior
        gbc.gridx = 1;  // Move para a próxima coluna
        gbc.anchor = GridBagConstraints.WEST;  // Alinha o texto à esquerda
        painelCampos.add(comboFormaPagamento, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel labelValor = new JLabel("Valor:");
        labelValor.setFont(new Font("Arial", Font.PLAIN, 18));  // Fonte maior
        gbc.anchor = GridBagConstraints.EAST;  // Alinha o texto à direita
        painelCampos.add(labelValor, gbc);

        JTextField campoValor = new JTextField();
        campoValor.setFont(new Font("Arial", Font.PLAIN, 18));  // Fonte maior
        campoValor.setPreferredSize(new Dimension(300, 50));  // Ajustando a largura
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        painelCampos.add(campoValor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel labelData = new JLabel("Data:");
        labelData.setFont(new Font("Arial", Font.PLAIN, 18));  // Fonte maior
        gbc.anchor = GridBagConstraints.EAST;
        painelCampos.add(labelData, gbc);

        JTextField campoData = new JTextField();
        campoData.setFont(new Font("Arial", Font.PLAIN, 18));  // Fonte maior
        campoData.setPreferredSize(new Dimension(300, 50));  // Ajustando a largura
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        painelCampos.add(campoData, gbc);

        // Painel para os botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelBotoes.setBackground(new Color(245, 245, 245));  // Cor de fundo suave
        frame.add(painelBotoes, BorderLayout.SOUTH);

        // Botões "Salvar", "Cancelar" e "Gerar Nota Fiscal"
        JButton botaoSalvar = new JButton("Registrar");
        botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));  // Fonte maior
        botaoSalvar.setBackground(new Color(85, 165, 255));  // Azul para o botão
        botaoSalvar.setForeground(Color.WHITE);
        botaoSalvar.setFocusPainted(false);
        botaoSalvar.setPreferredSize(new Dimension(120, 40));  // Aumentando o tamanho do botão

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setFont(new Font("Arial", Font.BOLD, 18));  // Fonte maior
        botaoCancelar.setBackground(new Color(255, 85, 85));  // Vermelho para o botão
        botaoCancelar.setForeground(Color.WHITE);
        botaoCancelar.setFocusPainted(false);
        botaoCancelar.setPreferredSize(new Dimension(120, 40));  // Aumentando o tamanho do botão

        JButton botaoNotaFiscal = new JButton("Nota Fiscal");
        botaoNotaFiscal.setFont(new Font("Arial", Font.BOLD, 18));  // Fonte maior
        botaoNotaFiscal.setBackground(new Color(60, 179, 113));  // Verde para o botão
        botaoNotaFiscal.setForeground(Color.WHITE);
        botaoNotaFiscal.setFocusPainted(false);
        botaoNotaFiscal.setPreferredSize(new Dimension(160, 40));  // Botão maior

        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoCancelar);
        painelBotoes.add(botaoNotaFiscal);

        // Ação do botão "Salvar"
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String formaPagamento = (String) comboFormaPagamento.getSelectedItem();
                String valorTexto = campoValor.getText();
                String data = campoData.getText();

                if (valorTexto.isEmpty() || data.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    double valor = Double.parseDouble(valorTexto);
                    JOptionPane.showMessageDialog(frame,
                        "Pagamento registrado com sucesso!\n" +
                        "Forma de Pagamento: " + formaPagamento + "\n" +
                        "Valor: " + valor + "\n" +
                        "Data: " + data,
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                    campoValor.setText("");
                    campoData.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "O valor deve ser numérico!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ação do botão "Cancelar"
        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        // Ação do botão "Nota Fiscal"
        botaoNotaFiscal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, 
                    "Nota Fiscal gerada com sucesso!", 
                    "Nota Fiscal", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Exibe a janela
        frame.setVisible(true);
    }
}
