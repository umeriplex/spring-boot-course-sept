package tecqasr.spring.app.tecqasrcontent.model;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record Content (
        Integer id,
        @NotBlank
        String title,
        String description,
        Status status,
        Type contentType,
        LocalDate createdDate,
        LocalDate updatedDate,
        String url
)
{
}
