import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ICRUDProduto daoP = new ProdutoDAO();
    ICRUDCliente daoC = new ClienteDAO();
    public void showMenu() {
        System.out.println("Escolha uma das opçoes: ");
        System.out.println(" ");
        System.out.println("1. Clientes");
        System.out.println("2. Produtos");
        System.out.println("3. Pedidos");
    }
    public void showMenuCliente() {
        System.out.println("Escolha uma das opçoes: ");
        System.out.println(" ");
        System.out.println("1. SalvarCliente ");
        System.out.println("2. AlterarCliente");
        System.out.println("3. ListarClientes");
        System.out.println("4. DeletarCliente");
    }
    public void showMenuProduto() {

        System.out.println("Opçoes para Produtos: ");
        System.out.println(" ");
        System.out.println("1. SalvarProduto ");
        System.out.println("2. AlterarProduto");
        System.out.println("3. ListarProdutos");
        System.out.println("4. DeletarProduto");

    }
    public void showMenuPedido() {
        System.out.println("Opçoes para pedidos");
        System.out.println(" ");
        System.out.println("1. SalvarPedido ");
        System.out.println("2. AlterarPedido");
        System.out.println("3. ListarPedidos");
        System.out.println("4. DeletarPedido");
        
    }
    public void escolha(int opcao) {
        if (opcao == 1) {
            showMenuCliente();
            int opcaoCliente = sc.nextInt();
            sc.nextLine();
            escolhaCliente(opcaoCliente);
        }
        if (opcao == 2) {
            showMenuProduto();
            int opcaoProduto = sc.nextInt();
            sc.nextLine();
            escolhaProduto(opcaoProduto);
        }
        if (opcao == 3) {
            showMenuPedido();
            int opcaoPedido = sc.nextInt();
            sc.nextLine();
            escolhaPedido(opcaoPedido);
        }
    }
    public void escolhaCliente(int opcao) {
        if (opcao == 1) {
            System.out.println(" ");
            System.out.println("Insira o cpf do cliente: ");
            String cpf = sc.nextLine();
            System.out.println(" ");
            System.out.println("insira o nome do cliente: ");
            String nome = sc.nextLine();
            System.out.println(" ");
            System.out.println("insira a email do cliente: ");
            String email = sc.nextLine();
            System.out.println(" ");
            System.out.println("insira a rua do cliente: ");
            String rua = sc.nextLine();
            System.out.println(" ");
            System.out.println("insira o numero da rua do cliente: ");
            int numero = sc.nextInt();
            sc.nextLine();
            System.out.println(" ");
            System.out.println("insira o bairro do cliente: ");
            String bairro = sc.nextLine();
            System.out.println(" ");
            System.out.println("insira o cep do cliente: ");
            int cep = sc.nextInt();
            sc.nextLine();
            System.out.println(" ");
            System.out.println("insira a cidade do cliente: ");
            String cidade = sc.nextLine();
            System.out.println(" ");
            System.out.println("insira o estado do cliente: ");
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
        }
        if (opcao == 2) {
            System.out.println(" ");
            System.out.println("Insira o Id do cliente q queria alterar: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println(" ");
            System.out.println("Insira o cpf do cliente: ");
            String cpf = sc.nextLine();
            System.out.println(" ");
            System.out.println("insira o nome do cliente: ");
            String nome = sc.nextLine();
            System.out.println(" ");
            System.out.println("insira a email do cliente: ");
            String email = sc.nextLine();
            System.out.println(" ");
            System.out.println("insira a rua do cliente: ");
            String rua = sc.nextLine();
            System.out.println(" ");
            System.out.println("insira o numero da rua do cliente: ");
            int numero = sc.nextInt();
            sc.nextLine();
            System.out.println(" ");
            System.out.println("insira o bairro do cliente: ");
            String bairro = sc.nextLine();
            System.out.println(" ");
            System.out.println("insira o cep do cliente: ");
            int cep = sc.nextInt();
            sc.nextLine();
            System.out.println(" ");
            System.out.println("insira a cidade do cliente: ");
            String cidade = sc.nextLine();
            System.out.println(" ");
            System.out.println("insira o estado do cliente: ");
            String estado = sc.nextLine();
            Cliente clie = new Cliente();
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
        }
        if (opcao == 3) {
            System.out.println(" ");
            System.out.println("Quer ver todos os Clientes? S/N S=Sim e N=Não");
            String ver = sc.nextLine();
            if (ver.equalsIgnoreCase("S")) {
                daoC.listar();
            }else if (ver.equalsIgnoreCase("N")) {
                System.out.println("Voltando ao menu... ");
                escolha(2);
            }else {
                System.out.println("Responda com S ou N!");
                escolha(2);
            }
        }
        if (opcao == 4) {
            System.out.println(" ");
            System.out.println("Qual o id do cliente q vc quer deletar: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println(" ");
            System.out.println("Sera deletado permantemente deseja deletar mesmo: S/N S=Sim e N=Não");
            String ver = sc.nextLine();
            if (ver.equalsIgnoreCase("S")) {
                daoC.deletar(id);
            }else if (ver.equalsIgnoreCase("N")) {
                System.out.println("Voltando ao menu... ");
                repeat();
            }else {
                System.out.println("Responda com S ou N!");
                repeat();
            }
        }
    }
    public void escolhaProduto(int opcao) {
        if (opcao == 1) {
            System.out.println(" ");
            System.out.println("Insira a descriçao do produto: ");
            String descricao = sc.nextLine();
            System.out.println(" ");
            System.out.println("insira um valor para o produto: ");
            double preco = sc.nextDouble();
            System.out.println(" ");
            System.out.println("insira uma quantidade no estoque do produto: ");
            int estoque = sc.nextInt();
            Produto p1 = new Produto(descricao, preco, estoque);
            daoP.salvar(p1);
        }
        if (opcao == 2) {
            System.out.println(" ");
            System.out.println("Insira o Id do produto q queria alterar: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println(" ");
            System.out.println("Nova descriçao do produto: ");
            String descricao = sc.nextLine();
            System.out.println(" ");
            System.out.println("Novo preço do produto: ");
            double preco = sc.nextDouble();
            System.out.println(" ");
            System.out.println("Nova quantidade no estoque do produto: ");
            int estoque = sc.nextInt();
            Produto prod = new Produto();
            prod.setId(id);
            prod.setDescricao(descricao);
            prod.setPreco(preco);
            prod.setEstoque(estoque);

            daoP.alterar(prod);
            
        }
        if (opcao == 3) {
            System.out.println(" ");
            System.out.println("Quer ver todos os produtos? S/N S=Sim e N=Não");
            String ver = sc.nextLine();
            if (ver.equalsIgnoreCase("S")) {
                daoP.listar();
            }else if (ver.equalsIgnoreCase("N")) {
                System.out.println("Voltando ao menu... ");
                repeat();
            }else {
                System.out.println("Responda com S ou N!");
                repeat();
            }
        }
        if (opcao == 4) {
            System.out.println(" ");
            System.out.println("Qual o id do produto q vc quer deletar: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println(" ");
            System.out.println("Sera deletado permantemente deseja deletar mesmo: S/N S=Sim e N=Não");
            String ver = sc.nextLine();
            if (ver.equalsIgnoreCase("S")) {
                daoP.deletar(id);
            }else if (ver.equalsIgnoreCase("N")) {
                System.out.println("Voltando ao menu... ");
                repeat();
            }else {
                System.out.println("Responda com S ou N!");
                repeat();
            }
        }
    }
    public void escolhaPedido(int opcao) {
        if (opcao == 1){
            
        }
    }
    public void repeat() {
        showMenu();
        int opcao = sc.nextInt();
        sc.nextLine();
        escolha(opcao);

        repeat();
    }

}
