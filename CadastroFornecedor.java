import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroFornecedor {

    public static void abrirJanelaCadastroFornecedor() {
        // Criando a janela
        JFrame frame = new JFrame("Cadastro de Fornecedor");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 550);  // Tamanho ajustado
        frame.setLayout(new BorderLayout(10, 10));

        // Título
        JLabel titulo = new JLabel("Cadastro de Fornecedor", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(new Color(0, 51, 102));  // Cor do texto
        frame.add(titulo, BorderLayout.NORTH);

        // Painel de campos
        JPanel painelCampos = new JPanel(new GridLayout(5, 2, 10, 20));  // 5 campos: nome, endereço, CNPJ, telefone
        painelCampos.setBackground(new Color(240, 240, 240));  // Cor de fundo suave
        painelCampos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));  // Espaçamento ao redor
        frame.add(painelCampos, BorderLayout.CENTER);

        // Campos de entrada com personalização
        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField();
        campoNome.setPreferredSize(new Dimension(250, 35));
        campoNome.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));  // Borda azul mais grossa
        campoNome.setFont(new Font("Arial", Font.PLAIN, 14));  // Fonte moderna
        campoNome.setBackground(Color.WHITE);
        painelCampos.add(labelNome);
        painelCampos.add(campoNome);

        JLabel labelEndereco = new JLabel("Endereço:");
        JTextField campoEndereco = new JTextField();
        campoEndereco.setPreferredSize(new Dimension(250, 35));
        campoEndereco.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        campoEndereco.setFont(new Font("Arial", Font.PLAIN, 14));
        campoEndereco.setBackground(Color.WHITE);
        painelCampos.add(labelEndereco);
        painelCampos.add(campoEndereco);

        JLabel labelCnpj = new JLabel("CNPJ:");
        JTextField campoCnpj = new JTextField();
        campoCnpj.setPreferredSize(new Dimension(250, 35));
        campoCnpj.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        campoCnpj.setFont(new Font("Arial", Font.PLAIN, 14));
        campoCnpj.setBackground(Color.WHITE);
        painelCampos.add(labelCnpj);
        painelCampos.add(campoCnpj);

        JLabel labelTelefone = new JLabel("Telefone:");
        JTextField campoTelefone = new JTextField();
        campoTelefone.setPreferredSize(new Dimension(250, 35));
        campoTelefone.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        campoTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
        campoTelefone.setBackground(Color.WHITE);
        painelCampos.add(labelTelefone);
        painelCampos.add(campoTelefone);

        // Painel de botões com estilização
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        painelBotoes.setBackground(new Color(240, 240, 240));
        frame.add(painelBotoes, BorderLayout.SOUTH);

        JButton botaoSalvar = new JButton("Cadastrar");
        botaoSalvar.setFont(new Font("Arial", Font.BOLD, 14));
        botaoSalvar.setBackground(new Color(0, 102, 204));
        botaoSalvar.setForeground(Color.WHITE);
        botaoSalvar.setFocusPainted(false);
        botaoSalvar.setPreferredSize(new Dimension(120, 40));
        botaoSalvar.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setFont(new Font("Arial", Font.BOLD, 14));
        botaoCancelar.setBackground(new Color(204, 0, 0));
        botaoCancelar.setForeground(Color.WHITE);
        botaoCancelar.setFocusPainted(false);
        botaoCancelar.setPreferredSize(new Dimension(120, 40));
        botaoCancelar.setBorder(BorderFactory.createLineBorder(new Color(204, 0, 0), 2));

        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoCancelar);

        // Ação ao clicar no botão "Salvar"
        botaoSalvar.addActionListener(e -> {
            String nome = campoNome.getText();
            String endereco = campoEndereco.getText();
            String cnpj = campoCnpj.getText();
            String telefone = campoTelefone.getText();

            if (nome.isEmpty() || endereco.isEmpty() || cnpj.isEmpty() || telefone.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Aqui você pode adicionar a lógica para registrar o fornecedor no sistema
            JOptionPane.showMessageDialog(frame, 
                "Fornecedor cadastrado com sucesso!\n" +
                "Nome: " + nome + "\n" +
                "Endereço: " + endereco + "\n" +
                "CNPJ: " + cnpj + "\n" +
                "Telefone: " + telefone,
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            // Limpa os campos
            campoNome.setText("");
            campoEndereco.setText("");
            campoCnpj.setText("");
            campoTelefone.setText("");
        });

        // Ação ao clicar no botão "Cancelar"
        botaoCancelar.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }
}
