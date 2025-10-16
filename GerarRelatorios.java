import javax.swing.*;
import java.awt.*;

public class GerarRelatorios {

    public static void abrirJanelaRelatorio() {
        // Configurando o frame principal
        JFrame frame = new JFrame("Gerar Relatórios");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(245, 245, 245)); // Fundo suave

        // Título
        JLabel titulo = new JLabel("Escolha o Relatório", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(new Color(60, 60, 60));
        frame.add(titulo, BorderLayout.NORTH);

        // Painel central para os botões
        JPanel painelOpcoes = new JPanel(new GridLayout(3, 1, 20, 20));
        painelOpcoes.setBackground(new Color(245, 245, 245));
        painelOpcoes.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // Margens internas

        // Botões estilizados
        JButton botaoRelatorioVendas = criarBotao("Relatório de Vendas", new Color(85, 165, 255));
        JButton botaoRelatorioEstoque = criarBotao("Relatório de Estoque", new Color(100, 200, 100));
        JButton botaoRelatorioPedidos = criarBotao("Relatório de Pedidos", new Color(255, 150, 85));

        painelOpcoes.add(botaoRelatorioVendas);
        painelOpcoes.add(botaoRelatorioEstoque);
        painelOpcoes.add(botaoRelatorioPedidos);

        frame.add(painelOpcoes, BorderLayout.CENTER);

        // Ações dos botões
        botaoRelatorioVendas.addActionListener(e -> gerarRelatorioVendas());
        botaoRelatorioEstoque.addActionListener(e -> gerarRelatorioEstoque());
        botaoRelatorioPedidos.addActionListener(e -> gerarRelatorioPedidos());

        // Exibir a janela
        frame.setVisible(true);
    }

    private static JButton criarBotao(String texto, Color corFundo) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, 18));
        botao.setForeground(Color.WHITE);
        botao.setBackground(corFundo);
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Ajuste do tamanho do botão
        return botao;
    }

    // Métodos para gerar relatórios específicos
    private static void gerarRelatorioVendas() {
        JOptionPane.showMessageDialog(null, "Relatório de Vendas gerado com sucesso!", "Relatório de Vendas", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void gerarRelatorioEstoque() {
        JOptionPane.showMessageDialog(null, "Relatório de Estoque gerado com sucesso!", "Relatório de Estoque", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void gerarRelatorioPedidos() {
        JOptionPane.showMessageDialog(null, "Relatório de Pedidos gerado com sucesso!", "Relatório de Pedidos", JOptionPane.INFORMATION_MESSAGE);
    }
}
