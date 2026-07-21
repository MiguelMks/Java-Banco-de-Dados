import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ICRUD dao = new ProdutoDAO();

    public void showMenu() {

        System.out.println("Opçoes para Produtos: ");
        System.out.println(" ");
        System.out.println("1. Salvar ");
        System.out.println("2. Alterar");
        System.out.println("3. Listar ");
        System.out.println("4. Deletar");

    }

    public void escolha(int opcao) {
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
            dao.salvar(p1);
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

            dao.alterar(prod);
            
        }
        if (opcao == 3) {
            System.out.println(" ");
            System.out.println("Quer ver todos os produtos? S/N ");
            String ver = sc.nextLine();
            if (ver.equalsIgnoreCase("S")) {
                dao.listar();
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
            System.out.println("Sera deletado permantemente deseja deletar mesmo: S/N ");
            String ver = sc.nextLine();
            if (ver.equalsIgnoreCase("S")) {
                dao.deletar(id);
            }else if (ver.equalsIgnoreCase("N")) {
                System.out.println("Voltando ao menu... ");
                repeat();
            }else {
                System.out.println("Responda com S ou N!");
                repeat();
            }
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
