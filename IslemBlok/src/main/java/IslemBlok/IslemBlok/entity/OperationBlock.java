package IslemBlok.IslemBlok.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "operation_block")
@Entity
public class OperationBlock extends BaseBlock{

	@Column(name = "operation_type")
	private String operationType; //+ - * /
	
	@Column(name = "input1")
	private Integer input1;//null olabilceğinden veya başlangıçta atanmayabilceğinden Integer kullandık
	
	@Column(name = "input2")
	private Integer input2;
	
	@Override
	public Object execute() {
		
		 switch (operationType) {
         case "+":
             return input1 + input2;
         case "-":
             return input1 - input2;
         case "*":
             return input1 * input2;
         case "/":
             return input2 != 0 ? input1 / input2 : null; // Handle division by zero
         default:
             throw new IllegalArgumentException("Invalid operation type");
		 }
	}
	
}


