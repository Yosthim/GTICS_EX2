package com.example.gtics_ex2_20201497.Controller;

import com.example.gtics_ex2_20201497.Entity.Juegos;
import com.example.gtics_ex2_20201497.Entity.JuegosDTO;
import com.example.gtics_ex2_20201497.Repository.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class ApiController {
    private final JuegosRepository juegosRepository;
    private final PlataformasRepository plataformasRepository;
    private final EditorasRepository editorasRepository;
    private final GenerosRepository generosRepository;
    private final DistribuidorasRepository distribuidorasRepository;

    public ApiController(JuegosRepository juegosRepository, PlataformasRepository plataformasRepository, EditorasRepository editorasRepository, GenerosRepository generosRepository, DistribuidorasRepository distribuidorasRepository) {
        this.juegosRepository = juegosRepository;
        this.plataformasRepository = plataformasRepository;
        this.editorasRepository = editorasRepository;
        this.generosRepository = generosRepository;
        this.distribuidorasRepository = distribuidorasRepository;
    }

    //Listar juegos
    @GetMapping("/listar")
    public HashMap<String, Object> listarJuegos() {
        HashMap<String, Object> response = new HashMap<>();
        List<Juegos> listaJuegos = juegosRepository.findAll();
        response.put("result", "success");
        response.put("data", listaJuegos);

        return response;
    }

    //Gestión de excepciones
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, String>> handleException(HttpServletRequest request) {
        HashMap<String, String> response = new HashMap<>();
        if (request.getMethod().equals("POST") || request.getMethod().equals("PUT")) {
            response.put("result", "error");
            response.put("msg", "parámetros incorrectos");
        }
        return ResponseEntity.badRequest().body(response);
    }

    //Crear Juego
    @PostMapping(value = "/crear", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<HashMap<String, Object>> crearJuego(JuegosDTO juegosDTO) {
        HashMap<String, Object> response = new HashMap<>();
        if (juegosDTO.getNombre()!=null && juegosDTO.getDescripcion()!=null && juegosDTO.getPrecio()!=null && juegosDTO.getImage()!=null
                && juegosDTO.getIdgenero()>0 && juegosDTO.getIdeditora()>0 && juegosDTO.getIdplataforma()>0 && juegosDTO.getIddistribuidora()>0) {
            Juegos nuevoJuego = new Juegos();
            nuevoJuego.setNombre(juegosDTO.getNombre());
            nuevoJuego.setDescripcion(juegosDTO.getDescripcion());
            nuevoJuego.setPrecio(juegosDTO.getPrecio());
            nuevoJuego.setImage(juegosDTO.getImage());
            nuevoJuego.setEditora(editorasRepository.findById(juegosDTO.getIdeditora()).get());
            nuevoJuego.setGenero(generosRepository.findById(juegosDTO.getIdgenero()).get());
            nuevoJuego.setPlataforma(plataformasRepository.findById(juegosDTO.getIdplataforma()).get());
            nuevoJuego.setDistribuidora(distribuidorasRepository.findById(juegosDTO.getIddistribuidora()).get());

            //Se crea el producto
            juegosRepository.save(nuevoJuego);
            response.put("result", "success");
            response.put("data", nuevoJuego.getIdJuego());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            response.put("result", "error");
            response.put("msg", "Se deben enviar todos los parámetros requeridos");
            return ResponseEntity.badRequest().body(response);
        }
    }

    //Actualizar Juego
    @PutMapping(value = "/actualizar", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<HashMap<String, Object>> actualizarJuego(JuegosDTO juegosDTO) {
        HashMap<String, Object> response = new HashMap<>();
        if (juegosDTO.getIdJuego() > 0) {
            Optional<Juegos> optionalJuegos = juegosRepository.findById(juegosDTO.getIdJuego());
            if (optionalJuegos.isPresent()) {
                if (juegosDTO.getNombre()!=null && juegosDTO.getDescripcion()!=null && juegosDTO.getPrecio()!=null && juegosDTO.getImage()!=null
                        && juegosDTO.getIdgenero()>0 && juegosDTO.getIdeditora()>0 && juegosDTO.getIdplataforma()>0 && juegosDTO.getIddistribuidora()>0) {
                    Juegos nuevoJuego = new Juegos();
                    nuevoJuego.setIdJuego(juegosDTO.getIdJuego());
                    nuevoJuego.setNombre(juegosDTO.getNombre());
                    nuevoJuego.setDescripcion(juegosDTO.getDescripcion());
                    nuevoJuego.setPrecio(juegosDTO.getPrecio());
                    nuevoJuego.setImage(juegosDTO.getImage());
                    nuevoJuego.setEditora(editorasRepository.findById(juegosDTO.getIdeditora()).get());
                    nuevoJuego.setGenero(generosRepository.findById(juegosDTO.getIdgenero()).get());
                    nuevoJuego.setPlataforma(plataformasRepository.findById(juegosDTO.getIdplataforma()).get());
                    nuevoJuego.setDistribuidora(distribuidorasRepository.findById(juegosDTO.getIddistribuidora()).get());

                    //Se crea el producto
                    juegosRepository.save(nuevoJuego);
                    response.put("result", "success");
                    response.put("data", nuevoJuego.getIdJuego());
                    return ResponseEntity.ok(response);
                } else {
                    response.put("result", "error");
                    response.put("msg", "Se deben enviar todos los parámetros requeridos");
                    return ResponseEntity.badRequest().body(response);
                }
            } else {
                response.put("result", "error");
                response.put("msg", "El juego a actualizar no existe");
                return ResponseEntity.badRequest().body(response);
            }
        } else {
            response.put("result", "error");
            response.put("msg", "Se deben enviar un ID válido");
            return ResponseEntity.badRequest().body(response);
        }
    }

}
