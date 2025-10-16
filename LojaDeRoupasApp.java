import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LojaDeRoupasApp {
    public static void main(String[] args) {
        // Cria o frame principal
        JFrame frame = new JFrame("Sistema de Gestão - Loja de Roupas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Ajustando o tamanho do frame
        frame.setLayout(new BorderLayout());

        // Título no topo
        JLabel titulo = new JLabel("Menu Principal", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(new Color(50, 50, 50));  // Cor do título
        frame.add(titulo, BorderLayout.NORTH);

        // Painel central com botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(5, 2, 20, 20)); // Maior espaçamento entre os botões
        painelBotoes.setBackground(new Color(240, 240, 240));  // Cor de fundo suave
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0)); // Espaçamento acima e abaixo
        frame.add(painelBotoes, BorderLayout.CENTER);

        // Botões para funcionalidades
        String[] funcionalidades = {
            "Cadastrar Produtos", "Cadastrar Vendas", 
            "Cadastrar Clientes", "Cadastrar Fornecedor", 
            "Cadastrar Troca de Produtos", "Cadastrar Compra", 
            "Registrar Pagamento", "Gerar Relatórios"
        };

        for (String funcionalidade : funcionalidades) {
            JButton botao = new JButton(funcionalidade);
            botao.setFont(new Font("Arial", Font.BOLD, 16));
            botao.setBackground(new Color(85, 165, 255));  // Cor de fundo azul para os botões
            botao.setForeground(Color.WHITE);
            botao.setFocusPainted(false);  // Remove o foco do botão para um visual mais limpo
            botao.setBorder(BorderFactory.createLineBorder(new Color(85, 165, 255), 2));  // Borda azul
            botao.setPreferredSize(new Dimension(200, 60));  // Tamanho ajustado para os botões

            painelBotoes.add(botao);

            // Adiciona eventos para os botões específicos
            if (funcionalidade.equals("Cadastrar Produtos")) {
                botao.addActionListener(e -> abrirJanelaCadastroProduto());
            } else if (funcionalidade.equals("Cadastrar Vendas")) {
                botao.addActionListener(e -> abrirJanelaCadastroVenda());
            } else if (funcionalidade.equals("Registrar Pagamento")) {
                botao.addActionListener(e -> RegistrarPagamento.abrirJanelaRegistrarPagamento());
            } else if (funcionalidade.equals("Cadastrar Clientes")) {
                botao.addActionListener(e -> abrirJanelaCadastroClientes());
            } else if (funcionalidade.equals("Cadastrar Fornecedor")) {
                botao.addActionListener(e -> CadastroFornecedor.abrirJanelaCadastroFornecedor());
            } else if (funcionalidade.equals("Cadastrar Compra")) {
                botao.addActionListener(e -> CadastroCompra.abrirJanelaCadastroCompra());  // Chama a classe CadastroCompra
            } else if (funcionalidade.equals("Cadastrar Troca de Produtos")) {
                botao.addActionListener(e -> TrocaDeProdutos.abrirJanelaTrocaProduto());
            } else if (funcionalidade.equals("Gerar Relatórios")) {
                botao.addActionListener(e -> GerarRelatorios.abrirJanelaRelatorio());
            } else {
                // Outros botões exibem mensagens de placeholder
                botao.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Funcionalidade: " + funcionalidade));
            }
        }

        // Painel para o botão de sair, mais limpo e organizado
        JPanel painelSair = new JPanel();
        painelSair.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));  // Centralizando o botão de sair
        painelSair.setBackground(new Color(240, 240, 240));  // Cor suave de fundo
        frame.add(painelSair, BorderLayout.SOUTH);

        // Botão para sair com borda arredondada e cor personalizada
        JButton botaoSair = new JButton("Sair");
        botaoSair.setFont(new Font("Arial", Font.BOLD, 18));
        botaoSair.setBackground(new Color(255, 85, 85));  // Cor de fundo vermelha para o botão de sair
        botaoSair.setForeground(Color.WHITE);
        botaoSair.setPreferredSize(new Dimension(200, 50));
        botaoSair.setFocusPainted(false);  // Remove o foco do botão para um visual mais limpo
        botaoSair.setBorder(BorderFactory.createLineBorder(new Color(255, 85, 85), 2));  // Borda vermelha
        botaoSair.addActionListener(e -> System.exit(0));
        painelSair.add(botaoSair);

        // Exibe a janela
        frame.setVisible(true);
    }

    // Método para abrir a janela de cadastro de produtos
    public static void abrirJanelaCadastroProduto() {
        JFrame frame = new JFrame("Cadastro de Produtos");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 550); // Ajustando o tamanho da janela
        frame.setLayout(new BorderLayout(10, 10));

        // Título
        JLabel titulo = new JLabel("Cadastro de Produtos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(new Color(50, 50, 50));  // Cor do título
        frame.add(titulo, BorderLayout.NORTH);

        // Painel para os campos de input com fundo suave
        JPanel painelCampos = new JPanel(new GridLayout(4, 2, 10, 10));
        painelCampos.setBackground(new Color(245, 245, 245));  // Cor de fundo suave
        painelCampos.setAlignmentX(Component.CENTER_ALIGNMENT);  // Alinha os componentes ao centro
        painelCampos.setAlignmentY(Component.CENTER_ALIGNMENT);
        painelCampos.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT); // Alinhamento de esquerda para direita
        frame.add(painelCampos, BorderLayout.CENTER);

        // Labels e campos de texto
        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField();
        JLabel labelPreco = new JLabel("Preço:");
        JTextField campoPreco = new JTextField();
        JLabel labelEstoque = new JLabel("Estoque:");
        JTextField campoEstoque = new JTextField();

        // Estilo dos labels (aumentando a fonte e cor)
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        labelNome.setFont(labelFont);
        labelPreco.setFont(labelFont);
        labelEstoque.setFont(labelFont);

        // Adicionando bordas aos campos de texto para destacá-los
        campoNome.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        campoPreco.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        campoEstoque.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        // Centralizando o texto nos campos
        campoNome.setHorizontalAlignment(SwingConstants.CENTER);
        campoPreco.setHorizontalAlignment(SwingConstants.CENTER);
        campoEstoque.setHorizontalAlignment(SwingConstants.CENTER);

        // Adicionando os componentes ao painel de campos
        painelCampos.add(labelNome);
        painelCampos.add(campoNome);
        painelCampos.add(labelPreco);
        painelCampos.add(campoPreco);
        painelCampos.add(labelEstoque);
        painelCampos.add(campoEstoque);

        // Ajustando o alinhamento dos campos para a esquerda
        labelNome.setHorizontalAlignment(SwingConstants.CENTER);
        labelPreco.setHorizontalAlignment(SwingConstants.CENTER);
        labelEstoque.setHorizontalAlignment(SwingConstants.CENTER);

        campoNome.setHorizontalAlignment(SwingConstants.CENTER);
        campoPreco.setHorizontalAlignment(SwingConstants.CENTER);
        campoEstoque.setHorizontalAlignment(SwingConstants.CENTER);

        // Painel de botões com um layout mais centralizado
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        painelBotoes.setBackground(new Color(245, 245, 245));  // Cor de fundo suave
        painelBotoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelBotoes.setAlignmentY(Component.CENTER_ALIGNMENT);
        frame.add(painelBotoes, BorderLayout.SOUTH);

        // Botões "Salvar" e "Cancelar"
        JButton botaoSalvar = new JButton("Cadastrar");
        botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));  // Fonte maior
        botaoSalvar.setBackground(new Color(85, 165, 255));  // Azul para o botão
        botaoSalvar.setForeground(Color.WHITE);
        botaoSalvar.setPreferredSize(new Dimension(120, 40));  // Tamanho do botão

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setFont(new Font("Arial", Font.BOLD, 18));  // Fonte maior
        botaoCancelar.setBackground(new Color(255, 85, 85));  // Vermelho para o botão
        botaoCancelar.setForeground(Color.WHITE);
        botaoCancelar.setPreferredSize(new Dimension(120, 40));  // Tamanho do botão

        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoCancelar);

        // Ação do botão "Salvar"
        botaoSalvar.addActionListener((ActionEvent e) -> {
            String nome = campoNome.getText();
            String precoTexto = campoPreco.getText();
            String estoqueTexto = campoEstoque.getText();

            if (nome.isEmpty() || precoTexto.isEmpty() || estoqueTexto.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                double preco = Double.parseDouble(precoTexto);
                int estoque = Integer.parseInt(estoqueTexto);

                JOptionPane.showMessageDialog(frame, 
                    "Produto cadastrado com sucesso!\n" +
                    "Nome: " + nome + "\n" +
                    "Preço: " + preco + "\n" +
                    "Estoque: " + estoque,
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                campoNome.setText("");
                campoPreco.setText("");
                campoEstoque.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Preço e Estoque devem ser numéricos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        botaoCancelar.addActionListener(e -> frame.dispose());
        frame.setVisible(true);
    }

    // Método para abrir a janela de cadastro de clientes
    public static void abrirJanelaCadastroClientes() {
        JFrame frame = new JFrame("Cadastro de Clientes");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 550);  // Tamanho ajustado
        frame.setLayout(new BorderLayout(10, 10));

        // Título
        JLabel titulo = new JLabel("Cadastro de Clientes", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(new Color(50, 50, 50));  // Cor do título
        frame.add(titulo, BorderLayout.NORTH);

        // Painel para os campos de input
        JPanel painelCampos = new JPanel(new GridLayout(5, 2, 15, 15));
        painelCampos.setBackground(new Color(245, 245, 245));  // Cor de fundo suave
        frame.add(painelCampos, BorderLayout.CENTER);

        // Labels e campos de texto
        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField();
        JLabel labelCpf = new JLabel("CPF:");
        JTextField campoCpf = new JTextField();
        JLabel labelEmail = new JLabel("E-mail:");
        JTextField campoEmail = new JTextField();
        JLabel labelTelefone = new JLabel("Telefone:");
        JTextField campoTelefone = new JTextField();

        // Estilo dos labels (aumentando a fonte)
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        labelNome.setFont(labelFont);
        labelCpf.setFont(labelFont);
        labelEmail.setFont(labelFont);
        labelTelefone.setFont(labelFont);

        // Adicionando os componentes ao painel
        painelCampos.add(labelNome);
        painelCampos.add(campoNome);
        painelCampos.add(labelCpf);
        painelCampos.add(campoCpf);
        painelCampos.add(labelEmail);
        painelCampos.add(campoEmail);
        painelCampos.add(labelTelefone);
        painelCampos.add(campoTelefone);

        // Ajustando o alinhamento dos campos para a direita
        labelNome.setHorizontalAlignment(SwingConstants.CENTER);
        labelCpf.setHorizontalAlignment(SwingConstants.CENTER);
        labelEmail.setHorizontalAlignment(SwingConstants.CENTER);
        labelTelefone.setHorizontalAlignment(SwingConstants.CENTER);

        campoNome.setHorizontalAlignment(SwingConstants.CENTER);
        campoCpf.setHorizontalAlignment(SwingConstants.CENTER);
        campoEmail.setHorizontalAlignment(SwingConstants.CENTER);
        campoTelefone.setHorizontalAlignment(SwingConstants.CENTER);

        // Painel de botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelBotoes.setBackground(new Color(245, 245, 245));  // Cor de fundo suave
        frame.add(painelBotoes, BorderLayout.SOUTH);

        // Botões "Salvar" e "Cancelar"
        JButton botaoSalvar = new JButton("Cadastrar");
        botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));  // Fonte maior
        botaoSalvar.setBackground(new Color(85, 165, 255));  // Azul para o botão
        botaoSalvar.setForeground(Color.WHITE);
        botaoSalvar.setPreferredSize(new Dimension(120, 40));  // Tamanho do botão

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setFont(new Font("Arial", Font.BOLD, 18));  // Fonte maior
        botaoCancelar.setBackground(new Color(255, 85, 85));  // Vermelho para o botão
        botaoCancelar.setForeground(Color.WHITE);
        botaoCancelar.setPreferredSize(new Dimension(120, 40));  // Tamanho do botão

        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoCancelar);

        // Ação do botão "Salvar"
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                String cpf = campoCpf.getText();
                String email = campoEmail.getText();
                String telefone = campoTelefone.getText();

                if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || telefone.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Exemplo de sucesso (você pode modificar para salvar os dados em um banco, por exemplo)
                JOptionPane.showMessageDialog(frame, 
                    "Cliente cadastrado com sucesso!\n" +
                    "Nome: " + nome + "\n" +
                    "CPF: " + cpf + "\n" +
                    "E-mail: " + email + "\n" +
                    "Telefone: " + telefone,
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                // Limpar campos
                campoNome.setText("");
                campoCpf.setText("");
                campoEmail.setText("");
                campoTelefone.setText("");
            }
        });

        botaoCancelar.addActionListener(e -> frame.dispose());
        frame.setVisible(true);
    }

    // Método para abrir a janela de cadastro de vendas
    public static void abrirJanelaCadastroVenda() {
        JFrame frame = new JFrame("Cadastro de Vendas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 550);  // Ajuste o tamanho da janela para algo mais adequado
        frame.setLayout(new BorderLayout(10, 10));
        
        // Título
        JLabel titulo = new JLabel("Cadastro de Vendas", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));  // Aumenta o tamanho da fonte do título
        frame.add(titulo, BorderLayout.NORTH);
        
        // Painel central com os campos de entrada
        JPanel painelCampos = new JPanel();
        painelCampos.setLayout(new GridBagLayout());  // Usando GridBagLayout para centralizar os componentes
        painelCampos.setBackground(new Color(245, 245, 245));  // Cor de fundo suave
        frame.add(painelCampos, BorderLayout.CENTER);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Define o espaço entre os componentes
        gbc.anchor = GridBagConstraints.CENTER;  // Centraliza os componentes no painel
        
        // Produto
        JLabel labelProduto = new JLabel("Produto:");
        labelProduto.setFont(new Font("Arial", Font.PLAIN, 18));  // Fonte maior
        JTextField campoProduto = new JTextField(25);  // Aumentando o tamanho do campo de digitação
        campoProduto.setFont(new Font("Arial", Font.PLAIN, 18));  // Fonte do campo
        campoProduto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));  // Aumentando a grossura da borda
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelCampos.add(labelProduto, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        painelCampos.add(campoProduto, gbc);
        
        // Quantidade
        JLabel labelQuantidade = new JLabel("Quantidade:");
        labelQuantidade.setFont(new Font("Arial", Font.PLAIN, 18));  // Fonte maior
        JTextField campoQuantidade = new JTextField(25);  // Aumentando o tamanho do campo de digitação
        campoQuantidade.setFont(new Font("Arial", Font.PLAIN, 18));  // Fonte do campo
        campoQuantidade.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));  // Aumentando a grossura da borda
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        painelCampos.add(labelQuantidade, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        painelCampos.add(campoQuantidade, gbc);
        
        // Preço Unitário
        JLabel labelPrecoUnitario = new JLabel("Preço Unitário:");
        labelPrecoUnitario.setFont(new Font("Arial", Font.PLAIN, 18));  // Fonte maior
        JTextField campoPrecoUnitario = new JTextField(25);  // Aumentando o tamanho do campo de digitação
        campoPrecoUnitario.setFont(new Font("Arial", Font.PLAIN, 18));  // Fonte do campo
        campoPrecoUnitario.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));  // Aumentando a grossura da borda
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        painelCampos.add(labelPrecoUnitario, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        painelCampos.add(campoPrecoUnitario, gbc);
        
        // Painel de botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        painelBotoes.setBackground(new Color(245, 245, 245));  // Cor de fundo suave
        frame.add(painelBotoes, BorderLayout.SOUTH);
        
        // Botões "Salvar" e "Cancelar"
        JButton botaoSalvar = new JButton("Cadastrar");
        botaoSalvar.setFont(new Font("Arial", Font.BOLD, 18));  // Fonte maior
        botaoSalvar.setBackground(new Color(85, 165, 255));  // Azul para o botão
        botaoSalvar.setForeground(Color.WHITE);
        botaoSalvar.setPreferredSize(new Dimension(150, 40));  // Tamanho do botão
        
        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setFont(new Font("Arial", Font.BOLD, 18));  // Fonte maior
        botaoCancelar.setBackground(new Color(255, 85, 85));  // Vermelho para o botão
        botaoCancelar.setForeground(Color.WHITE);
        botaoCancelar.setPreferredSize(new Dimension(150, 40));  // Tamanho do botão
        
        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoCancelar);
        
        // Ação do botão "Salvar"
        botaoSalvar.addActionListener(e -> {
            String produto = campoProduto.getText();
            String quantidadeTexto = campoQuantidade.getText();
            String precoUnitarioTexto = campoPrecoUnitario.getText();
        
            if (produto.isEmpty() || quantidadeTexto.isEmpty() || precoUnitarioTexto.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
            try {
                int quantidade = Integer.parseInt(quantidadeTexto);
                double precoUnitario = Double.parseDouble(precoUnitarioTexto);
        
                JOptionPane.showMessageDialog(frame, 
                    "Venda registrada com sucesso!\n" +
                    "Produto: " + produto + "\n" +
                    "Quantidade: " + quantidade + "\n" +
                    "Preço Unitário: " + precoUnitario,
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        
                campoProduto.setText("");
                campoQuantidade.setText("");
                campoPrecoUnitario.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Quantidade e Preço Unitário devem ser numéricos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        botaoCancelar.addActionListener(e -> frame.dispose());
        frame.setVisible(true);
    }
}