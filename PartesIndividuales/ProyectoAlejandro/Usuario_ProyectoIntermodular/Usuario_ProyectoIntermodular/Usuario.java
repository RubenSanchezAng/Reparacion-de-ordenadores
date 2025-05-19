class Usuario{
    private String nombre, direccion, tipo_cliente;
    private int contacto;

    //3 tipos de constructores (prederterminado, )
    Usuario(){
        nombre = " ";
        direccion = " ";
        contacto = 0;
        tipo_cliente = " ";
    }
    Usuario(String nombre, String direccion, int contacto, String tipo_cliente){
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
        this.tipo_cliente = tipo_cliente;
    }
    Usuario(Usuario u1){
        this.nombre = u1.nombre;
        this.direccion = u1.direccion;
        this.contacto = u1.contacto;
        this.tipo_cliente = u1.tipo_cliente;
    }

    //Setter de los atributos del usuario
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public void setContacto(int contacto){
        this.contacto = contacto;
    }
    public void setTipo_Cliente(String tipo_cliente){
        this.tipo_cliente = tipo_cliente;
    }

    //Getter de los atributos del usuario
    public String getNombre(){
        return nombre;
    }
    public String getDireccion(){
        return direccion;
    }
    public int getcontacto(){
        return contacto;
    }
    public String getTipo_Cliente(){
        return tipo_cliente;
    }

    //Devuelvo el regitro para probar que funcione bien
    public String toString(){
        return "Los datos del usuario son, nombre: " + nombre + " direccion: " + direccion + " contacto: " + contacto + " tipo de cliente: " + tipo_cliente;
    }
}