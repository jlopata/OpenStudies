package pl.jlopata.cd.utils.ExceptionsHandler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionMessage {

    private String name;
    private String message;
}
