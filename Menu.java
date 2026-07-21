import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    ProdutoDAO daoP = new ProdutoDAO();
    ClienteDAO daoC = new ClienteDAO();
    PedidoDAO daoPe = new PedidoDAO();
    
    // Objeto do pedido que serve como carrinho enquanto o menu estiver aberto
    private Pedido pedidoAtual; 

    public void showMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Clientes");
        System.out.println("2. Produtos");
        System.out.println("3. Pedidos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void showMenuCliente() {
        System.out.println("\n--- OPÇÕES DE CLIENTES ---");
        System.out.println("1. Salvar Cliente");
        System.out.println("2. Alterar Cliente");
        System.out.println("3. Listar Clientes");
        System.out.println("4. Deletar Cliente");
        System.out.print("Escolha uma opção: ");
    }

    public void showMenuProduto() {
        System.out.println("\n--- OPÇÕES DE PRODUTOS ---");
        System.out.println("1. Salvar Produto");
        System.out.println("2. Alterar Produto");
        System.out.println("3. Listar Produtos");
        System.out.println("4. Deletar Produto");
        System.out.print("Escolha uma opção: ");
    }

    public void showMenuPedido() {
        System.out.println("\n--- OPÇÕES DE PEDIDO ---");
        System.out.println("1. Adicionar ao Carrinho");
        System.out.println("2. Remover do Carrinho");
        System.out.println("3. Finalizar Pedido");
        System.out.print("Escolha uma opção: ");
    }

    public void escolha(int opcao) {
        if (opcao == 1) {
            showMenuCliente();
            int opcaoCliente = sc.nextInt();
            sc.nextLine();
            escolhaCliente(opcaoCliente);
        } else if (opcao == 2) {
            showMenuProduto();
            int opcaoProduto = sc.nextInt();
            sc.nextLine();
            escolhaProduto(opcaoProduto);
        } else if (opcao == 3) {
            showMenuPedido();
            int opcaoPedido = sc.nextInt();
            sc.nextLine();
            escolhaPedido(opcaoPedido);
        }
    }

    public void escolhaCliente(int opcao) {
        if (opcao == 1) {
            System.out.print("Insira o cpf do cliente: ");
            String cpf = sc.nextLine();
            System.out.print("Insira o nome do cliente: ");
            String nome = sc.nextLine();
            System.out.print("Insira o email do cliente: ");
            String email = sc.nextLine();
            System.out.print("Insira a rua do cliente: ");
            String rua = sc.nextLine();
            System.out.print("Insira o número da rua: ");
            int numero = sc.nextInt();
            sc.nextLine();
            System.out.print("Insira o bairro do cliente: ");
            String bairro = sc.nextLine();
            System.out.print("Insira o cep do cliente: ");
            int cep = sc.nextInt();
            sc.nextLine();
            System.out.print("Insira a cidade do cliente: ");
            String cidade = sc.nextLine();
            System.out.print("Insira o estado do cliente: ");
            String estado = sc.nextLine();

            Cliente c1 = new Cliente();
            c1.setCpf(cpf);
            c1.setNome(nome);
            c1.setEmail(email);
            c1.setRua(rua);
            c1.setNumero(numero);
            c1.setBairro(bairro);
            c1.setCep(cep);
            c1.setCidade(cidade);
            c1.setEstado(estado);

            daoC.salvar(c1);
        } else if (opcao == 2) {
            System.out.print("Insira o ID do cliente que deseja alterar: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Insira o cpf do cliente: ");
            String cpf = sc.nextLine();
            System.out.print("Insira o nome do cliente: ");
            String nome = sc.nextLine();
            System.out.print("Insira o email do cliente: ");
            String email = sc.nextLine();
            System.out.print("Insira a rua do cliente: ");
            String rua = sc.nextLine();
            System.out.print("Insira o número da rua: ");
            int numero = sc.nextInt();
            sc.nextLine();
            System.out.print("Insira o bairro do cliente: ");
            String bairro = sc.nextLine();
            System.out.print("Insira o cep do cliente: ");
            int cep = sc.nextInt();
            sc.nextLine();
            System.out.print("Insira a cidade do cliente: ");
            String cidade = sc.nextLine();
            System.out.print("Insira o estado do cliente: ");
            String estado = sc.nextLine();

            Cliente clie = new Cliente();
            clie.setId(id);
            clie.setCpf(cpf);
            clie.setNome(nome);
            clie.setEmail(email);
            clie.setRua(rua);
            clie.setNumero(numero);
            clie.setBairro(bairro);
            clie.setCep(cep);
            clie.setCidade(cidade);
            clie.setEstado(estado);

            daoC.alterar(clie);
        } else if (opcao == 3) {
            System.out.print("Quer ver todos os Clientes? (S/N): ");
            String ver = sc.nextLine();
            if (ver.equalsIgnoreCase("S")) {
                daoC.listar();
            }
        } else if (opcao == 4) {
            System.out.print("Qual o id do cliente que você quer deletar: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Será deletado permanentemente. Deseja deletar mesmo? (S/N): ");
            String ver = sc.nextLine();
            if (ver.equalsIgnoreCase("S")) {
                daoC.deletar(id);
            }
        }
    }

    public void escolhaProduto(int opcao) {
        if (opcao == 1) {
            System.out.print("Insira a descrição do produto: ");
            String descricao = sc.nextLine();
            System.out.print("Insira um valor para o produto: ");
            double preco = sc.nextDouble();
            System.out.print("Insira a quantidade no estoque: ");
            int estoque = sc.nextInt();
            sc.nextLine();

            Produto p1 = new Produto(descricao, preco, estoque);
            daoP.salvar(p1);
        } else if (opcao == 2) {
            System.out.print("Insira o ID do produto que deseja alterar: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Nova descrição do produto: ");
            String descricao = sc.nextLine();
            System.out.print("Novo preço do produto: ");
            double preco = sc.nextDouble();
            System.out.print("Nova quantidade em estoque: ");
            int estoque = sc.nextInt();
            sc.nextLine();

            Produto prod = new Produto();
            prod.setId(id);
            prod.setDescricao(descricao);
            prod.setPreco(preco);
            prod.setEstoque(estoque);

            daoP.alterar(prod);
        } else if (opcao == 3) {
            System.out.print("Quer ver todos os produtos? (S/N): ");
            String ver = sc.nextLine();
            if (ver.equalsIgnoreCase("S")) {
                daoP.listar();
            }
        } else if (opcao == 4) {
            System.out.print("Qual o ID do produto que deseja deletar: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Será deletado permanentemente. Deseja deletar mesmo? (S/N): ");
            String ver = sc.nextLine();
            if (ver.equalsIgnoreCase("S")) {
                daoP.deletar(id);
            }
        }
    }

    // --- MÉTODOS DO PEDIDO IMPLEMENTADOS ---

    public void escolhaPedido(int opcao) {
        // Se ainda não temos um pedido aberto para a sessão atual, cria um
        if (this.pedidoAtual == null) {
            System.out.print("Informe o ID do cliente para iniciar o pedido: ");
            int idCliente = sc.nextInt();
            sc.nextLine();

            Cliente c = daoC.buscarPorId(idCliente);
            if (c == null) {
                System.out.println("Cliente não encontrado! Operação cancelada.");
                return;
            }
            this.pedidoAtual = new Pedido(c);
            System.out.println("Pedido iniciado para o Cliente " + c.getNome());
        }

        if (opcao == 1) { // Adicionar ao Carrinho
            System.out.print("Qual o ID do produto que deseja adicionar? ");
            int idProduto = sc.nextInt();
            System.out.print("Quantas unidades você quer desse produto? ");
            int quantidade = sc.nextInt();
            sc.nextLine();

            // Busca o produto real pelo ID no DAO
            Produto produto = ((ProdutoDAO) daoP).buscarPorId(idProduto);
            if (produto != null) {
                this.pedidoAtual.adicionarNoCarrinho(produto, quantidade);
            } else {
                System.out.println("Produto não encontrado!");
            }

        } else if (opcao == 2) { // Remover do Carrinho
            System.out.print("Digite o ID do produto que deseja remover: ");
            int idProduto = sc.nextInt();
            sc.nextLine();

            this.pedidoAtual.removerDoCarrinho(idProduto);

        } else if (opcao == 3) { // Finalizar Pedido
            // Chama a finalização enviando os DAOs para persistência
            boolean finalizado = this.pedidoAtual.finalizarPedido((PedidoDAO) daoPe, (ProdutoDAO) daoP);
            
            if (finalizado) {
                System.out.println("Pedido finalizado com sucesso!");
                this.pedidoAtual = null; // Libera o objeto para criar um novo pedido na próxima vez
            } else {
                System.out.println("Não foi possível finalizar. Carrinho vazio ou status inválido.");
            }
        }
    }

    // Substituto do repeat() para evitar estouro de pilha
    public void iniciarLoop() {
        int opcao = -1;
        while (opcao != 0) {
            showMenu();
            opcao = sc.nextInt();
            sc.nextLine();
            
            if (opcao != 0) {
                escolha(opcao);
            }
        }
        System.out.println("Programa encerrado com sucesso!");
    }
}