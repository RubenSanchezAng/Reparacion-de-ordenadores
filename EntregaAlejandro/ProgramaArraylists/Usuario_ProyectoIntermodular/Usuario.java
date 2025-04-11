class Usuario{
    private String nombre, direccion, tipoCliente, contacto;

    //3 tipos de constructores (prederterminado, )
    Usuario(){
        nombre = " ";
        direccion = " ";
        contacto = "";
        tipoCliente = " ";
    }
    Usuario(String nombre, String direccion, String contacto, String tipocliente){
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
        this.tipoCliente = tipoCliente;
    }
    Usuario(Usuario u1){
        this.nombre = u1.nombre;
        this.direccion = u1.direccion;
        this.contacto = u1.contacto;
        this.tipoCliente = u1.tipoCliente;
    }

    //Setter de los atributos del usuario
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public void setContacto(String contacto){
        this.contacto = contacto;
    }
    public void setTipoCliente(String tipoCliente){
        this.tipoCliente = tipoCliente;
    }

    //Getter de los atributos del usuario
    public String getNombre(){
        return nombre;
    }
    public String getDireccion(){
        return direccion;
    }
    public String getContacto(){
        return contacto;
    }
    public String getTipoCliente(){
        return tipoCliente;
    }

    //Devuelvo el regitro para probar que funcione bien
    public String toString(){
        return "Los datos del usuario son nombre: " + nombre + " direccion: " + direccion + " contacto: " + contacto + " tipo de cliente: " + tipoCliente;
    }
}