import javax.swing.*;
import java.awt.*;

public class CadastroCompra {

    public static void abrirJanelaCadastroCompra() {
        JFrame frame = new JFrame("Cadastro de Compra");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 500); // Janela mais ampla
        frame.setLayout(new BorderLayout(20, 20));
        frame.getContentPane().setBackground(new Color(240, 248, 255)); // Fundo azul claro

        // Título estilizado
        JLabel titulo = new JLabel("Cadastro de Compra", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(new Color(25, 25, 112)); // Azul escuro
        frame.add(titulo, BorderLayout.NORTH);

        // Painel central com borda e layout ajustado
        JPanel painelCampos = new JPanel(new GridLayout(5, 2, 15, 15));
        painelCampos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        painelCampos.setBackground(Color.WHITE);
        frame.add(painelCampos, BorderLayout.CENTER);

        // Fonte padrão para rótulos e campos
        Font fonteRotulo = new Font("Arial", Font.PLAIN, 18);
        Font fonteCampo = new Font("Arial", Font.PLAIN, 16);

        // Campo: Nome do Produto
        JLabel labelNome = new JLabel("Nome do Produto:");
        labelNome.setFont(fonteRotulo);
        JTextField campoNome = criarCampoTexto(fonteCampo);
        painelCampos.add(labelNome);
        painelCampos.add(campoNome);

        // Campo: Preço
        JLabel labelPreco = new JLabel("Preço:");
        labelPreco.setFont(fonteRotulo);
        JTextField campoPreco = criarCampoTexto(fonteCampo);
        painelCampos.add(labelPreco);
        painelCampos.add(campoPreco);

        // Campo: Estoque
        JLabel labelEstoque = new JLabel("Estoque:");
        labelEstoque.setFont(fonteRotulo);
        JTextField campoEstoque = criarCampoTexto(fonteCampo);
        painelCampos.add(labelEstoque);
        painelCampos.add(campoEstoque);

        // Campo: Data
        JLabel labelData = new JLabel("Data (dd/MM/yyyy):");
        labelData.setFont(fonteRotulo);
        JTextField campoData = criarCampoTexto(fonteCampo);
        painelCampos.add(labelData);
        painelCampos.add(campoData);

        // Campo: Valor Total
        JLabel labelValor = new JLabel("Valor Total:");
        labelValor.setFont(fonteRotulo);
        JTextField campoValor = criarCampoTexto(fonteCampo);
        painelCampos.add(labelValor);
        painelCampos.add(campoValor);

        // Painel inferior para botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        painelBotoes.setBackground(new Color(240, 248, 255));

        JButton botaoSalvar = criarBotao("Registrar", new Color(34, 139, 34), Color.WHITE);
        JButton botaoCancelar = criarBotao("Cancelar", new Color(178, 34, 34), Color.WHITE);

        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoCancelar);
        frame.add(painelBotoes, BorderLayout.SOUTH);

        // Ação do botão Salvar
        botaoSalvar.addActionListener(e -> {
            String nome = campoNome.getText();
            String precoTexto = campoPreco.getText();
            String estoqueTexto = campoEstoque.getText();
            String data = campoData.getText();
            String valorTexto = campoValor.getText();

            if (nome.isEmpty() || precoTexto.isEmpty() || estoqueTexto.isEmpty() || data.isEmpty() || valorTexto.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                double preco = Double.parseDouble(precoTexto);
                int estoque = Integer.parseInt(estoqueTexto);
                double valor = Double.parseDouble(valorTexto);

                JOptionPane.showMessageDialog(frame,
                        "Compra registrada com sucesso!\n" +
                                "Produto: " + nome + "\n" +
                                "Preço: R$ " + preco + "\n" +
                                "Estoque: " + estoque + "\n" +
                                "Data: " + data + "\n" +
                                "Valor Total: R$ " + valor,
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                campoNome.setText("");
                campoPreco.setText("");
                campoEstoque.setText("");
                campoData.setText("");
                campoValor.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Preço, Estoque e Valor devem ser numéricos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Ação do botão Cancelar
        botaoCancelar.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }

    private static JTextField criarCampoTexto(Font fonte) {
        JTextField campo = new JTextField();
        campo.setFont(fonte);
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        return campo;
    }

    private static JButton criarBotao(String texto, Color corFundo, Color corFonte) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setBackground(corFundo);
        botao.setForeground(corFonte);
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(corFundo.darker(), 2),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        return botao;
    }
}
