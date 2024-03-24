package MatheusP4ssos.com.github.ProjetoBancario.Domain;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends Persona {

    @NotNull
    private Integer function;

    private BigDecimal salary;

    public FunctionEmployee getFunction() {
        return FunctionEmployee.toEnum(this.function);
    }

    public void setFunction(FunctionEmployee function) {
        this.function = function.getCod();
    }

}