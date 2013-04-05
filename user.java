    package trabpoo;
     
    import java.io.BufferedWriter;
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.FileWriter;
    import java.util.Scanner;
     
    
    public class user {
    int id = 0 ; 
    public static void main(String[] args) {
     
    user p = new user("teste-poo.txt");
     
    p.menu();
    }
     
    private String nomeDoArquivo;
    public user(String nomeArquivo) {
    this.nomeDoArquivo = nomeArquivo;
    }
     
    public void inserirDados(String registro) {
    File fArquivo = null;
    try {
    fArquivo = new File(this.nomeDoArquivo);
    FileWriter fwArquivo = null;
     
    // Verifica se o arquivo existe
    // Se existir, ele abre para adicionar dados
    // se nao existir, ele cria o arquivo
    if (fArquivo.exists() == true) {
    fwArquivo = new FileWriter(fArquivo, true);
    } else {
    fwArquivo = new FileWriter(fArquivo);
    }
     
    BufferedWriter bw = new BufferedWriter(fwArquivo);
     
    //escreve o registro no arquivo e pula uma linha com o \n
    bw.write(registro + "\n");
     
    System.out.println("Registro adicionado com sucesso...");
     
    //fecha o arquivo
    bw.close();
    fwArquivo.close();
     
    } catch (Exception e) {
    System.err.println("Erro ao inserir linhas no arquivo: " + fArquivo);
    }
    }
     
    public void listarDados() {
    Scanner lendoArquivo = null;
    File arquivo = null;
    try {
    // abrindo o arquivo para leitura
    // se o arquivo nao existir será disparada uma exceção
    arquivo = new File(this.nomeDoArquivo);
    lendoArquivo = new Scanner(arquivo);
     
    // leia o arquivo linha por linha até chegar ao seu fim
    while (lendoArquivo.hasNextLine()) {
    this.processandoLinha(lendoArquivo.nextLine());
    }
     
     
    } catch (FileNotFoundException e) { 
    // tratando quando o arquivo nao existe
    System.err.println("Erro: arquivo nao existe. " + arquivo);
    } finally {
    // fechando o scanner
    try {
    lendoArquivo.close();
    } catch (Exception e) {
    }
    }
    }
     
    private void processandoLinha(String linha) {
    // toda linha do arquivo segue o formato:
    // id:nome:email
    if (linha != null) {
    // separando os campos através do delimitador ':'
    String[] campos = linha.split(":");
    System.out.print("Id: " + campos[0].trim()+" ");
    System.out.print("Nome: " + campos[1].trim());
    System.out.println("\tEmail: " + campos[2].trim());
    System.out.println("--------------------------------------\n");
    }
    }
     
    public void menu() {
    // passando para o objeto da classe Scanner o dispositivo de entrada padrão
    // que é o teclado
    Scanner teclado = new Scanner(System.in);
    int op = 0;
    do {
    System.out.println("..:: Trabalhando com Arquivos Texto ::..");
    System.out.println("1 - Adicionar");
    System.out.println("2 - Listar");
    System.out.println("3 - Remover");
    System.out.println("4 - Sair");
    System.out.print("Entre com uma opcao: ");
    op = teclado.nextInt();
     
    switch (op) {
    case 1:
    teclado.nextLine();
    String nome, email;
    
    
    System.out.println("Entre com os dados:");
    System.out.print("Nome: ");
    id = id+1;
    nome = teclado.nextLine();
    System.out.print("Email: ");
    email = teclado.nextLine();
    this.inserirDados(id+" : "+nome + " : " + email);
    break;
    case 2:
    this.listarDados();
    break;
    case 3:
        
    default:
    }
     
    } while (op != 3);
    }
    }