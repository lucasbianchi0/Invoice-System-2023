package controller;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsuarioController {

    private static UsuarioController instancia;
    private List<Usuario> listaUsuarios;
    private Usuario usuarioActual;

    private UsuarioController() {
        listaUsuarios = new ArrayList<>();
        // Puedes agregar algunos usuarios de ejemplo
        agregarUsuario(new Usuario("user1", "Contraseña123"));
        agregarUsuario(new Usuario("user2", "OtraContraseña456"));
    }

    public static synchronized UsuarioController getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioController();
        }
        return instancia;
    }

    public Usuario login(String nombreUsuario) {
        // Implementa la lógica para buscar un usuario por nombre en la lista
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null;  // Retorna null si no se encuentra el usuario
    }

    public void agregarUsuario(Usuario usuario) {
        // Verificar si ya existe un usuario con el mismo nombre
        if (!existeUsuario(usuario.getNombreUsuario())) {
            // Asignar un ID único al usuario antes de agregarlo
            usuario.setId(UUID.randomUUID().toString());
            listaUsuarios.add(usuario);
        }
    }

    public boolean existeUsuario(String nombreUsuario) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return true; // El usuario ya existe
            }
        }
        return false;
    }

    public Usuario iniciarSesion(String nombreUsuario, String contrasena) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.verificarContrasena(contrasena)) {
                // Inicio de sesión exitoso
                usuarioActual = usuario;
                return usuario;
            }
        }
        // Inicio de sesión fallido
        return null;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void crearUsuario(String nombreUsuario, String contrasena) {
        Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasena);
        agregarUsuario(nuevoUsuario);
    }
}
