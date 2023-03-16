import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
public class Main{
    public static int menu(){
        Scanner input = new Scanner(System.in);
        int op;
        System.out.println("\n------------------------------------- Mini Menu -------------------------------------");
        System.out.println("1.Cadastrar Chaves");
        System.out.println("2.Cadastrar chaves por meio de arquivo");
        System.out.println("3.Imprimir nomes em Pré-Order");
        System.out.println("4.Imprimir nomes em In-Order");
        System.out.println("5.Imprimir nomes em Pós-Order");
        System.out.println("6.Imprimir nomes em Level-Order");
        System.out.println("7.Descobrir maior chave");
        System.out.println("8.Descobrir menor chave");
        System.out.println("9.Descobrir altura da árvore");
        System.out.println("10.Descobrir tamanho da árvore");
        System.out.println("11.Descobrir o comprimento da árvore");
        System.out.println("0.Sair do Programa");
        System.out.println("\n----------------------------------------------------------------------------------------");
        System.out.print("Digite a opção que deseja selecionar: ");
        op = input.nextInt();
        return op;
    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int op;
        Arvore<String> binaria = new Arvore<>();
        while (true){
            op = menu();
            switch (op){
                case 1 -> {
                    String nome;
                    System.out.print("Digite o nome que será inscrito: ");
                    nome = input.next();
                    binaria.insert(nome);
                }
                case 2 -> {
                    Path arquivo = Paths.get("C:/Users/mkaua/IdeaProjects/untitled/src/nomes10k.txt");
                    List<String> linhas = Files.readAllLines(arquivo);
                    for(String linha : linhas)
                        binaria.insert(linha);
                }
                case 3 -> binaria.printPreOrder();
                case 4 -> binaria.printInOrder();
                case 5 -> binaria.printPostOrder();
                case 6 -> binaria.printLevelOrder();
                case 7 -> binaria.maior();
                case 8 -> binaria.menor();
                case 9 -> System.out.println("A altura da Arvore será: " + binaria.height());
                case 10 -> System.out.println("O tamanho da árvore será: " + binaria.getSize());
                case 11 -> System.out.println("O comprimento da arvore é: " + binaria.internal_Path());
                case 0 -> {
                    return;
                }
                default -> System.out.println("Alternativa erronea");
            }
        }

    }
}
