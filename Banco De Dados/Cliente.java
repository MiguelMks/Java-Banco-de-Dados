public class Cliente {
    private int id;
    private int cpf;
    private String nome;
    private String email;
    private String rua;
    private int numero;
    private String bairro;
    private int cep;
    private String cidade;
    private String estado;
    
    public Cliente() {
    }
    public Cliente(int cpf, String nome, String email, String rua, int numero, String bairro, int cep, String cidade, String estado) {
        setCpf(cpf);
        setNome(nome);
        setEmail(email);
        setRua(rua);
        setNumero(numero);
        setBairro(bairro);
        setCep(cep);
        setCidade(cidade);
        setEstado(estado);
    }
    public Cliente(int id, int cpf, String nome, String email, String rua, int numero, String bairro, int cep, String cidade, String estado) {
        setId(id);
        setCpf(cpf);
        setNome(nome);
        setEmail(email);
        setRua(rua);
        setNumero(numero);
        setBairro(bairro);
        setCep(cep);
        setCidade(cidade);
        setEstado(estado);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public int getCep() {
        return cep;
    }
    public void setCep(int cep) {
        this.cep = cep;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
