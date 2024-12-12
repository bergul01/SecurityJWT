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
@Table(name = "input_block")
@Entity
public class InputBlock extends BaseBlock{

	@Column(name = "input_value")
	private Integer value;
	
	@Override
	public Object execute() {
		
		return value;
	}

}
