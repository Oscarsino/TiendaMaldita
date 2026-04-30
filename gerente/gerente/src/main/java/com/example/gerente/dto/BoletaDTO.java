import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BoletaDTO {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {

        @NotBlank(message = "El id es obligatorio")
        @Size(min = 10, max = 12, message = "El id debe tener entre 2 y 12 caracteres")
        private int id_boleta;

    }

    /**
     * La respuesta incluye el GeneroDTO completo obtenido desde ms-genero via Feign. queeeeeeeee
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id_boleta;
    }
}